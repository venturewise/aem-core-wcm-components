package com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.extender;

import com.adobe.cq.wcm.core.components.models.datalayer.ContainerData;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.DataLayerSupplier;
import org.jetbrains.annotations.NotNull;

public final class ContainerDataExtenderSupplier extends ComponentDataExtenderSupplier implements DataLayerSupplier {

    @NotNull
    private final ContainerData data;

    public ContainerDataExtenderSupplier(@NotNull final ContainerData componentData) {
        super(componentData);
        this.data = componentData;
    }

}
