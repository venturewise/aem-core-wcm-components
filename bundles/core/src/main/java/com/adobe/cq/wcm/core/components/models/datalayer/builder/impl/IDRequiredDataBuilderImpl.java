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

import com.adobe.cq.wcm.core.components.models.datalayer.builder.GenericDataBuilder;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.IdRequiredDataBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class IDRequiredDataBuilderImpl<T extends GenericDataBuilder<T, K>, K> implements IdRequiredDataBuilder<T, K> {

    @NotNull
    private final T builder;

    public IDRequiredDataBuilderImpl(@NotNull final T builder) {
        this.builder = builder;
    }

    @NotNull
    public T withId(@NotNull Supplier<@NotNull String> supplier) {
        return this.builder.withId(supplier);
    }
}
