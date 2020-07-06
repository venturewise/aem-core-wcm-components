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
import com.adobe.cq.wcm.core.components.models.datalayer.AssetData;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.AssetDataBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.function.Supplier;

/**
 * Data builder for Assets.
 */
public final class AssetDataBuilderImpl extends AbstractDataBuilder<AssetDataBuilder, AssetData> implements AssetDataBuilder {

    /**
     * Construct an Asset Data Builder.
     *
     * @param supplier The data layer supplier.
     */
    public AssetDataBuilderImpl(@NotNull final DataLayerSupplier supplier) {
        super(supplier);
    }

    @Override
    @NotNull
    AssetDataBuilder createInstance(@NotNull DataLayerSupplier supplier) {
        return new AssetDataBuilderImpl(supplier);
    }

    @Override
    @NotNull
    public AssetDataBuilder withId(@NotNull final Supplier<String> supplier) {
        return this.createInstance(new DataLayerSupplierWrapper(this.getDataLayerSupplier()).setId(supplier));
    }

    @Override
    @NotNull
    public AssetDataBuilder withUrl(@NotNull Supplier<String> supplier) {
        return this.createInstance(new DataLayerSupplierWrapper(this.getDataLayerSupplier()).setUrl(supplier));
    }

    @Override
    @NotNull
    public AssetDataBuilder withFormat(@NotNull Supplier<String> supplier) {
        return this.createInstance(new DataLayerSupplierWrapper(this.getDataLayerSupplier()).setFormat(supplier));
    }

    @Override
    @NotNull
    public AssetDataBuilder withTags(@NotNull Supplier<String[]> supplier) {
        return this.createInstance(new DataLayerSupplierWrapper(this.getDataLayerSupplier()).setTags(supplier));
    }

    @Override
    @NotNull
    public AssetDataBuilder withLastModifiedDate(@NotNull final Supplier<Date> supplier) {
        return this.createInstance(new DataLayerSupplierWrapper(this.getDataLayerSupplier()).setLastModifiedDate(supplier));
    }

    @Override
    @NotNull
    public AssetData build() {
        return new AssetDataImpl(this.getDataLayerSupplier());
    }
}
