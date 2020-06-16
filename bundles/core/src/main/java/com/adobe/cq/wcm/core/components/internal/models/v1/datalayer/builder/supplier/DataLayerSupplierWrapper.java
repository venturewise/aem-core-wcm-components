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
 * Abstract wrapper for {@link DataLayerSupplier}.
 */
public abstract class DataLayerSupplierWrapper implements DataLayerSupplier {

    /**
     * The wrapped data layer supplier.
     */
    @NotNull
    private final DataLayerSupplier wrappedSupplier;

    /**
     * Construct a wrapper for a {@link DataLayerSupplier}.
     *
     * @param dataLayerSupplier The data layer supply to wrap.
     */
    public DataLayerSupplierWrapper(@NotNull final DataLayerSupplier dataLayerSupplier) {
        this.wrappedSupplier = dataLayerSupplier;
    }

    @Override
    @NotNull
    public Supplier<@NotNull String> getId() {
        return this.getWrappedSupplier().getId();
    }

    @Override
    @NotNull
    public Optional<Supplier<String>> getType() {
        return this.getWrappedSupplier().getType();
    }

    @Override
    @NotNull
    public Optional<Supplier<Date>> getLastModifiedDate() {
        return this.getWrappedSupplier().getLastModifiedDate();
    }

    @Override
    @NotNull
    public Optional<Supplier<String>> getParentId() {
        return this.getWrappedSupplier().getParentId();
    }

    @Override
    @NotNull
    public Optional<Supplier<String>> getTitle() {
        return this.getWrappedSupplier().getTitle();
    }

    @Override
    @NotNull
    public Optional<Supplier<String>> getDescription() {
        return this.getWrappedSupplier().getDescription();
    }

    @Override
    @NotNull
    public Optional<Supplier<String>> getText() {
        return this.getWrappedSupplier().getText();
    }

    @Override
    @NotNull
    public Optional<Supplier<String>> getLinkUrl() {
        return this.getWrappedSupplier().getLinkUrl();
    }

    @Override
    @NotNull
    public Optional<Supplier<String[]>> getShownItems() {
        return this.getWrappedSupplier().getShownItems();
    }

    @Override
    @NotNull
    public Optional<Supplier<AssetData>> getAssetData()  {
        return this.getWrappedSupplier().getAssetData();
    }

    @Override
    @NotNull
    public Optional<Supplier<String>> getUrl() {
        return this.getWrappedSupplier().getUrl();
    }

    @Override
    @NotNull
    public Optional<Supplier<String>> getFormat() {
        return this.getWrappedSupplier().getFormat();
    }

    @Override
    @NotNull
    public Optional<Supplier<String[]>> getTags() {
        return this.getWrappedSupplier().getTags();
    }

    @Override
    @NotNull
    public Optional<Supplier<String>> getTemplatePath() {
        return this.getWrappedSupplier().getTemplatePath();
    }

    @Override
    @NotNull
    public Optional<Supplier<String>> getLanguage() {
        return this.getWrappedSupplier().getLanguage();
    }

    /**
     * Get the wrapped {@link DataLayerSupplier}.
     *
     * @return The wrapped data layer supplier.
     */
    @NotNull
    final DataLayerSupplier getWrappedSupplier() {
        return this.wrappedSupplier;
    }
}
