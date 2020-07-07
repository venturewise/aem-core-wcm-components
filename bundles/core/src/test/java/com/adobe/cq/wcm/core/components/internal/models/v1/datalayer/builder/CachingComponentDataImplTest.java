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
import com.adobe.cq.wcm.core.components.models.datalayer.AssetData;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Tests for caching component data implementation.
 */
class CachingComponentDataImplTest {

    /**
     * Static supplier with all fields set.
     */
    static final DataLayerSupplier STATIC_COMPONENT_DATA_SUPPLIER = new DataLayerSupplier() {
        @Override
        @NotNull
        public Supplier<@NotNull String> getId() {
            return () -> "ID";
        }

        @Override
        @NotNull
        public Optional<Supplier<String>> getType() {
            return Optional.of(() -> "type");
        }

        @Override
        @NotNull
        public Optional<Supplier<Date>> getLastModifiedDate() {
            return Optional.of(() -> new Date(0L));
        }

        @Override
        @NotNull
        public Optional<Supplier<String>> getParentId() {
            return Optional.of(() -> "parentID");
        }

        @Override
        @NotNull
        public Optional<Supplier<String>> getTitle() {
            return Optional.of(() -> "title");
        }

        @Override
        @NotNull
        public Optional<Supplier<String>> getDescription() {
            return Optional.of(() -> "description");
        }

        @Override
        @NotNull
        public Optional<Supplier<String>> getText() {
            return Optional.of(() -> "text");
        }

        @Override
        @NotNull
        public Optional<Supplier<String>> getLinkUrl() {
            return Optional.of(() -> "linkURL");
        }

        @Override
        @NotNull
        public Optional<Supplier<String[]>> getShownItems() {
            return Optional.of(() -> new String[] {"shownItems"} );
        }

        @Override
        @NotNull
        public Optional<Supplier<String>> getUrl() {
            return Optional.of(() -> "URL");
        }

        @Override
        @NotNull
        public Optional<Supplier<String>> getFormat() {
            return Optional.of(() -> "format");
        }

        @Override
        @NotNull
        public Optional<Supplier<String[]>> getTags() {
            return Optional.of(() -> new String[] {"tags"} );
        }

        @Override
        @NotNull
        public Optional<Supplier<AssetData>> getAssetData() {
            return Optional.of(() -> new AssetData() {

                @Override
                public String getId() {
                    return "assetId";
                }

            });
        }

        @Override
        @NotNull
        public Optional<Supplier<String>> getTemplatePath() {
            return Optional.of(() -> "templatePath");
        }

        @Override
        @NotNull
        public Optional<Supplier<String>> getLanguage() {
            return Optional.of(() -> "language");
        }
    };

    /**
     * Tests for lazy caching.
     */
    @Nested
    public class Lazy {
        private ComponentDataImpl componentData;
        private CachingComponentDataImpl cachingComponentData;

        @BeforeEach
        void setUp() {
            this.componentData = Mockito.spy(new ComponentDataImpl(STATIC_COMPONENT_DATA_SUPPLIER));
            this.cachingComponentData = new CachingComponentDataImpl(this.componentData, false);
        }

        @Test
        void getId() {
            Mockito.verify(this.componentData, Mockito.never()).getId();
            Assertions.assertEquals("ID", this.cachingComponentData.getId());
            Assertions.assertSame(this.cachingComponentData.getId(), this.cachingComponentData.getId());
            Mockito.verify(this.componentData, Mockito.atMost(1)).getId();
        }

        @Test
        void getType() {
            Mockito.verify(this.componentData, Mockito.never()).getType();
            Assertions.assertEquals("type", this.cachingComponentData.getType());
            Assertions.assertSame(this.cachingComponentData.getType(), this.cachingComponentData.getType());
            Mockito.verify(this.componentData, Mockito.atMost(1)).getType();
        }

        @Test
        void getLastModifiedDate() {
            Mockito.verify(this.componentData, Mockito.never()).getLastModifiedDate();
            Assertions.assertEquals(new Date(0L), this.cachingComponentData.getLastModifiedDate());
            Assertions.assertNotSame(this.cachingComponentData.getLastModifiedDate(), this.cachingComponentData.getLastModifiedDate());
            Assertions.assertEquals(this.cachingComponentData.getLastModifiedDate(), this.cachingComponentData.getLastModifiedDate());
            Mockito.verify(this.componentData, Mockito.atMost(1)).getLastModifiedDate();
        }

        @Test
        void getParentId() {
            Mockito.verify(this.componentData, Mockito.never()).getParentId();
            Assertions.assertEquals("parentID", this.cachingComponentData.getParentId());
            Assertions.assertSame(this.cachingComponentData.getParentId(), this.cachingComponentData.getParentId());
            Mockito.verify(this.componentData, Mockito.atMost(1)).getParentId();
        }

        @Test
        void getTitle() {
            Mockito.verify(this.componentData, Mockito.never()).getTitle();
            Assertions.assertEquals("title", this.cachingComponentData.getTitle());
            Assertions.assertSame(this.cachingComponentData.getTitle(), this.cachingComponentData.getTitle());
            Mockito.verify(this.componentData, Mockito.atMost(1)).getTitle();
        }

        @Test
        void getDescription() {
            Mockito.verify(this.componentData, Mockito.never()).getDescription();
            Assertions.assertEquals("description", this.cachingComponentData.getDescription());
            Assertions.assertSame(this.cachingComponentData.getDescription(), this.cachingComponentData.getDescription());
            Mockito.verify(this.componentData, Mockito.atMost(1)).getDescription();
        }

        @Test
        void getText() {
            Mockito.verify(this.componentData, Mockito.never()).getText();
            Assertions.assertEquals("text", this.cachingComponentData.getText());
            Assertions.assertSame(this.cachingComponentData.getText(), this.cachingComponentData.getText());
            Mockito.verify(this.componentData, Mockito.atMost(1)).getText();
        }

        @Test
        void getLinkUrl() {
            Mockito.verify(this.componentData, Mockito.never()).getLinkUrl();
            Assertions.assertEquals("linkURL", this.cachingComponentData.getLinkUrl());
            Assertions.assertSame(this.cachingComponentData.getLinkUrl(), this.cachingComponentData.getLinkUrl());
            Mockito.verify(this.componentData, Mockito.atMost(1)).getLinkUrl();
        }

        @Test
        void getShownItems() {
            Mockito.verify(this.componentData, Mockito.never()).getTitle();
            Assertions.assertArrayEquals(new String[]{"shownItems"}, this.cachingComponentData.getShownItems());
            Assertions.assertNotSame(this.cachingComponentData.getShownItems(), this.cachingComponentData.getShownItems());
            Assertions.assertArrayEquals(this.cachingComponentData.getShownItems(), this.cachingComponentData.getShownItems());
            Mockito.verify(this.componentData, Mockito.atMost(1)).getShownItems();
        }

        @Test
        void getAssetData() {
            Mockito.verify(this.componentData, Mockito.never()).getAssetData();
            Assertions.assertEquals("assetId", Objects.requireNonNull(this.cachingComponentData.getAssetData()).getId());
            Assertions.assertSame(this.cachingComponentData.getAssetData(), this.cachingComponentData.getAssetData());
            Mockito.verify(this.componentData, Mockito.atMost(1)).getAssetData();
        }

        @Test
        void getTemplatePath() {
            Mockito.verify(this.componentData, Mockito.never()).getTemplatePath();
            Assertions.assertEquals("templatePath", this.cachingComponentData.getTemplatePath());
            Assertions.assertSame(this.cachingComponentData.getTemplatePath(), this.cachingComponentData.getTemplatePath());
            Mockito.verify(this.componentData, Mockito.atMost(1)).getTemplatePath();
        }

        @Test
        void getLanguage() {
            Mockito.verify(this.componentData, Mockito.never()).getLanguage();
            Assertions.assertEquals("language", this.cachingComponentData.getLanguage());
            Assertions.assertSame(this.cachingComponentData.getLanguage(), this.cachingComponentData.getLanguage());
            Mockito.verify(this.componentData, Mockito.atMost(1)).getLanguage();
        }

        @Test
        void getTags() {
            Mockito.verify(this.componentData, Mockito.never()).getTags();
            Assertions.assertArrayEquals(new String[]{"tags"}, this.cachingComponentData.getTags());
            Assertions.assertNotSame(this.cachingComponentData.getTags(), this.cachingComponentData.getTags());
            Assertions.assertArrayEquals(this.cachingComponentData.getTags(), this.cachingComponentData.getTags());
            Mockito.verify(this.componentData, Mockito.atMost(1)).getTags();
        }

        @Test
        void getUrl() {
            Mockito.verify(this.componentData, Mockito.never()).getUrl();
            Assertions.assertEquals("URL", this.cachingComponentData.getUrl());
            Assertions.assertSame(this.cachingComponentData.getUrl(), this.cachingComponentData.getUrl());
            Mockito.verify(this.componentData, Mockito.atMost(1)).getUrl();
        }

        @Test
        void getJson() {
            Mockito.verify(this.componentData, Mockito.never()).getJson();
            Assertions.assertEquals(this.componentData.getJson(), this.cachingComponentData.getJson());
            Mockito.verify(this.componentData, Mockito.times(1)).getJson();
        }
    }

    /**
     * Tests for eager caching.
     */
    @Nested
    public class Eager {
        private ComponentDataImpl componentData;
        private CachingComponentDataImpl cachingComponentData;

        @BeforeEach
        void setUp() {
            this.componentData = Mockito.spy(new ComponentDataImpl(STATIC_COMPONENT_DATA_SUPPLIER));
            this.cachingComponentData = new CachingComponentDataImpl(this.componentData, true);
        }

        @Test
        void getId() {
            Mockito.verify(this.componentData, Mockito.times(1)).getId();
            Assertions.assertEquals("ID", this.cachingComponentData.getId());
            Assertions.assertSame(this.cachingComponentData.getId(), this.cachingComponentData.getId());
            Mockito.verify(this.componentData, Mockito.times(1)).getId();
        }

        @Test
        void getType() {
            Mockito.verify(this.componentData, Mockito.times(1)).getType();
            Assertions.assertEquals("type", this.cachingComponentData.getType());
            Assertions.assertSame(this.cachingComponentData.getType(), this.cachingComponentData.getType());
            Mockito.verify(this.componentData, Mockito.times(1)).getType();
        }

        @Test
        void getLastModifiedDate() {
            Mockito.verify(this.componentData, Mockito.times(1)).getLastModifiedDate();
            Assertions.assertEquals(new Date(0L), this.cachingComponentData.getLastModifiedDate());
            Assertions.assertNotSame(this.cachingComponentData.getLastModifiedDate(), this.cachingComponentData.getLastModifiedDate());
            Assertions.assertEquals(this.cachingComponentData.getLastModifiedDate(), this.cachingComponentData.getLastModifiedDate());
            Mockito.verify(this.componentData, Mockito.times(1)).getLastModifiedDate();
        }

        @Test
        void getParentId() {
            Mockito.verify(this.componentData, Mockito.times(1)).getParentId();
            Assertions.assertEquals("parentID", this.cachingComponentData.getParentId());
            Assertions.assertSame(this.cachingComponentData.getParentId(), this.cachingComponentData.getParentId());
            Mockito.verify(this.componentData, Mockito.times(1)).getParentId();
        }

        @Test
        void getTitle() {
            Mockito.verify(this.componentData, Mockito.times(1)).getTitle();
            Assertions.assertEquals("title", this.cachingComponentData.getTitle());
            Assertions.assertSame(this.cachingComponentData.getTitle(), this.cachingComponentData.getTitle());
            Mockito.verify(this.componentData, Mockito.times(1)).getTitle();
        }

        @Test
        void getDescription() {
            Mockito.verify(this.componentData, Mockito.times(1)).getDescription();
            Assertions.assertEquals("description", this.cachingComponentData.getDescription());
            Assertions.assertSame(this.cachingComponentData.getDescription(), this.cachingComponentData.getDescription());
            Mockito.verify(this.componentData, Mockito.times(1)).getDescription();
        }

        @Test
        void getText() {
            Mockito.verify(this.componentData, Mockito.times(1)).getText();
            Assertions.assertEquals("text", this.cachingComponentData.getText());
            Assertions.assertSame(this.cachingComponentData.getText(), this.cachingComponentData.getText());
            Mockito.verify(this.componentData, Mockito.times(1)).getText();
        }

        @Test
        void getLinkUrl() {
            Mockito.verify(this.componentData, Mockito.times(1)).getLinkUrl();
            Assertions.assertEquals("linkURL", this.cachingComponentData.getLinkUrl());
            Assertions.assertSame(this.cachingComponentData.getLinkUrl(), this.cachingComponentData.getLinkUrl());
            Mockito.verify(this.componentData, Mockito.times(1)).getLinkUrl();
        }

        @Test
        void getShownItems() {
            Mockito.verify(this.componentData, Mockito.times(1)).getShownItems();
            Assertions.assertArrayEquals(new String[]{"shownItems"}, this.cachingComponentData.getShownItems());
            Assertions.assertNotSame(this.cachingComponentData.getShownItems(), this.cachingComponentData.getShownItems());
            Assertions.assertArrayEquals(this.cachingComponentData.getShownItems(), this.cachingComponentData.getShownItems());
            Mockito.verify(this.componentData, Mockito.times(1)).getShownItems();
        }

        @Test
        void getAssetData() {
            Mockito.verify(this.componentData, Mockito.times(1)).getAssetData();
            Assertions.assertEquals("assetId", Objects.requireNonNull(this.cachingComponentData.getAssetData()).getId());
            Assertions.assertSame(this.cachingComponentData.getAssetData(), this.cachingComponentData.getAssetData());
            Mockito.verify(this.componentData, Mockito.times(1)).getAssetData();
        }

        @Test
        void getTemplatePath() {
            Mockito.verify(this.componentData, Mockito.times(1)).getTemplatePath();
            Assertions.assertEquals("templatePath", this.cachingComponentData.getTemplatePath());
            Assertions.assertSame(this.cachingComponentData.getTemplatePath(), this.cachingComponentData.getTemplatePath());
            Mockito.verify(this.componentData, Mockito.times(1)).getTemplatePath();
        }

        @Test
        void getLanguage() {
            Mockito.verify(this.componentData, Mockito.times(1)).getLanguage();
            Assertions.assertEquals("language", this.cachingComponentData.getLanguage());
            Assertions.assertSame(this.cachingComponentData.getLanguage(), this.cachingComponentData.getLanguage());
            Mockito.verify(this.componentData, Mockito.times(1)).getLanguage();
        }

        @Test
        void getTags() {
            Mockito.verify(this.componentData, Mockito.times(1)).getTags();
            Assertions.assertArrayEquals(new String[]{"tags"}, this.cachingComponentData.getTags());
            Assertions.assertNotSame(this.cachingComponentData.getTags(), this.cachingComponentData.getTags());
            Assertions.assertArrayEquals(this.cachingComponentData.getTags(), this.cachingComponentData.getTags());
            Mockito.verify(this.componentData, Mockito.times(1)).getTags();
        }

        @Test
        void getUrl() {
            Mockito.verify(this.componentData, Mockito.times(1)).getUrl();
            Assertions.assertEquals("URL", this.cachingComponentData.getUrl());
            Assertions.assertSame(this.cachingComponentData.getUrl(), this.cachingComponentData.getUrl());
            Mockito.verify(this.componentData, Mockito.times(1)).getUrl();

        }

        @Test
        void getJson() {
            Mockito.verify(this.componentData, Mockito.never()).getJson();
            Assertions.assertEquals(this.componentData.getJson(), this.cachingComponentData.getJson());
            Mockito.verify(this.componentData, Mockito.times(1)).getJson();
        }
    }
}
