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
package com.adobe.cq.wcm.core.components.models.datalayer.builder;

import com.adobe.cq.wcm.core.components.models.datalayer.ContainerData;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

/**
 * Data builder for container components.
 * This builder will produce a valid {@link ContainerData} object.
 */
public interface ContainerDataBuilder extends GenericComponentDataBuilder<ContainerDataBuilder, ContainerData> {

    /**
     * Set the supplier that supplies the array of shown items.
     *
     * @param supplier The shown items value supplier.
     * @return A new {@link ContainerDataBuilder}.
     * @see ContainerData#getShownItems()
     */
    @NotNull
    ContainerDataBuilder withShownItems(@NotNull Supplier<String[]> supplier);
}
