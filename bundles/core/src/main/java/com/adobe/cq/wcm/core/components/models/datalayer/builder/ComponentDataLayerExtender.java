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
package com.adobe.cq.wcm.core.components.models.datalayer.builder;

import org.jetbrains.annotations.NotNull;

/**
 * Component data layer extender.
 *
 * Used to extend existing component data layer models.
 */
public interface ComponentDataLayerExtender {

    /**
     * Get a ComponentDataBuilder that extends existing component data.
     *
     * @return A new ComponentDataBuilder pre-initialized with the existing component data.
     */
    @NotNull
    default ComponentDataBuilder asComponent() {
        throw new UnsupportedOperationException();
    }

    /**
     * Get a ContainerDataBuilder that extends existing component data.
     *
     * @return A new ContainerDataBuilder pre-initialized with the existing container data.
     */
    @NotNull
    default ContainerDataBuilder asContainer() {
        throw new UnsupportedOperationException();
    }

    /**
     * Get a PageDataBuilder that extends existing component data.
     *
     * @return A new PageDataBuilder pre-initialized with the existing page data.
     */
    @NotNull
    default PageDataBuilder asPage() {
        throw new UnsupportedOperationException();
    }

    /**
     * Get a ImageComponentDataBuilder that extends existing component data.
     *
     * @return A new ImageComponentDataBuilder pre-initialized with the existing image component data.
     */
    @NotNull
    default ImageComponentDataBuilder asImageComponent() {
        throw new UnsupportedOperationException();
    }
}
