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
        return this.build(BuildStrategy.LAZY_CACHING);
    }

    @NotNull
    default K build(@NotNull final BuildStrategy strategy) {
        throw new UnsupportedOperationException();
    }

    /**
     * Data layer build strategy.
     */
    enum BuildStrategy {
        /**
         * Field suppliers are not invoked until the associated data layer getter is called.
         * The field supplier will be invoked at most once, and the value cached.
         *
         * This is the default build strategy.
         */
        LAZY_CACHING,

        /**
         * Field suppliers are not invoked until the associated data layer getter is called.
         * The field supplier will be invoked for every call to the data layer getter, the value is not cached.
         *
         * Only use this strategy if it is expected that the values returned by the field suppliers may change,
         * and it is desired for the data model to reflect these changes without rebuilding.
         */
        LAZY_NON_CACHING,

        /**
         * Field suppliers are invoked immediately, and the values are cached.
         *
         * Only use this strategy if it is expected that the values returned by the field suppliers may change,
         * and it is <em>not</em> desired that the data model should reflect these changes.
         */
        EAGER_CACHING,
    }
}
