package com.adobe.cq.wcm.core.components.models.datalayer.builder;

import com.adobe.cq.wcm.core.components.models.datalayer.AssetData;
import com.adobe.cq.wcm.core.components.models.datalayer.ImageData;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

/**
 * Data layer builder for image components.
 */
public interface ImageComponentDataBuilder extends GenericComponentDataBuilder<ImageComponentDataBuilder, ImageData> {

    /**
     * Set the supplier that supplies the component's asset data.
     *
     * @param supplier The asset data value supplier.
     * @return A new {@link ImageComponentDataBuilder}.
     */
    @NotNull
    ImageComponentDataBuilder withAssetData(@NotNull Supplier<AssetData> supplier);
}
