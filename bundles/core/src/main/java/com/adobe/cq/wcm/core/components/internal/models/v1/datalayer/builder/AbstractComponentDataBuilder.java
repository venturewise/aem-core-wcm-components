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
package com.adobe.cq.wcm.core.components.internal.models.v1.datalayer.builder;

import com.adobe.cq.wcm.core.components.internal.models.v1.datalayer.builder.supplier.DataLayerSupplier;
import com.adobe.cq.wcm.core.components.internal.models.v1.datalayer.builder.supplier.DataLayerSupplierWrapper;
import com.adobe.cq.wcm.core.components.models.datalayer.ComponentData;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.GenericComponentDataBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.function.Supplier;

/**
 * Abstract component data builder.
 *
 * All data builders that produce {@link ComponentData} should extend this class.
 *
 * @param <T> The data builder type.
 * @param <K> The data type.
 */
abstract class AbstractComponentDataBuilder<T extends GenericComponentDataBuilder<T, K>, K extends ComponentData>
    extends AbstractDataBuilder<T, K>
    implements GenericComponentDataBuilder<T, K> {

    /**
     * Construct an abstract component data builder.
     *
     * @param supplier The data layer supplier.
     */
    protected AbstractComponentDataBuilder(@NotNull final DataLayerSupplier supplier) {
        super(supplier);
    }

    @Override
    @NotNull
    public T withId(@NotNull final Supplier<@NotNull String> supplier) {
        return this.createInstance(new DataLayerSupplierWrapper(this.getDataLayerSupplier()).setId(supplier));
    }

    @Override
    @NotNull
    public T withType(@NotNull final Supplier<String> supplier) {
        return this.createInstance(new DataLayerSupplierWrapper(this.getDataLayerSupplier()).setType(supplier));
    }

    @Override
    @NotNull
    public T withLastModifiedDate(@NotNull final Supplier<Date> supplier) {
        return this.createInstance(new DataLayerSupplierWrapper(this.getDataLayerSupplier()).setLastModifiedDate(supplier));
    }

    @Override
    @NotNull
    public T withParentId(@NotNull final Supplier<String> supplier) {
        return this.createInstance(new DataLayerSupplierWrapper(this.getDataLayerSupplier()).setParentId(supplier));
    }

    @Override
    @NotNull
    public T withTitle(@NotNull final Supplier<String> supplier) {
        return this.createInstance(new DataLayerSupplierWrapper(this.getDataLayerSupplier()).setTitle(supplier));
    }

    @Override
    @NotNull
    public T withDescription(@NotNull final Supplier<String> supplier) {
        return this.createInstance(new DataLayerSupplierWrapper(this.getDataLayerSupplier()).setDescription(supplier));
    }

    @Override
    @NotNull
    public T withText(@NotNull final Supplier<String> supplier) {
        return this.createInstance(new DataLayerSupplierWrapper(this.getDataLayerSupplier()).setText(supplier));
    }

    @Override
    @NotNull
    public T withLinkUrl(@NotNull final Supplier<String> supplier) {
        return this.createInstance(new DataLayerSupplierWrapper(this.getDataLayerSupplier()).setLinkUrl(supplier));
    }

}
