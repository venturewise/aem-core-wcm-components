package com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.extender;

import com.adobe.cq.wcm.core.components.models.datalayer.AssetData;
import com.adobe.cq.wcm.core.components.models.datalayer.ImageData;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.DataLayerSupplier;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.function.Supplier;

public final class ImageComponentDataExtenderSupplier extends ComponentDataExtenderSupplier implements DataLayerSupplier {

    @NotNull
    private final ImageData data;

    public ImageComponentDataExtenderSupplier(@NotNull final ImageData componentData) {
        super(componentData);
        this.data = componentData;
    }

    @Override
    @NotNull
    public final Optional<Supplier<AssetData>> getAssetData()  {
        return Optional.of(this.data::getAssetData);
    }

}
