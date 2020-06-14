package com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.fields;

import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.DataLayerSupplier;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.DataLayerSupplierWrapper;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * A DataLayerSupplier wrapper that overrides the shown items field.
 */
public final class ShownItemsFieldWrapper extends DataLayerSupplierWrapper {

    /**
     * The shown items value supplier.
     */
    @NotNull
    private final Supplier<String[]> supplier;

    /**
     * Construct a DataLayerSupplier that overrides the shown items field.
     *
     * @param dataLayerSupplier The wrapped data layer supplier.
     * @param supplier          The shown items value supplier.
     */
    public ShownItemsFieldWrapper(@NotNull final DataLayerSupplier dataLayerSupplier, @NotNull final Supplier<String[]> supplier) {
        super(dataLayerSupplier);
        this.supplier = supplier;
    }

    @Override
    @NotNull
    public Optional<Supplier<String[]>> getShownItems() {
        return Optional.of(this.supplier);
    }
}
