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
