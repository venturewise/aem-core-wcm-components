package com.adobe.cq.wcm.core.components.models.datalayer.builder;

import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.AssetDataBuilderImpl;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.ComponentDataBuilderImpl;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.ContainerDataBuilderImpl;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.AssetDataLayerSupplier;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.DataLayerSupplier;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.ImageComponentDataBuilderImpl;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.PageDataBuilderImpl;
import com.day.cq.dam.api.Asset;
import org.jetbrains.annotations.NotNull;

public final class DataLayerBuilder {

    /**
     * An empty DataLayerSupplier which has null values for all field value suppliers.
     */
    private static final DataLayerSupplier EMPTY_SUPPLIER = new DataLayerSupplier() {
    };

    /**
     * Private constructor to prevent instantiation of utility class.
     */
    private DataLayerBuilder() {
        // NOOP
    }

    public static ComponentDataBuilder forComponent() {
        return new ComponentDataBuilderImpl(EMPTY_SUPPLIER);
    }

    public static ContainerDataBuilder forContainer() {
        return new ContainerDataBuilderImpl(EMPTY_SUPPLIER);
    }

    public static ImageComponentDataBuilder forImageComponent() {
        return new ImageComponentDataBuilderImpl(EMPTY_SUPPLIER);
    }

    public static AssetDataBuilder forAsset() {
        return new AssetDataBuilderImpl(EMPTY_SUPPLIER);
    }

    public static AssetDataBuilder forAsset(@NotNull final Asset asset) {
        return new AssetDataBuilderImpl(new AssetDataLayerSupplier(asset));
    }

    public static PageDataBuilder forPage() {
        return new PageDataBuilderImpl(EMPTY_SUPPLIER);
    }

}
