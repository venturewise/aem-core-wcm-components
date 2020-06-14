package com.adobe.cq.wcm.core.components.models.datalayer.builder.impl;

import com.adobe.cq.wcm.core.components.models.datalayer.AssetData;
import com.adobe.cq.wcm.core.components.models.datalayer.ImageData;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.ImageComponentDataBuilder;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.fields.AssetDataFieldWrapper;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.DataLayerSupplier;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

/**
 * Data layer builder implementation for image components.
 */
public class ImageComponentDataBuilderImpl
    extends AbstractComponentDataBuilder<ImageComponentDataBuilder, ImageData>
    implements ImageComponentDataBuilder {

    /**
     * Construct a data layer builder for an image component.
     *
     * @param supplier The data layer supplier.
     */
    public ImageComponentDataBuilderImpl(@NotNull final DataLayerSupplier supplier) {
        super(supplier);
    }

    @Override
    @NotNull
    public ImageComponentDataBuilderImpl withAssetData(@NotNull final Supplier<AssetData> supplier) {
        return this.createInstance(new AssetDataFieldWrapper(this.getDataLayerSupplier(), supplier));
    }

    @Override
    @NotNull
    ImageComponentDataBuilderImpl createInstance(@NotNull final DataLayerSupplier supplier) {
        return new ImageComponentDataBuilderImpl(supplier);
    }

    @NotNull
    @Override
    public ImageData build() {
        return new ImageComponentDataImpl(this.getDataLayerSupplier());
    }
}
