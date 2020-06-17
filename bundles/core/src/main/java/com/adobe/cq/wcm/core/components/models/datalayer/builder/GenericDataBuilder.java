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

import org.jetbrains.annotations.NotNull;

/**
 * Generic data builder that specifies fields available on all data builders.
 * Every data builder should implement this interface.
 *
 * @param <T> The data builder type.
 * @param <K> The data type.
 */
public interface GenericDataBuilder<T extends GenericDataBuilder<T, K>, K> extends IdRequiredDataBuilder<T, K> {

    /**
     * Build the data.
     *
     * @return The data object.
     */
    @NotNull
    default K build() {
        throw new UnsupportedOperationException();
    }
}
