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
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.function.Supplier;

/**
 * DataLayerBuilder for a Dam Asset.
 */
public interface AssetDataBuilder extends GenericDataBuilder<AssetDataBuilder, AssetData> {

    /**
     * Set the supplier that supplies the component's ID.
     *
     * @param supplier The ID value supplier.
     * @return A new DataLayerBuilder.
     */
    @NotNull
    AssetDataBuilder withId(@NotNull Supplier<String> supplier);


    /**
     * Sets the supplier that supplies the URL.
     *
     * @param supplier The URL value supplier.
     * @return A new DataLayerBuilder.
     */
    @NotNull
    AssetDataBuilder withUrl(@NotNull Supplier<String> supplier);


    /**
     * Sets the supplier that supplies the Asset's format.
     *
     * @param supplier The format value supplier.
     * @return A new DataLayerBuilder.
     */
    @NotNull
    AssetDataBuilder withFormat(@NotNull Supplier<String> supplier);


    /**
     * Sets the supplier that supplies the Asset's tags.
     *
     * @param supplier The tags value supplier.
     * @return A new DataLayerBuilder.
     */
    @NotNull
    AssetDataBuilder withTags(@NotNull Supplier<String[]> supplier);

    /**
     * Set the supplier that supplies the component's last modified date.
     *
     * @param supplier The last modified date value supplier.
     * @return A new DataLayerBuilder.
     */
    @NotNull
    AssetDataBuilder withLastModifiedDate(@NotNull Supplier<Date> supplier);
}
