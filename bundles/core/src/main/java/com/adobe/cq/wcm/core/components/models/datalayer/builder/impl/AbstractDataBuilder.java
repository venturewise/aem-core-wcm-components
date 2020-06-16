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
package com.adobe.cq.wcm.core.components.models.datalayer.builder.impl;

import com.adobe.cq.wcm.core.components.models.datalayer.builder.GenericDataBuilder;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.DataLayerSupplier;
import org.jetbrains.annotations.NotNull;

/**
 * Abstract data builder.
 *
 * All data builders should extend this class.
 *
 * @param <T> The builder type.
 * @param <K> The data layer type.
 */
abstract class AbstractDataBuilder<T extends GenericDataBuilder<T, K>, K> {

    /**
     * The current data layer supplier.
     */
    private final DataLayerSupplier dataLayerSupplier;

    /**
     * Construct an Abstract Data Builder.
     *
     * @param supplier The data layer supplier.
     */
    protected AbstractDataBuilder(@NotNull final DataLayerSupplier supplier) {
        this.dataLayerSupplier = supplier;
    }

    /**
     * Get the current {@link DataLayerSupplier}.
     *
     * @return The current data layer supplier.
     */
    @NotNull
    protected DataLayerSupplier getDataLayerSupplier() {
        return this.dataLayerSupplier;
    }

    /**
     * Create a new instance of the the current wrapper using the specified supplier.
     *
     * @param supplier The data layer supplier to wrap.
     * @return The wrapped data layer supplier.
     */
    @NotNull
    abstract T createInstance(@NotNull final DataLayerSupplier supplier);

}
