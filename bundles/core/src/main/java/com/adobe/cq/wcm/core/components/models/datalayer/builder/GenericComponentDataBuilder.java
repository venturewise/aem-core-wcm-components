package com.adobe.cq.wcm.core.components.models.datalayer.builder;

import com.adobe.cq.wcm.core.components.models.datalayer.ComponentData;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.function.Supplier;

/**
 * Data Layer Builder for all builders that build data layers that extend {@link ComponentData}.

 * @param <T> The data builder type.
 * @param <K> The data type.
 */
public interface GenericComponentDataBuilder<T extends GenericComponentDataBuilder<T, K>, K extends ComponentData>
    extends GenericDataBuilder<T, K> {

    /**
     *  Set the supplier that supplies the component's type.
     *
     * @param supplier The type value supplier.
     * @return A new DataLayerBuilder.
     */
    @NotNull
    T withType(@NotNull Supplier<String> supplier);

    /**
     * Set the supplier that supplies the component's last modified date.
     *
     * @param supplier The last modified date value supplier.
     * @return A new DataLayerBuilder.
     */
    @NotNull
    T withLastModifiedDate(@NotNull Supplier<Date> supplier);

    /**
     * Set the supplier that supplies the component's parent ID.
     *
     * @param supplier The parent ID value supplier.
     * @return A new DataLayerBuilder.
     */
    @NotNull
    T withParentId(@NotNull Supplier<String> supplier);

    /**
     * Set the supplier that supplies the component's title.
     *
     * @param supplier The title value supplier.
     * @return A new DataLayerBuilder.
     */
    @NotNull
    T withTitle(@NotNull Supplier<String> supplier);

    /**
     * Set the supplier that supplies the component's description.
     *
     * @param supplier The description value supplier.
     * @return A new DataLayerBuilder.
     */
    @NotNull
    T withDescription(@NotNull Supplier<String> supplier);

    /**
     * Set the supplier that supplies the component's text.
     *
     * @param supplier The text value supplier.
     * @return A new DataLayerBuilder.
     */
    @NotNull
    T withText(@NotNull Supplier<String> supplier);

    /**
     * Sets the supplier that supplies the component's link URL.
     *
     * @param supplier The link URL value supplier.
     * @return A new DataLayerBuilder.
     */
    @NotNull
    T withLinkUrl(@NotNull Supplier<String> supplier);

}
