package com.adobe.cq.wcm.core.components.models.datalayer.builder.impl;

import com.adobe.cq.wcm.core.components.models.datalayer.AssetData;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.AssetDataBuilder;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.DataLayerSupplier;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.fields.FormatFieldWrapper;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.fields.IdFieldWrapper;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.fields.LastModifiedDateFieldWrapper;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.fields.TagsFieldWrapper;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.fields.UrlFieldWrapper;
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
        return this.createInstance(new IdFieldWrapper(this.getDataLayerSupplier(), supplier));
    }

    @Override
    @NotNull
    public AssetDataBuilder withUrl(@NotNull Supplier<String> supplier) {
        return this.createInstance(new UrlFieldWrapper(this.getDataLayerSupplier(), supplier));
    }

    @Override
    @NotNull
    public AssetDataBuilder withFormat(@NotNull Supplier<String> supplier) {
        return this.createInstance(new FormatFieldWrapper(this.getDataLayerSupplier(), supplier));
    }

    @Override
    @NotNull
    public AssetDataBuilder withTags(@NotNull Supplier<String[]> supplier) {
        return this.createInstance(new TagsFieldWrapper(this.getDataLayerSupplier(), supplier));
    }

    @Override
    @NotNull
    public AssetDataBuilder withLastModifiedDate(@NotNull final Supplier<Date> supplier) {
        return this.createInstance(new LastModifiedDateFieldWrapper(this.getDataLayerSupplier(), supplier));
    }

    @Override
    @NotNull
    public AssetData build() {
        return new AssetDataImpl(this.getDataLayerSupplier());
    }
}
