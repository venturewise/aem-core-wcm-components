/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 ~ Copyright 2017 Adobe
 ~
 ~ Licensed under the Apache License, Version 2.0 (the "License");
 ~ you may not use this file except in compliance with the License.
 ~ You may obtain a copy of the License at
 ~
 ~     http://www.apache.org/licenses/LICENSE-2.0
 ~
 ~ Unless required by applicable law or agreed to in writing, software
 ~ distributed under the License is distributed on an "AS IS" BASIS,
 ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 ~ See the License for the specific language governing permissions and
 ~ limitations under the License.
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
package com.adobe.cq.wcm.core.components.testing;

import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.day.cq.commons.inherit.HierarchyNodeInheritanceValueMap;
import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.wcm.api.PageManager;
import com.day.text.Text;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;

import com.day.cq.commons.Language;
import com.day.cq.commons.LanguageUtil;
import com.day.cq.wcm.api.LanguageManager;
import com.day.cq.wcm.api.Page;
import org.jetbrains.annotations.NotNull;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class MockLanguageManager implements LanguageManager {

    @Override
    public String getIsoCountry(Locale locale) {
        throw new NotImplementedException();
    }

    @Override
    @Deprecated
    public Map<Locale, Info> getAdjacentInfo(ResourceResolver resourceResolver, String path) {
        return Optional.ofNullable(getAdjacentLanguageInfo(resourceResolver, path))
            .map(Map::entrySet)
            .map(Collection::stream)
            .map(entries -> entries.collect(Collectors.toMap(i -> i.getKey().getLocale(), Map.Entry::getValue)))
            .orElse(null);
    }

    @Override
    public Map<Language, Info> getAdjacentLanguageInfo(ResourceResolver resourceResolver, String path) {
        return Optional.ofNullable(LanguageUtil.getLanguageRoot(path))
            .map(root -> path.substring(root.length()))
            .map(relPath -> relPath.startsWith("/") ? relPath.substring(1) : relPath)
            .map(relPath ->
                this.getLanguageRootStream(resourceResolver, path)
                    .map(info -> info.getChild(relPath, resourceResolver))
                    .collect(Collectors.toMap(InfoImpl::getLanguage, i -> (Info) i)))
            .orElse(null);
    }

    @Override
    public Locale getLanguage(Resource resource) {
        return this.getLanguage(resource, true);
    }

    @Override
    public Language getCqLanguage(Resource resource) {
        return this.getCqLanguage(resource, true);
    }

    @Override
    public Locale getLanguage(Resource resource, boolean respectContent) {
        return Optional.ofNullable(getCqLanguage(resource, respectContent))
            .map(Language::getLocale)
            .orElse(null);
    }

    @Override
    public Language getCqLanguage(Resource resource, boolean respectContent) {
        Optional<Page> page = Optional.ofNullable(resource.getResourceResolver().adaptTo(PageManager.class))
            .map(pm -> pm.getContainingPage(resource));

        if (respectContent) {
            return page
                .map(Page::getContentResource)
                .map(HierarchyNodeInheritanceValueMap::new)
                .map(vm -> vm.getInherited(JcrConstants.JCR_LANGUAGE, String.class))
                .map(LanguageUtil::getLanguage)
                .orElseGet(() -> this.getCqLanguage(resource, false));
        }

        return page
            .map(Page::getPath)
            .map(LanguageUtil::getLanguageRoot)
            .map(Text::getName)
            .map(Language::new)
            .orElse(null);
    }

    @Override
    public Page getLanguageRoot(Resource resource) {
        return Optional.ofNullable(LanguageUtil.getLanguageRoot(resource.getPath()))
            .map(resource.getResourceResolver()::getResource)
            .map(res -> res.adaptTo(Page.class))
            .orElse(null);
    }

    @Override
    public Collection<Locale> getLanguages(ResourceResolver resourceResolver, String path) {
        return this.getCqLanguages(resourceResolver, path).stream()
            .map(Language::getLocale)
            .collect(Collectors.toList());
    }

    @Override
    public Collection<Language> getCqLanguages(ResourceResolver resourceResolver, String path) {
        return this.getLanguageRootStream(resourceResolver, path)
            .map(InfoImpl::getLanguage)
            .collect(Collectors.toList());
    }

    @Override
    public Collection<Page> getLanguageRoots(ResourceResolver resourceResolver, String path) {
        return this.getLanguageRootStream(resourceResolver, path)
            .map(InfoImpl::getResource)
            .map(res -> res.adaptTo(Page.class))
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    }

    private Stream<InfoImpl> getLanguageRootStream(ResourceResolver resourceResolver, String path) {
        return Optional.ofNullable(LanguageUtil.getLanguageRoot(path))
            .map(resourceResolver::getResource)
            .map(Resource::getParent)
            .map(Resource::listChildren)
            .map(childIterator -> StreamSupport.stream(((Iterable<Resource>) () -> childIterator).spliterator(), false))
            .orElseGet(Stream::empty)
            .filter(res -> Objects.nonNull(LanguageUtil.getLanguage(res.getName())))
            .map(res -> new InfoImpl(res.getPath(), res, LanguageUtil.getLanguage(res.getName())));
    }

    @Override
    public Tree compareLanguageTrees(ResourceResolver resourceResolver, String s) {
        throw new NotImplementedException();
    }

    private static final class InfoImpl implements LanguageManager.Info {
        private final String path;
        private final Resource resource;
        private final Language language;

        public InfoImpl(final String path, final Resource resource, final Language language) {
            this.path = path;
            this.resource = resource;
            this.language = language;
        }

        @Override
        public String getPath() { return this.path; }

        @Override
        public boolean exists() {
            return this.resource != null;
        }

        @Override
        public boolean hasContent() {
            return Optional.ofNullable(this.resource)
                .map(res -> resource.getChild(JcrConstants.JCR_CONTENT))
                .isPresent();
        }

        @Override
        public long getLastModified() {
            return Optional.ofNullable(this.resource)
                .map(res -> resource.getChild(JcrConstants.JCR_CONTENT))
                .map(Resource::getValueMap)
                .map(vm -> vm.get(JcrConstants.JCR_LASTMODIFIED, Long.class))
                .orElse(0L);
        }

        private Resource getResource() {
            return this.resource;
        }

        private Language getLanguage() {
            return this.language;
        }

        /**
         * Gets the InfoImpl for a child resource under the current InfoImpl's path.
         *
         * This constructs a new InfoImpl using the path getPath() + / + relPath.
         *
         * @param relPath Path relative to the current path.
         * @param resourceResolver A resource resolver.
         * @return A new InfoImpl for the resource specified at relPath.
         */
        private InfoImpl getChild(@NotNull final String relPath, @NotNull final ResourceResolver resourceResolver) {
            if (relPath.isEmpty()) {
                return this;
            }
            String path = String.join("/", this.path, relPath);
            Resource child = resourceResolver.getResource(path);
            return new InfoImpl(path, child, this.getLanguage());
        }
    }
}

