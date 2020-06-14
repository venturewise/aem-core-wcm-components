package com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.fields;

import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.DataLayerSupplier;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.DataLayerSupplierWrapper;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * A DataLayerSupplier wrapper that overrides the tags field.
 */
public final class TagsFieldWrapper extends DataLayerSupplierWrapper {

    /**
     * The tags value supplier.
     */
    @NotNull
    private final Supplier<String[]> supplier;

    /**
     * Construct a DataLayerSupplier that overrides the tags field.
     *
     * @param dataLayerSupplier The wrapped data layer supplier.
     * @param supplier          The tags value supplier.
     */
    public TagsFieldWrapper(@NotNull final DataLayerSupplier dataLayerSupplier, @NotNull final Supplier<String[]> supplier) {
        super(dataLayerSupplier);
        this.supplier = supplier;
    }

    @Override
    @NotNull
    public Optional<Supplier<String[]>> getTags() {
        return Optional.of(this.supplier);
    }
}
