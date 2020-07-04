/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 ~ Copyright 2020 Adobe
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
package com.adobe.cq.wcm.core.components.models.datalayer;

import com.adobe.cq.wcm.core.components.internal.DataLayerConfig;
import com.adobe.cq.wcm.core.components.internal.Utils;
import com.adobe.cq.wcm.core.components.models.Component;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.Template;
import com.day.cq.wcm.api.components.ComponentContext;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.caconfig.ConfigurationBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

import static com.adobe.cq.wcm.core.components.internal.Utils.ID_SEPARATOR;

/**
 * Utility helper functions for Data Layer.
 */
public final class DataLayerUtils {

    /**
     * Private constructor to prevent instantiation of utility class.
     */
    private DataLayerUtils() {
        // NOOP
    }

    /**
     * Check if data layer is enabled.
     *
     * @param resource The resource to check.
     * @return True if data layer is enabled for this resource, false otherwise.
     */
    public static boolean isDataLayerEnabled(@NotNull final Resource resource) {
        return Optional.ofNullable(resource.adaptTo(ConfigurationBuilder.class))
            .map(builder -> builder.as(DataLayerConfig.class))
            .map(DataLayerConfig::enabled)
            .orElse(false);
    }

    /**
     * Get the ID property value if set (using {@link #getPropertyId(Resource)},
     * otherwise generate a new ID (using {@link #generateId(Resource, Page, ComponentContext)}.
     *
     * @param resource The resource for which to get or generate an ID.
     * @param currentPage The current request page.
     * @param componentContext The current component context.
     * @return The ID property value for the specified resource, or a generated ID if not set.
     */
    @NotNull
    public static String getPropertyOrGeneratedId(@NotNull final Resource resource,
                                                  @Nullable final Page currentPage,
                                                  @Nullable final ComponentContext componentContext) {
        return DataLayerUtils.getPropertyId(resource)
            .orElseGet(() -> DataLayerUtils.generateId(resource, currentPage, componentContext));
    }

    /**
     * Get the ID value from the &quot;{@value Component#PN_ID}&quot; property.
     *
     * @param resource The resource for which to get the ID property value.
     * @return The ID property value if set, empty optional if not.
     */
    public static Optional<String> getPropertyId(@NotNull final Resource resource) {
        return Optional.ofNullable(resource.getValueMap().get(Component.PN_ID, String.class))
            .filter(StringUtils::isNotEmpty)
            .map(StringUtils::trim)
            .map(StringUtils::normalizeSpace)
            .map(val -> StringUtils.replace(val, " ", ID_SEPARATOR));
    }

    /**
     * Returns an auto generated component ID.
     *
     * The ID is the first 10 characters of an SHA-1 hexadecimal hash of the component path,
     * prefixed with the component name. Example: title-810f3af321
     *
     * If the component is referenced, the path is taken to be a concatenation of the component path,
     * with the path of the first parent context resource that exists on the page or in the template.
     * This ensures the ID is unique if the same component is referenced multiple times on the same page or template.
     *
     * Collision
     * ---------
     * c = expected collisions
     * c ~= (i^2)/(2m) - where i is the number of items and m is the number of possibilities for each item.
     * m = 16^n - for a hexadecimal string, where n is the number of characters.
     *
     * For i = 1000 components with the same name, and n = 10 characters:
     *
     * c ~= (1000^2)/(2*(16^10))
     * c ~= 0.00000045
     *
     * @return the auto generated component ID
     */
    @NotNull
    public static String generateId(@NotNull final Resource resource,
                                    @Nullable final Page currentPage,
                                    @Nullable final ComponentContext componentContext) {
        String resourceType = resource.getResourceType();
        String prefix = StringUtils.substringAfterLast(resourceType, "/");
        String path = resource.getPath();
        if (currentPage != null && componentContext != null) {
            PageManager pageManager = currentPage.getPageManager();
            Page resourcePage = pageManager.getContainingPage(resource);
            Template template = currentPage.getTemplate();
            boolean inCurrentPage = (resourcePage != null && StringUtils.equals(resourcePage.getPath(), currentPage.getPath()));
            boolean inTemplate = (template != null && path.startsWith(template.getPath()));
            if (!inCurrentPage && !inTemplate) {
                ComponentContext parentContext = componentContext.getParent();
                while (parentContext != null) {
                    Resource parentContextResource = parentContext.getResource();
                    if (parentContextResource != null) {
                        Page parentContextPage = pageManager.getContainingPage(parentContextResource);
                        inCurrentPage = (parentContextPage != null && StringUtils.equals(parentContextPage.getPath(), currentPage.getPath()));
                        inTemplate = (template != null && parentContextResource.getPath().startsWith(template.getPath()));
                        if (inCurrentPage || inTemplate) {
                            path = parentContextResource.getPath().concat(resource.getPath());
                            break;
                        }
                    }
                    parentContext = parentContext.getParent();
                }
            }

        }

        return Utils.generateId(prefix, path);
    }
}
