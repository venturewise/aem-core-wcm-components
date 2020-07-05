/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 ~ Copyright 2019 Adobe
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

import com.day.cq.commons.jcr.JcrConstants;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.adobe.cq.wcm.core.components.models.Component;
import com.adobe.cq.wcm.core.components.models.datalayer.ComponentData;
import com.adobe.cq.wcm.core.components.models.datalayer.DataLayerUtils;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.DataLayerBuilder;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.components.ComponentContext;

import java.util.Calendar;
import java.util.Optional;

/**
 * Abstract class that can be used as a base class for {@link Component} implementations.
 */
public abstract class AbstractComponentImpl implements Component {

    // private static final Logger LOGGER = LoggerFactory.getLogger(AbstractComponentImpl.class);

    @SlingObject
    protected Resource resource;

    @ScriptVariable(injectionStrategy = InjectionStrategy.OPTIONAL)
    @Nullable
    protected ComponentContext componentContext;

    @ScriptVariable(injectionStrategy = InjectionStrategy.OPTIONAL)
    @Nullable
    private Page currentPage;

    private String id;
    private Boolean dataLayerEnabled;
    private ComponentData componentData;

    @Nullable
    @Override
    public String getId() {
        if (id == null) {
            this.id = DataLayerUtils.getPropertyOrGeneratedId(this.resource, this.currentPage, this.componentContext);
        }
        return id;
    }

    @NotNull
    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

    /**
     * See {@link Component#getData()}
     *
     * @return The component data
     */
    @Override
    @Nullable
    public ComponentData getData() {
        if (componentData == null) {
            if (this.dataLayerEnabled == null) {
                this.dataLayerEnabled = DataLayerUtils.isDataLayerEnabled(this.resource);
            }
            if (this.dataLayerEnabled) {
                componentData = getComponentData();
            }
        }
        return componentData;
    }

    /**
     * Override this method to provide a different data model for your component. This will be called by
     * {@link AbstractComponentImpl#getData()} in case the datalayer is activated.
     *
     * @return The component data.
     */
    @NotNull
    protected ComponentData getComponentData() {
        return DataLayerBuilder.forComponent()
            .withId(this::getId)
            .withLastModifiedDate(() ->
                // Note: this can be simplified in JDK 11
                Optional.ofNullable(resource.getValueMap().get(JcrConstants.JCR_LASTMODIFIED, Calendar.class))
                    .map(Calendar::getTime)
                    .orElseGet(() ->
                        Optional.ofNullable(resource.getValueMap().get(JcrConstants.JCR_CREATED, Calendar.class))
                            .map(Calendar::getTime)
                            .orElse(null)))
            .withType(() -> this.resource.getResourceType())
            .build();
    }
}
