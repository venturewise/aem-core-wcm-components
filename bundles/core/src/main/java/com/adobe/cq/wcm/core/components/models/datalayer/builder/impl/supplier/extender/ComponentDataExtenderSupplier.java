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
package com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.extender;

import com.adobe.cq.wcm.core.components.models.datalayer.ComponentData;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.DataLayerSupplier;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.Optional;
import java.util.function.Supplier;

public class ComponentDataExtenderSupplier implements DataLayerSupplier {

    @NotNull
    private final ComponentData data;

    public ComponentDataExtenderSupplier(@NotNull final ComponentData componentData) {
        this.data = componentData;
    }

    @Override
    @NotNull
    public final Supplier<@NotNull String> getId() {
        return this.data::getId;
    }

    @Override
    @NotNull
    public final Optional<Supplier<String>> getType() {
        return Optional.of(this.data::getType);
    }

    @Override
    @NotNull
    public final Optional<Supplier<Date>> getLastModifiedDate() {
        return Optional.of(this.data::getLastModifiedDate);
    }

    @Override
    @NotNull
    public final Optional<Supplier<String>> getParentId() {
        return Optional.of(this.data::getParentId);
    }

    @Override
    @NotNull
    public final Optional<Supplier<String>> getTitle() {
        return Optional.of(this.data::getTitle);
    }

    @Override
    @NotNull
    public final Optional<Supplier<String>> getDescription() {
        return Optional.of(this.data::getDescription);
    }

    @Override
    @NotNull
    public final Optional<Supplier<String>> getText() {
        return Optional.of(this.data::getText);
    }

    @Override
    @NotNull
    public final Optional<Supplier<String>> getLinkUrl() {
        return Optional.of(this.data::getLinkUrl);
    }
}
