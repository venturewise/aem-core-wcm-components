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
package com.adobe.cq.wcm.core.components.internal.models.v1.datalayer.builder.supplier.fields;

import com.adobe.cq.wcm.core.components.internal.models.v1.datalayer.builder.supplier.DataLayerSupplier;
import com.adobe.cq.wcm.core.components.internal.models.v1.datalayer.builder.supplier.DataLayerSupplierWrapper;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * A DataLayerSupplier wrapper that overrides the text field.
 */
public final class TextFieldWrapper extends DataLayerSupplierWrapper {

    /**
     * The text value supplier.
     */
    @NotNull
    final Supplier<String> supplier;

    /**
     * Construct a DataLayerSupplier that overrides the text field.
     *
     * @param dataLayerSupplier The wrapped data layer supplier.
     * @param supplier          The text value supplier.
     */
    public TextFieldWrapper(@NotNull final DataLayerSupplier dataLayerSupplier, @NotNull final Supplier<String> supplier) {
        super(dataLayerSupplier);
        this.supplier = supplier;
    }

    @Override
    @NotNull
    public Optional<Supplier<String>> getText() {
        return Optional.of(this.supplier);
    }
}
