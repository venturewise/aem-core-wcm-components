/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 ~ Copyright 2019 Adobe Systems Incorporated
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
package com.adobe.cq.wcm.core.components.internal.models.v1;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.jetbrains.annotations.NotNull;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.adobe.cq.wcm.core.components.models.SocialMediaFragment;

@Model(adaptables = SlingHttpServletRequest.class,
       adapters = {SocialMediaFragment.class, ComponentExporter.class},
       resourceType = {SocialMediaFragmentImpl.RESOURCE_TYPE_V1})
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class SocialMediaFragmentImpl implements SocialMediaFragment {

    protected static final String RESOURCE_TYPE_V1 = "core/wcm/components/social/v1/social";

    @ValueMapValue(name = PN_URL, injectionStrategy = InjectionStrategy.OPTIONAL)
    private String url;

    @Inject @Optional
    private List<Processor> processors;

    @Inject
    private Resource resource;

    private Processor processor;

    @PostConstruct
    private void initModel() {
        if (processors != null) {
            for (Processor processor : processors) {
                if (processor.accepts(this.url)) {
                    this.processor = processor;
                }
            }
        }
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public Processor getProcessor() {
        return processor;
    }

    @NotNull
    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }
}
