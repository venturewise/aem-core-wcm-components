package com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.extender;

import com.adobe.cq.wcm.core.components.models.datalayer.AssetData;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.DataLayerSupplier;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.Optional;
import java.util.function.Supplier;

public final class AssetDataExtenderSupplier implements DataLayerSupplier {

    @NotNull
    private final AssetData data;

    public AssetDataExtenderSupplier(@NotNull final AssetData componentData) {
        this.data = componentData;
    }

    @Override
    @NotNull
    public final Optional<Supplier<String>> getId() {
        return Optional.of(this.data::getId);
    }

    @Override
    @NotNull
    public Optional<Supplier<String>> getUrl() {
        return Optional.of(this.data::getUrl);
    }

    @Override
    @NotNull
    public Optional<Supplier<String>> getFormat() {
        return Optional.of(this.data::getFormat);
    }

    @Override
    @NotNull
    public Optional<Supplier<String[]>> getTags() {
        return Optional.of(this.data::getTags);
    }

    @Override
    @NotNull
    public final Optional<Supplier<Date>> getLastModifiedDate() {
        return Optional.of(this.data::getLastModifiedDate);
    }
}
