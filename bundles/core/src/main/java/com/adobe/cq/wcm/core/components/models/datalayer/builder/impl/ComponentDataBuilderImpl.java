package com.adobe.cq.wcm.core.components.models.datalayer.builder.impl;

import com.adobe.cq.wcm.core.components.models.datalayer.ComponentData;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.ComponentDataBuilder;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.DataLayerSupplier;
import org.jetbrains.annotations.NotNull;

/**
 * Data builder for components.
 */
public final class ComponentDataBuilderImpl extends AbstractComponentDataBuilder<ComponentDataBuilder, ComponentData> implements ComponentDataBuilder {

    /**
     * Construct a component data builder.
     *
     * @param supplier The data layer supplier.
     */
    public ComponentDataBuilderImpl(@NotNull final DataLayerSupplier supplier) {
        super(supplier);
    }

    @Override
    @NotNull
    ComponentDataBuilder createInstance(@NotNull final DataLayerSupplier supplier) {
        return new ComponentDataBuilderImpl(supplier);
    }

    @NotNull
    @Override
    public ComponentData build() {
        return new ComponentDataImpl(this.getDataLayerSupplier());
    }
}
