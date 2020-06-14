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
