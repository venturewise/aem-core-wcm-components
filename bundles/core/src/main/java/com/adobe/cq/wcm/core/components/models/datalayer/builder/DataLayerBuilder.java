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

import com.adobe.cq.wcm.core.components.models.datalayer.AssetData;
import com.adobe.cq.wcm.core.components.models.datalayer.ComponentData;
import com.adobe.cq.wcm.core.components.models.datalayer.ContainerData;
import com.adobe.cq.wcm.core.components.models.datalayer.ImageData;
import com.adobe.cq.wcm.core.components.models.datalayer.PageData;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.AssetDataBuilderImpl;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.ComponentDataBuilderImpl;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.ContainerDataBuilderImpl;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.IDRequiredDataBuilderImpl;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.ImageComponentDataBuilderImpl;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.PageDataBuilderImpl;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.AssetDataLayerSupplier;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.DataLayerSupplier;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.extender.AssetDataExtenderSupplier;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.extender.ComponentDataExtenderSupplier;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.extender.ContainerDataExtenderSupplier;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.extender.ImageComponentDataExtenderSupplier;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.extender.PageDataExtenderSupplier;
import com.day.cq.dam.api.Asset;
import org.jetbrains.annotations.NotNull;

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
     * Get a ComponentDataBuilder that extends existing component data.
     *
     * @param componentData The component data to extend.
     * @return A new ComponentDataBuilder pre-initialized with the existing component data.
     */
    public static ComponentDataBuilder extendingComponent(@NotNull final ComponentData componentData) {
        return new ComponentDataBuilderImpl(new ComponentDataExtenderSupplier(componentData));
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
     * Get a ContainerDataBuilder that extends existing container data.
     *
     * @param containerData The container data to extend.
     * @return A new ContainerDataBuilder pre-initialized with the existing container data.
     */
    public static ContainerDataBuilder extendingContainer(@NotNull final ContainerData containerData) {
        return new ContainerDataBuilderImpl(new ContainerDataExtenderSupplier(containerData));
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
     * Get a ImageComponentDataBuilder that extends existing image component data.
     *
     * @param imageData The image data to extend.
     * @return A new ImageComponentDataBuilder pre-initialized with the existing image component data.
     */
    public static ImageComponentDataBuilder extendingImageComponent(@NotNull final ImageData imageData) {
        return new ImageComponentDataBuilderImpl(new ImageComponentDataExtenderSupplier(imageData));
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
     * Get a PageDataBuilder that extends existing page data.
     *
     * @param pageData The page data to extend.
     * @return A new PageDataBuilder pre-initialized with the existing page data.
     */
    public static PageDataBuilder extendingPage(@NotNull final PageData pageData) {
        return new PageDataBuilderImpl(new PageDataExtenderSupplier(pageData));
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

    /**
     * Get a AssetDataBuilder that extends existing asset data.
     *
     * @param assetData The asset data to extend.
     * @return A new AssetDataBuilder pre-initialized with the existing asset data.
     */
    public static AssetDataBuilder extendingAsset(@NotNull final AssetData assetData) {
        return new AssetDataBuilderImpl(new AssetDataExtenderSupplier(assetData));
    }

}
