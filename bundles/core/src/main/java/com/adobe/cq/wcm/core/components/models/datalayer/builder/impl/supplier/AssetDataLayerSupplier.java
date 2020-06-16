/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 ~ Copyright 2020 Adobe
 ~
 ~ Licensed under the Apache License, Version 2.0 (the "License");
 ~ you may not use this file except in compliance with the License.
 ~ You may obtain a copy of the License at
 ~
 ~     http://www.apache.org/licenses/LICENSE-2.0
 ~
 ~ Unless required by applicable law or agreed to in writing, software
 ~ distributed under the License is distributed on an "AS IS" BASIS,
 ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 ~ See the License for the specific language governing permissions and
 ~ limitations under the License.
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
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
    public Supplier<String> getId() {
        return asset::getID;
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
