package com.adobe.cq.wcm.core.components.models.datalayer.builder.impl;

import com.adobe.cq.wcm.core.components.models.datalayer.PageData;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.PageDataBuilder;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.DataLayerSupplier;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.fields.LanguageFieldWrapper;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.fields.TagsFieldWrapper;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.fields.TemplatePathFieldWrapper;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.fields.UrlFieldWrapper;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

/**
 * Data layer builder implementation for pages.
 */
public final class PageDataBuilderImpl
    extends AbstractComponentDataBuilder<PageDataBuilder, PageData>
    implements PageDataBuilder {

    /**
     * Construct a data layer builder for a page.
     *
     * @param supplier The data layer supplier.
     */
    public PageDataBuilderImpl(@NotNull final DataLayerSupplier supplier) {
        super(supplier);
    }

    @Override
    @NotNull
    PageDataBuilderImpl createInstance(@NotNull final DataLayerSupplier supplier) {
        return new PageDataBuilderImpl(supplier);
    }

    @Override
    @NotNull
    public PageDataBuilder withTags(@NotNull Supplier<String[]> supplier) {
        return this.createInstance(new TagsFieldWrapper(this.getDataLayerSupplier(), supplier));
    }

    @Override
    @NotNull
    public PageDataBuilder withUrl(@NotNull Supplier<String> supplier) {
        return this.createInstance(new UrlFieldWrapper(this.getDataLayerSupplier(), supplier));
    }

    @Override
    @NotNull
    public PageDataBuilder withTemplatePath(@NotNull Supplier<String> supplier) {
        return this.createInstance(new TemplatePathFieldWrapper(this.getDataLayerSupplier(), supplier));
    }

    @Override
    @NotNull
    public PageDataBuilder withLanguage(@NotNull Supplier<String> supplier) {
        return this.createInstance(new LanguageFieldWrapper(this.getDataLayerSupplier(), supplier));
    }

    @Override
    @NotNull
    public PageData build() {
        return new ComponentDataImpl(this.getDataLayerSupplier());
    }
}
