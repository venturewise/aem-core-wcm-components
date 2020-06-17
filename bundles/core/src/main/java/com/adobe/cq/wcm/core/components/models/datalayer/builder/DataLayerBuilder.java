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
package com.adobe.cq.wcm.core.components.models.datalayer.builder;

import com.adobe.cq.wcm.core.components.internal.models.v1.datalayer.builder.AssetDataBuilderImpl;
import com.adobe.cq.wcm.core.components.internal.models.v1.datalayer.builder.ComponentDataBuilderImpl;
import com.adobe.cq.wcm.core.components.internal.models.v1.datalayer.builder.ContainerDataBuilderImpl;
import com.adobe.cq.wcm.core.components.internal.models.v1.datalayer.builder.IDRequiredDataBuilderImpl;
import com.adobe.cq.wcm.core.components.internal.models.v1.datalayer.builder.ImageComponentDataBuilderImpl;
import com.adobe.cq.wcm.core.components.internal.models.v1.datalayer.builder.PageDataBuilderImpl;
import com.adobe.cq.wcm.core.components.internal.models.v1.datalayer.builder.supplier.AssetDataLayerSupplier;
import com.adobe.cq.wcm.core.components.internal.models.v1.datalayer.builder.supplier.DataLayerSupplier;
import com.adobe.cq.wcm.core.components.models.datalayer.AssetData;
import com.adobe.cq.wcm.core.components.models.datalayer.ComponentData;
import com.adobe.cq.wcm.core.components.models.datalayer.ContainerData;
import com.adobe.cq.wcm.core.components.models.datalayer.ImageData;
import com.adobe.cq.wcm.core.components.models.datalayer.PageData;
import com.day.cq.dam.api.Asset;
import org.jetbrains.annotations.NotNull;

/**
 * Data layer builder utility.
 *
 * This utility is designed to help build valid data models for integration with
 * <a href="https://github.com/adobe/adobe-client-data-layer">Adobe Client Data Layer</a>.
 */
public final class DataLayerBuilder {

    /**
     * An empty DataLayerSupplier which has null values for all field value suppliers.
     */
    private static final DataLayerSupplier EMPTY_SUPPLIER = new DataLayerSupplier() {};

    /**
     * Private constructor to prevent instantiation of utility class.
     */
    private DataLayerBuilder() {
        // NOOP
    }

    /**
     * Get a ComponentDataBuilder for a component.
     *
     * @return An empty ComponentDataBuilder.
     */
    public static IdRequiredDataBuilder<ComponentDataBuilder, ComponentData> forComponent() {
        return new IDRequiredDataBuilderImpl<>(new ComponentDataBuilderImpl(EMPTY_SUPPLIER));
    }

    /**
     * Get a ComponentDataBuilder for a container component
     *
     * @return An empty ContainerDataBuilder.
     */
    public static IdRequiredDataBuilder<ContainerDataBuilder, ContainerData> forContainer() {
        return new IDRequiredDataBuilderImpl<>(new ContainerDataBuilderImpl(EMPTY_SUPPLIER));
    }

    /**
     * Get a ImageComponentDataBuilder for an image component.
     *
     * @return An empty ImageComponentDataBuilder.
     */
    public static IdRequiredDataBuilder<ImageComponentDataBuilder, ImageData> forImageComponent() {
        return new IDRequiredDataBuilderImpl<>(new ImageComponentDataBuilderImpl(EMPTY_SUPPLIER));
    }

    /**
     * Get a PageDataBuilder for an page.
     *
     * @return An empty PageDataBuilder.
     */
    public static IdRequiredDataBuilder<PageDataBuilder, PageData> forPage() {
        return new IDRequiredDataBuilderImpl<>(new PageDataBuilderImpl(EMPTY_SUPPLIER));
    }

    /**
     * Get a AssetDataBuilder for an asset.
     *
     * @return An empty AssetDataBuilder.
     */
    public static IdRequiredDataBuilder<AssetDataBuilder, AssetData> forAsset() {
        return new IDRequiredDataBuilderImpl<>(new AssetDataBuilderImpl(EMPTY_SUPPLIER));
    }

    /**
     * Get an AssetDataBuilder with standard asset data.
     * This builder is suitable for most DAM Assets and pre-populates all required fields from the asset metadata.
     *
     * @param asset The asset used to initialize the AssetDataBuilder.
     * @return A new AssetDataBuilder pre-initialized using the DAM asset metadata.
     */
    public static AssetDataBuilder forAsset(@NotNull final Asset asset) {
        return new AssetDataBuilderImpl(new AssetDataLayerSupplier(asset));
    }

}
