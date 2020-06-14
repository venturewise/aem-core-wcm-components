package com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.fields;

import com.adobe.cq.wcm.core.components.models.datalayer.AssetData;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.DataLayerSupplier;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.DataLayerSupplierWrapper;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * A DataLayerSupplier wrapper that overrides the asset data field.
 */
public final class AssetDataFieldWrapper extends DataLayerSupplierWrapper {

    /**
     * The asset data value supplier.
     */
    @NotNull
    final Supplier<AssetData> supplier;

    /**
     * Construct a DataLayerSupplier that overrides the asset data field.
     *
     * @param dataLayerSupplier The wrapped data layer supplier.
     * @param supplier          The asset data value supplier.
     */
    public AssetDataFieldWrapper(@NotNull final DataLayerSupplier dataLayerSupplier, @NotNull final Supplier<AssetData> supplier) {
        super(dataLayerSupplier);
        this.supplier = supplier;
    }

    @Override
    @NotNull
    public Optional<Supplier<AssetData>> getAssetData() {
        return Optional.of(this.supplier);
    }
}
