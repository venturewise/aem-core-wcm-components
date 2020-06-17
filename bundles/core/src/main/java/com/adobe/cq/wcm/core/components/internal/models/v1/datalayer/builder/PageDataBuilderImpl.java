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
package com.adobe.cq.wcm.core.components.internal.models.v1.datalayer.builder;

import com.adobe.cq.wcm.core.components.internal.models.v1.datalayer.builder.supplier.DataLayerSupplier;
import com.adobe.cq.wcm.core.components.internal.models.v1.datalayer.builder.supplier.fields.LanguageFieldWrapper;
import com.adobe.cq.wcm.core.components.internal.models.v1.datalayer.builder.supplier.fields.TagsFieldWrapper;
import com.adobe.cq.wcm.core.components.internal.models.v1.datalayer.builder.supplier.fields.TemplatePathFieldWrapper;
import com.adobe.cq.wcm.core.components.internal.models.v1.datalayer.builder.supplier.fields.UrlFieldWrapper;
import com.adobe.cq.wcm.core.components.models.datalayer.PageData;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.PageDataBuilder;
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
