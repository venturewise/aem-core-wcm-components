package com.adobe.cq.wcm.core.components.models.datalayer.builder;

import com.adobe.cq.wcm.core.components.models.datalayer.PageData;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

/**
 * Data layer builder for pages.
 */
public interface PageDataBuilder extends GenericComponentDataBuilder<PageDataBuilder, PageData> {

    /**
     * Set the supplier that supplies the page's tags data.
     *
     * @param supplier The tags data value supplier.
     * @return A new {@link PageDataBuilder}.
     */
    @NotNull
    PageDataBuilder withTags(@NotNull Supplier<String[]> supplier);

    /**
     * Set the supplier that supplies the page's URL data.
     *
     * @param supplier The URL data value supplier.
     * @return A new {@link PageDataBuilder}.
     */
    @NotNull
    PageDataBuilder withUrl(@NotNull Supplier<String> supplier);

    /**
     * Set the supplier that supplies the page's template path data.
     *
     * @param supplier The template path data value supplier.
     * @return A new {@link PageDataBuilder}.
     */
    @NotNull
    PageDataBuilder withTemplatePath(@NotNull Supplier<String> supplier);

    /**
     * Set the supplier that supplies the page's language data.
     *
     * @param supplier The language data value supplier.
     * @return A new {@link PageDataBuilder}.
     */
    @NotNull
    PageDataBuilder withLanguage(@NotNull Supplier<String> supplier);
}
