/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 ~ Copyright 2019 Adobe Systems Incorporated
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
package com.adobe.cq.wcm.core.components.models;

import java.util.Map;

import javax.annotation.Nonnull;

import com.adobe.cq.export.json.ComponentExporter;

public interface SocialMediaFragment extends ComponentExporter {

    String PN_URL = "url";

    default String getUrl() {
        throw new UnsupportedOperationException();
    }

    default Processor getProcessor() {
        throw new UnsupportedOperationException();
    }

    interface Processor {

        default boolean accepts(String url) {
            throw new UnsupportedOperationException();
        }

        default String getName() {
            throw new UnsupportedOperationException();
        }

        default Map<String, Object> getOptions() {
            throw new UnsupportedOperationException();
        }

    }

    @Nonnull
    @Override
    default String getExportedType() {
        throw new UnsupportedOperationException();
    }
}
