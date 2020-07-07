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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Date;

import static com.adobe.cq.wcm.core.components.internal.models.v1.datalayer.builder.CachingComponentDataImplTest.STATIC_COMPONENT_DATA_SUPPLIER;

/**
 * Tests for caching asset data implementation.
 */
class CachingAssetDataImplTest {

    /**
     * Tests for lazy caching.
     */
    @Nested
    public class Lazy {

        private AssetDataImpl assetData;
        private CachingAssetDataImpl cachingAssetData;

        @BeforeEach
        void setUp() {
            this.assetData = Mockito.spy(new AssetDataImpl(STATIC_COMPONENT_DATA_SUPPLIER));
            this.cachingAssetData = new CachingAssetDataImpl(this.assetData, false);
        }

        @Test
        void getId() {
            Mockito.verify(this.assetData, Mockito.never()).getId();
            Assertions.assertEquals("ID", this.cachingAssetData.getId());
            Assertions.assertSame(this.cachingAssetData.getId(), this.cachingAssetData.getId());
            Mockito.verify(this.assetData, Mockito.atMost(1)).getId();
        }

        @Test
        void getLastModifiedDate() {
            Mockito.verify(this.assetData, Mockito.never()).getLastModifiedDate();
            Assertions.assertEquals(new Date(0L), this.cachingAssetData.getLastModifiedDate());
            Assertions.assertNotSame(this.cachingAssetData.getLastModifiedDate(), this.cachingAssetData.getLastModifiedDate());
            Assertions.assertEquals(this.cachingAssetData.getLastModifiedDate(), this.cachingAssetData.getLastModifiedDate());
            Mockito.verify(this.assetData, Mockito.atMost(1)).getLastModifiedDate();
        }

        @Test
        void getFormat() {
            Mockito.verify(this.assetData, Mockito.never()).getFormat();
            Assertions.assertEquals("format", this.cachingAssetData.getFormat());
            Assertions.assertSame(this.cachingAssetData.getFormat(), this.cachingAssetData.getFormat());
            Mockito.verify(this.assetData, Mockito.atMost(1)).getFormat();
        }

        @Test
        void getUrl() {
            Mockito.verify(this.assetData, Mockito.never()).getUrl();
            Assertions.assertEquals("URL", this.cachingAssetData.getUrl());
            Assertions.assertSame(this.cachingAssetData.getUrl(), this.cachingAssetData.getUrl());
            Mockito.verify(this.assetData, Mockito.atMost(1)).getUrl();
        }

        @Test
        void getTags() {
            Mockito.verify(this.assetData, Mockito.never()).getTags();
            Assertions.assertArrayEquals(new String[]{"tags"}, this.cachingAssetData.getTags());
            Assertions.assertNotSame(this.cachingAssetData.getTags(), this.cachingAssetData.getTags());
            Assertions.assertArrayEquals(this.cachingAssetData.getTags(), this.cachingAssetData.getTags());
            Mockito.verify(this.assetData, Mockito.atMost(1)).getTags();
        }
    }


    /**
     * Tests for eager caching.
     */
    @Nested
    public class Eager {

        private AssetDataImpl assetData;
        private CachingAssetDataImpl cachingAssetData;

        @BeforeEach
        void setUp() {
            this.assetData = Mockito.spy(new AssetDataImpl(STATIC_COMPONENT_DATA_SUPPLIER));
            this.cachingAssetData = new CachingAssetDataImpl(this.assetData, true);
        }

        @Test
        void getId() {
            Mockito.verify(this.assetData, Mockito.times(1)).getTags();
            Assertions.assertEquals("ID", this.cachingAssetData.getId());
            Assertions.assertSame(this.cachingAssetData.getId(), this.cachingAssetData.getId());
            Mockito.verify(this.assetData, Mockito.times(1)).getId();
        }

        @Test
        void getLastModifiedDate() {
            Mockito.verify(this.assetData, Mockito.times(1)).getTags();
            Assertions.assertEquals(new Date(0L), this.cachingAssetData.getLastModifiedDate());
            Assertions.assertNotSame(this.cachingAssetData.getLastModifiedDate(), this.cachingAssetData.getLastModifiedDate());
            Assertions.assertEquals(this.cachingAssetData.getLastModifiedDate(), this.cachingAssetData.getLastModifiedDate());
            Mockito.verify(this.assetData, Mockito.times(1)).getLastModifiedDate();
        }

        @Test
        void getFormat() {
            Mockito.verify(this.assetData, Mockito.times(1)).getTags();
            Assertions.assertEquals("format", this.cachingAssetData.getFormat());
            Assertions.assertSame(this.cachingAssetData.getFormat(), this.cachingAssetData.getFormat());
            Mockito.verify(this.assetData, Mockito.times(1)).getFormat();
        }

        @Test
        void getUrl() {
            Mockito.verify(this.assetData, Mockito.times(1)).getTags();
            Assertions.assertEquals("URL", this.cachingAssetData.getUrl());
            Assertions.assertSame(this.cachingAssetData.getUrl(), this.cachingAssetData.getUrl());
            Mockito.verify(this.assetData, Mockito.times(1)).getUrl();
        }

        @Test
        void getTags() {
            Mockito.verify(this.assetData, Mockito.times(1)).getTags();
            Assertions.assertArrayEquals(new String[]{"tags"}, this.cachingAssetData.getTags());
            Assertions.assertNotSame(this.cachingAssetData.getTags(), this.cachingAssetData.getTags());
            Assertions.assertArrayEquals(this.cachingAssetData.getTags(), this.cachingAssetData.getTags());
            Mockito.verify(this.assetData, Mockito.times(1)).getTags();
        }
    }
}
