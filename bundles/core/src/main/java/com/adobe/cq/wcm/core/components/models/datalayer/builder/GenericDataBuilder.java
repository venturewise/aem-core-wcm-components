package com.adobe.cq.wcm.core.components.models.datalayer.builder;

import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

/**
 * Generic data builder that specifies fields available on all data builders.
 * Every data builder should implement this interface.
 *
 * @param <T> The data builder type.
 * @param <K> The data type.
 */
public interface GenericDataBuilder<T extends GenericDataBuilder<T, K>, K> {

    /**
     * Set the supplier that supplies the component's ID.
     *
     * @param supplier The ID value supplier.
     * @return A new DataLayerBuilder.
     */
    @NotNull
    T withId(@NotNull Supplier<String> supplier);

    /**
     * Build the data.
     *
     * @return The data.
     */
    @NotNull
    K build();
}
