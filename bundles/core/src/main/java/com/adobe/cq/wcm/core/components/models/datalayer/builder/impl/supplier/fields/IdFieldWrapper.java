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
package com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.fields;

import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.DataLayerSupplier;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.DataLayerSupplierWrapper;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * A {@link DataLayerSupplier} wrapper that overrides the ID field.
 */
public final class IdFieldWrapper extends DataLayerSupplierWrapper {

    /**
     * The ID value supplier.
     */
    @NotNull
    final Supplier<String> idSupplier;

    /**
     * Construct a {@link DataLayerSupplier} wrapper that overrides the ID field.
     *
     * @param dataLayerSupplier The wrapped data layer supplier.
     * @param supplier          The ID value supplier.
     */
    public IdFieldWrapper(@NotNull final DataLayerSupplier dataLayerSupplier, @NotNull final Supplier<String> supplier) {
        super(dataLayerSupplier);
        this.idSupplier = supplier;
    }

    @Override
    @NotNull
    public Optional<Supplier<String>> getId() {
        return Optional.of(this.idSupplier);
    }
}
