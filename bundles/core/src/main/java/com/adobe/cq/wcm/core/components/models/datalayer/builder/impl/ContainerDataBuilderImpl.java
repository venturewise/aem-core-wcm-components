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

import com.adobe.cq.wcm.core.components.models.datalayer.ContainerData;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.ContainerDataBuilder;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.DataLayerSupplier;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.fields.ShownItemsFieldWrapper;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

/**
 * Data builder for container components.
 */
public final class ContainerDataBuilderImpl
    extends AbstractComponentDataBuilder<ContainerDataBuilder, ContainerData>
    implements ContainerDataBuilder {

    /**
     * Construct a data builder for a container component.
     *
     * @param supplier The data layer supplier.
     */
    public ContainerDataBuilderImpl(@NotNull final DataLayerSupplier supplier) {
        super(supplier);
    }

    @Override
    @NotNull
    public ContainerDataBuilder withShownItems(@NotNull final Supplier<String[]> supplier) {
        return this.createInstance(new ShownItemsFieldWrapper(this.getDataLayerSupplier(), supplier));
    }

    @Override
    @NotNull
    ContainerDataBuilderImpl createInstance(@NotNull final DataLayerSupplier supplier) {
        return new ContainerDataBuilderImpl(supplier);
    }

    @NotNull
    @Override
    public ContainerData build() {
        return new ComponentDataImpl(this.getDataLayerSupplier());
    }
}
