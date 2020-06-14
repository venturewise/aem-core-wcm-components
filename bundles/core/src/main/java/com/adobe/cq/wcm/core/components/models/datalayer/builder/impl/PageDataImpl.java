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
package com.adobe.cq.wcm.core.components.models.datalayer.builder.impl;

import com.adobe.cq.wcm.core.components.models.datalayer.PageData;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.DataLayerSupplier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

class PageDataImpl extends ContainerDataImpl implements PageData {

    PageDataImpl(@NotNull final DataLayerSupplier supplier) {
        super(supplier);
    }

    @Override
    @Nullable
    public String getTemplatePath() {
        return this.getDataLayerSupplier()
            .getTemplatePath()
            .map(Supplier::get)
            .orElse(null);
    }

    @Override
    @Nullable
    public String getLanguage() {
        return this.getDataLayerSupplier()
            .getLanguage()
            .map(Supplier::get)
            .orElse(null);
    }

    @Override
    @Nullable
    public String[] getTags() {
        return this.getDataLayerSupplier()
            .getTags()
            .map(Supplier::get)
            .orElse(null);
    }

    @Override
    @Nullable
    public String getUrl() {
        return this.getDataLayerSupplier()
            .getUrl()
            .map(Supplier::get)
            .orElse(null);
    }
}
