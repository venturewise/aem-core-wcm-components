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
import com.adobe.cq.wcm.core.components.models.datalayer.ComponentData;
import com.adobe.cq.wcm.core.components.models.datalayer.ContainerData;
import com.adobe.cq.wcm.core.components.models.datalayer.ImageData;
import com.adobe.cq.wcm.core.components.models.datalayer.PageData;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * A data layer supplier for extending existing {@link ComponentData}.
 * This class allows for {@link ComponentData} to be used as a source for a {@link DataLayerSupplier}.
 */
public final class DataExtenderSupplier implements DataLayerSupplier {

    /**
     * The existing component data.
     */
    @NotNull
    private final ComponentData data;

    /**
     * Construct a DataLayerSupplier from existing ComponentData.
     *
     * @param componentData The existing component data.
     */
    public DataExtenderSupplier(@NotNull final ComponentData componentData) {
        this.data = componentData;
    }

    @Override
    @NotNull
    public final Supplier<@NotNull String> getId() {
        return this.data::getId;
    }

    @Override
    @NotNull
    public final Optional<Supplier<String>> getType() {
        return Optional.of(this.data::getType);
    }

    @Override
    @NotNull
    public final Optional<Supplier<Date>> getLastModifiedDate() {
        return Optional.of(this.data::getLastModifiedDate);
    }

    @Override
    @NotNull
    public final Optional<Supplier<String>> getParentId() {
        return Optional.of(this.data::getParentId);
    }

    @Override
    @NotNull
    public final Optional<Supplier<String>> getTitle() {
        return Optional.of(this.data::getTitle);
    }

    @Override
    @NotNull
    public final Optional<Supplier<String>> getDescription() {
        return Optional.of(this.data::getDescription);
    }

    @Override
    @NotNull
    public final Optional<Supplier<String>> getText() {
        return Optional.of(this.data::getText);
    }

    @Override
    @NotNull
    public final Optional<Supplier<String>> getLinkUrl() {
        return Optional.of(this.data::getLinkUrl);
    }

    @Override
    @NotNull
    public Optional<Supplier<String[]>> getShownItems() {
        if (this.data instanceof ContainerData) {
            return Optional.of(((ContainerData)this.data)::getShownItems);
        }
        return Optional.empty();
    }

    @Override
    @NotNull
    public final Optional<Supplier<AssetData>> getAssetData()  {
        if (this.data instanceof ImageData) {
            return Optional.of(((ImageData) this.data)::getAssetData);
        }
        return Optional.empty();
    }

    @Override
    @NotNull
    public Optional<Supplier<String>> getUrl() {
        if (this.data instanceof PageData) {
            return Optional.of(((PageData) this.data)::getUrl);
        }
        return Optional.empty();
    }

    @Override
    @NotNull
    public Optional<Supplier<String[]>> getTags() {
        if (this.data instanceof PageData) {
            return Optional.of(((PageData) this.data)::getTags);
        }
        return Optional.empty();
    }

    @Override
    @NotNull
    public Optional<Supplier<String>> getTemplatePath() {
        if (this.data instanceof PageData) {
            return Optional.of(((PageData) this.data)::getTemplatePath);
        }
        return Optional.empty();
    }

    @Override
    @NotNull
    public Optional<Supplier<String>> getLanguage() {
        if (this.data instanceof PageData) {
            return Optional.of(((PageData) this.data)::getLanguage);
        }
        return Optional.empty();
    }
}
