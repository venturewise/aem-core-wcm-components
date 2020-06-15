package com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier;

import com.day.cq.dam.api.Asset;
import com.day.cq.tagging.TagConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.jackrabbit.JcrConstants;
import org.apache.sling.api.resource.ValueMap;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public final class AssetDataLayerSupplier implements DataLayerSupplier {

    private final Asset asset;

    public AssetDataLayerSupplier(@NotNull final Asset asset) {
        this.asset = asset;
    }

    @Override
    @NotNull
    public Optional<Supplier<String>> getId() {
        return Optional.of(asset::getID);
    }

    @Override
    @NotNull
    public Optional<Supplier<Date>> getLastModifiedDate() {
        return Optional.of(() -> new Date(
            Optional.of(asset.getLastModified())
                .filter(lastMod -> lastMod > 0)
                .orElseGet(() -> Optional.ofNullable(asset.adaptTo(ValueMap.class))
                    .map(vm -> vm.get(JcrConstants.JCR_CREATED, Calendar.class))
                    .map(Calendar::getTimeInMillis)
                    .orElse(0L))));
    }

    @Override
    @NotNull
    public Optional<Supplier<String>> getFormat() {
        return Optional.of(asset::getMimeType);
    }

    @Override
    @NotNull
    public Optional<Supplier<String>> getUrl() {
        return Optional.of(asset::getPath);
    }

    @Override
    @NotNull
    public Optional<Supplier<String[]>> getTags() {
        return Optional.of(() ->
            Optional.ofNullable(asset.getMetadataValueFromJcr(TagConstants.PN_TAGS))
                .filter(StringUtils::isNotEmpty)
                .map(tagsValue -> tagsValue.split(","))
                .map(Arrays::stream)
                .orElseGet(Stream::empty)
                .filter(StringUtils::isNotEmpty)
                .toArray(String[]::new));
    }
}
