package com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.fields;

import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.DataLayerSupplier;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.DataLayerSupplierWrapper;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * A DataLayerSupplier wrapper that overrides the format field.
 */
public final class FormatFieldWrapper extends DataLayerSupplierWrapper {

    /**
     * The format value supplier.
     */
    @NotNull
    final Supplier<String> supplier;

    /**
     * Construct a DataLayerSupplier that overrides the format field.
     *
     * @param dataLayerSupplier The wrapped data layer supplier.
     * @param supplier          The format value supplier.
     */
    public FormatFieldWrapper(@NotNull final DataLayerSupplier dataLayerSupplier, @NotNull final Supplier<String> supplier) {
        super(dataLayerSupplier);
        this.supplier = supplier;
    }

    @Override
    @NotNull
    public Optional<Supplier<String>> getText() {
        return Optional.of(this.supplier);
    }
}
