package com.adobe.cq.wcm.core.components.models.datalayer.builder;

import com.adobe.cq.wcm.core.components.models.datalayer.ContainerData;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public interface ContainerDataBuilder extends GenericComponentDataBuilder<ContainerDataBuilder, ContainerData> {

    @NotNull
    ContainerDataBuilder withShownItems(@NotNull Supplier<String[]> supplier);
}
