package com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.extender;

import com.adobe.cq.wcm.core.components.models.datalayer.PageData;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.DataLayerSupplier;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.function.Supplier;

public final class PageDataExtenderSupplier extends ComponentDataExtenderSupplier implements DataLayerSupplier {

    @NotNull
    private final PageData data;

    public PageDataExtenderSupplier(@NotNull final PageData componentData) {
        super(componentData);
        this.data = componentData;
    }

    @Override
    @NotNull
    public Optional<Supplier<String>> getUrl() {
        return Optional.of(this.data::getUrl);
    }

    @Override
    @NotNull
    public Optional<Supplier<String[]>> getTags() {
        return Optional.of(this.data::getTags);
    }

    @Override
    @NotNull
    public Optional<Supplier<String>> getTemplatePath() {
        return Optional.of(this.data::getTemplatePath);
    }

    @Override
    @NotNull
    public Optional<Supplier<String>> getLanguage() {
        return Optional.of(this.data::getLanguage);
    }
}
