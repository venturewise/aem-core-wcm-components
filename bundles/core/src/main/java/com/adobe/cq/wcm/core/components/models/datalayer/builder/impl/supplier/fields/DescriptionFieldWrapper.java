package com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.fields;

import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.DataLayerSupplier;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.DataLayerSupplierWrapper;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * A DataLayerSupplier wrapper that overrides the description field.
 */
public final class DescriptionFieldWrapper extends DataLayerSupplierWrapper {

    /**
     * The description value supplier.
     */
    @NotNull
    final Supplier<String> supplier;

    /**
     * Construct a DataLayerSupplier that overrides the description field.
     *
     * @param dataLayerSupplier The wrapped data layer supplier.
     * @param supplier          The description value supplier.
     */
    public DescriptionFieldWrapper(@NotNull final DataLayerSupplier dataLayerSupplier, @NotNull final Supplier<String> supplier) {
        super(dataLayerSupplier);
        this.supplier = supplier;
    }

    @Override
    public @NotNull Optional<Supplier<String>> getDescription() {
        return Optional.of(this.supplier);
    }
}
