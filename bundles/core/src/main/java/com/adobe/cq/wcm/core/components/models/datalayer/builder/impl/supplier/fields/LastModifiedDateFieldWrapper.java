package com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.fields;

import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.DataLayerSupplier;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.DataLayerSupplierWrapper;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * A {@link DataLayerSupplier} wrapper that overrides the last modified date field.
 */
public class LastModifiedDateFieldWrapper extends DataLayerSupplierWrapper {

    /**
     * The last modified date value supplier.
     */
    @NotNull
    final Supplier<Date> supplier;

    /**
     * Construct a {@link DataLayerSupplier} that overrides the last modified date field.
     *
     * @param dataLayerSupplier The wrapped data layer supplier.
     * @param supplier          The last modified date value supplier.
     */
    public LastModifiedDateFieldWrapper(@NotNull final DataLayerSupplier dataLayerSupplier, @NotNull final Supplier<Date> supplier) {
        super(dataLayerSupplier);
        this.supplier = supplier;
    }

    @Override
    @NotNull
    public Optional<Supplier<Date>> getLastModifiedDate() {
        return Optional.of(this.supplier);
    }
}
