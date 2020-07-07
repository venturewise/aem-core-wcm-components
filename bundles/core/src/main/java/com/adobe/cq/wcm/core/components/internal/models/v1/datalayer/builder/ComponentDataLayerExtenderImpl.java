package com.adobe.cq.wcm.core.components.internal.models.v1.datalayer.builder;

import com.adobe.cq.wcm.core.components.internal.models.v1.datalayer.builder.supplier.DataLayerSupplierWrapper;
import com.adobe.cq.wcm.core.components.models.datalayer.ComponentData;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.ComponentDataBuilder;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.ContainerDataBuilder;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.ComponentDataLayerExtender;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.ImageComponentDataBuilder;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.PageDataBuilder;
import org.jetbrains.annotations.NotNull;

/**
 * Data layer extender implementation.
 * This class is used to extend existing data.
 */
public final class ComponentDataLayerExtenderImpl implements ComponentDataLayerExtender {

    /**
     * The component data to be extended.
     */
    final ComponentData componentData;

    /**
     * Construct a component data layer extender.
     *
     * @param componentData The existing component data to be extended.
     */
    public ComponentDataLayerExtenderImpl(@NotNull final ComponentData componentData) {
        this.componentData = componentData;
    }

    @Override
    @NotNull
    public ComponentDataBuilder asComponent() {
        return new ComponentDataBuilderImpl(DataLayerSupplierWrapper.extend(this.componentData));
    }

    @Override
    @NotNull
    public ContainerDataBuilder asContainer() {
        return new ContainerDataBuilderImpl(DataLayerSupplierWrapper.extend(this.componentData));
    }

    @Override
    @NotNull
    public PageDataBuilder asPage() {
        return new PageDataBuilderImpl(DataLayerSupplierWrapper.extend(this.componentData));
    }

    @Override
    @NotNull
    public ImageComponentDataBuilder asImageComponent() {
        return new ImageComponentDataBuilderImpl(DataLayerSupplierWrapper.extend(this.componentData));
    }
}
