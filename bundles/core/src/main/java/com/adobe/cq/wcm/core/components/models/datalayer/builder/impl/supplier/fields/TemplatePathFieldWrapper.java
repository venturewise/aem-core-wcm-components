package com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.fields;

import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.DataLayerSupplier;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.DataLayerSupplierWrapper;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * A DataLayerSupplier wrapper that overrides the template path field.
 */
public final class TemplatePathFieldWrapper extends DataLayerSupplierWrapper {

    /**
     * The template path value supplier.
     */
    @NotNull
    final Supplier<String> supplier;

    /**
     * Construct a DataLayerSupplier that overrides the template path field.
     *
     * @param dataLayerSupplier The wrapped data layer supplier.
     * @param supplier          The template path value supplier.
     */
    public TemplatePathFieldWrapper(@NotNull final DataLayerSupplier dataLayerSupplier, @NotNull final Supplier<String> supplier) {
        super(dataLayerSupplier);
        this.supplier = supplier;
    }

    @Override
    @NotNull
    public Optional<Supplier<String>> getTemplatePath() {
        return Optional.of(this.supplier);
    }
}
