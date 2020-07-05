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
package com.adobe.cq.wcm.core.components.internal.models.v1.datalayer.builder.supplier;

import com.adobe.cq.wcm.core.components.models.datalayer.AssetData;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * A data layer supplier for extending existing {@link AssetData}.
 * This class allows for {@link AssetData} to be used as a source for a {@link DataLayerSupplier}.
 */
public final class AssetDataExtenderSupplier implements DataLayerSupplier {

    /**
     * The existing AssetData.
     */
    @NotNull
    private final AssetData data;

    /**
     * Construct a DataLayerSupplier from existing AssetData.
     *
     * @param assetData The existing asset data.
     */
    public AssetDataExtenderSupplier(@NotNull final AssetData assetData) {
        this.data = assetData;
    }

    @Override
    @NotNull
    public final Supplier<@NotNull String> getId() {
        return this.data::getId;
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
