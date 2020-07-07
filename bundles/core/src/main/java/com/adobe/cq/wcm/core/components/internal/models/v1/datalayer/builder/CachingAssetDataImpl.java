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

import com.adobe.cq.wcm.core.components.models.datalayer.AssetData;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

/**
 * Caching asset data wrapper.
 *
 * @see AssetData
 */
public final class CachingAssetDataImpl implements AssetData {

    /**
     * The current data.
     */
    @NotNull
    @JsonIgnore
    private final AssetData componentData;

    /**
     * Cached ID field value.
     */
    private String id;

    /**
     * Cached lastModifiedDate field value.
     */
    private Date lastModifiedDate;

    /**
     * Cached url field value.
     */
    private String url;

    /**
     * Cached tags field value.
     */
    private String[] tags;

    /**
     * Cached format field value.
     */
    private String format;

    /**
     * Flag indicating if the ID field has been initialized.
     */
    private boolean idInitialized = false;

    /**
     * Flag indicating if the lastModifiedDate field has been initialized.
     */
    private boolean lastModifiedDateInitialized = false;

    /**
     * Flag indicating if the url field has been initialized.
     */
    private boolean urlInitialized = false;

    /**
     * Flag indicating if the tags field has been initialized.
     */
    private boolean tagsInitialized = false;

    /**
     * Flag indicating if the format field has been initialized.
     */
    private boolean formatInitialized = false;

    /**
     * Construct the caching asset data model.
     *
     * @param data The asset data.
     * @param eager True to eagerly load the data values.
     */
    public CachingAssetDataImpl(@NotNull final AssetDataImpl data, boolean eager) {
        this.componentData = data;
        if (eager) {
            this.getId();
            this.getLastModifiedDate();
            this.getFormat();
            this.getUrl();
            this.getTags();
        }
    }

    @Override
    @NotNull
    public String getId() {
        if (!this.idInitialized) {
            this.id = this.componentData.getId();
            this.idInitialized = true;
        }
        return id;
    }

    @Override
    public Date getLastModifiedDate() {
        if (!this.lastModifiedDateInitialized) {
            this.lastModifiedDate = this.componentData.getLastModifiedDate();
            this.lastModifiedDateInitialized = true;
        }
        return this.lastModifiedDate;
    }

    @Override
    public String getFormat() {
        if (!this.formatInitialized) {
            this.format = this.componentData.getFormat();
            this.formatInitialized = true;
        }
        return this.format;
    }

    @Override
    public String getUrl() {
        if (!this.urlInitialized) {
            this.url = this.componentData.getUrl();
            this.urlInitialized = true;
        }
        return this.url;
    }

    @Override
    public String[] getTags() {
        if (!this.tagsInitialized) {
            this.tags = this.componentData.getTags();
            this.tagsInitialized = true;
        }
        return this.tags;
    }
}
