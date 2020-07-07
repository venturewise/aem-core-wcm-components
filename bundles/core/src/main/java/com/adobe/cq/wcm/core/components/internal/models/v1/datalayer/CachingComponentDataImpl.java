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
package com.adobe.cq.wcm.core.components.internal.models.v1.datalayer;

import com.adobe.cq.wcm.core.components.models.datalayer.AssetData;
import com.adobe.cq.wcm.core.components.models.datalayer.ComponentData;
import com.adobe.cq.wcm.core.components.models.datalayer.ContainerData;
import com.adobe.cq.wcm.core.components.models.datalayer.ImageData;
import com.adobe.cq.wcm.core.components.models.datalayer.PageData;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

/**
 * A caching component data wrapper.
 *
 * This implementation supports:
 * <ul>
 *     <li>{@link ComponentData}</li>
 *     <li>{@link ImageData}</li>
 *     <li>{@link ContainerData}</li>
 *     <li>{@link PageData}</li>
 * </ul>
 */
public final class CachingComponentDataImpl implements ComponentData, ImageData, ContainerData, PageData {

    /**
     * The current data.
     */
    @NotNull
    @JsonIgnore
    private final ComponentDataImpl componentData;

    /**
     * Cached ID field value.
     */
    private String id;

    /**
     * Cached type field value.
     */
    private String type;

    /**
     * Cached lastModifiedDate field value.
     */
    private Date lastModifiedDate;

    /**
     * Cached parentId field value.
     */
    private String parentId;

    /**
     * Cached title field value.
     */
    private String title;

    /**
     * Cached description field value.
     */
    private String description;

    /**
     * Cached text field value.
     */
    private String text;

    /**
     * Cached linkUrl field value.
     */
    private String linkUrl;

    /**
     * Cached shownItems field value.
     */
    private String[] shownItems;

    /**
     * Cached assetData field value.
     */
    private AssetData assetData;

    /**
     * Cached url field value.
     */
    private String url;

    /**
     * Cached tags field value.
     */
    private String[] tags;

    /**
     * Cached templatePath field value.
     */
    private String templatePath;

    /**
     * Cached language field value.
     */
    private String language;

    /**
     * Flag indicating if the ID field has been initialized.
     */
    private boolean idInitialized = false;

    /**
     * Flag indicating if the type field has been initialized.
     */
    private boolean typeInitialized = false;

    /**
     * Flag indicating if the lastModifiedDate field has been initialized.
     */
    private boolean lastModifiedDateInitialized = false;

    /**
     * Flag indicating if the parentId field has been initialized.
     */
    private boolean parentIdInitialized = false;

    /**
     * Flag indicating if the title field has been initialized.
     */
    private boolean titleInitialized = false;

    /**
     * Flag indicating if the description field has been initialized.
     */
    private boolean descriptionInitialized = false;

    /**
     * Flag indicating if the text field has been initialized.
     */
    private boolean textInitialized = false;

    /**
     * Flag indicating if the linkUrl field has been initialized.
     */
    private boolean linkUrlInitialized = false;

    /**
     * Flag indicating if the shownItems field has been initialized.
     */
    private boolean shownItemsInitialized = false;

    /**
     * Flag indicating if the assetData field has been initialized.
     */
    private boolean assetDataInitialized = false;

    /**
     * Flag indicating if the url field has been initialized.
     */
    private boolean urlInitialized = false;

    /**
     * Flag indicating if the tags field has been initialized.
     */
    private boolean tagsInitialized = false;

    /**
     * Flag indicating if the templatePath field has been initialized.
     */
    private boolean templatePathInitialized = false;

    /**
     * Flag indicating if the language field has been initialized.
     */
    private boolean languageInitialized = false;

    /**
     * Construct the data layer model.
     *
     * @param data The component data.
     * @param eager True to eagerly load the data values.
     */
    public CachingComponentDataImpl(@NotNull final ComponentDataImpl data, boolean eager) {
        this.componentData = data;
        if (eager) {
            this.getId();
            this.getType();
            this.getLastModifiedDate();
            this.getParentId();
            this.getTitle();
            this.getDescription();
            this.getText();
            this.getLinkUrl();
            this.getShownItems();
            this.getAssetData();
            this.getTemplatePath();
            this.getLanguage();
            this.getTags();
            this.getUrl();
        }
    }

    @Override
    @NotNull
    public String getId() {
        if (!this.idInitialized) {
            this.id = this.componentData.getId();
            this.idInitialized = true;
        }
        return this.id;
    }

    @Override
    @Nullable
    public String getType() {
        if (!this.typeInitialized) {
            this.type = this.componentData.getType();
            this.typeInitialized = true;
        }
        return this.type;
    }

    @Override
    @Nullable
    public Date getLastModifiedDate() {
        if (!this.lastModifiedDateInitialized) {
            this.lastModifiedDate = this.componentData.getLastModifiedDate();
            this.lastModifiedDateInitialized = true;
        }
        return Optional.ofNullable(this.lastModifiedDate)
            .map(Date::getTime)
            .map(Date::new)
            .orElse(null);
    }

    @Override
    @Nullable
    public String getParentId() {
        if (!this.parentIdInitialized) {
            this.parentId = this.componentData.getParentId();
            this.parentIdInitialized = true;
        }
        return this.parentId;
    }

    @Override
    @Nullable
    public String getTitle() {
        if (!this.titleInitialized) {
            this.title = this.componentData.getTitle();
            this.titleInitialized = true;
        }
        return this.title;
    }

    @Override
    @Nullable
    public String getDescription() {
        if (!this.descriptionInitialized) {
            this.description = this.componentData.getDescription();
            this.descriptionInitialized = true;
        }
        return this.description;
    }

    @Override
    @Nullable
    public String getText() {
        if (!this.textInitialized) {
            this.text = this.componentData.getText();
            this.textInitialized = true;
        }
        return this.text;
    }

    @Override
    @Nullable
    public String getLinkUrl() {
        if (!this.linkUrlInitialized) {
            this.linkUrl = this.componentData.getLinkUrl();
            this.linkUrlInitialized = true;
        }
        return this.linkUrl;
    }

    @Override
    @Nullable
    public String[] getShownItems() {
        if (!this.shownItemsInitialized) {
            this.shownItems = this.componentData.getShownItems();
            this.shownItemsInitialized = true;
        }
        return Optional.ofNullable(this.shownItems)
            .map(items -> Arrays.copyOf(items, items.length))
            .orElse(null);
    }

    @Override
    @Nullable
    public AssetData getAssetData() {
        if (!this.assetDataInitialized) {
            this.assetData = this.componentData.getAssetData();
            this.assetDataInitialized = true;
        }
        return this.assetData;
    }

    @Override
    @Nullable
    public String getTemplatePath() {
        if (!this.templatePathInitialized) {
            this.templatePath = this.componentData.getTemplatePath();
            this.templatePathInitialized = true;
        }
        return this.templatePath;
    }

    @Override
    @Nullable
    public String getLanguage() {
        if (!this.languageInitialized) {
            this.language = this.componentData.getLanguage();
            this.languageInitialized = true;
        }
        return this.language;
    }

    @Override
    @Nullable
    public String[] getTags() {
        if (!this.tagsInitialized) {
            this.tags = this.componentData.getTags();
            this.tagsInitialized = true;
        }
        return Optional.ofNullable(this.tags)
            .map(items -> Arrays.copyOf(items, items.length))
            .orElse(null);
    }

    @Override
    @Nullable
    public String getUrl() {
        if (!this.urlInitialized) {
            this.url = this.componentData.getUrl();
            this.urlInitialized = true;
        }
        return this.url;
    }

    @Override
    @Nullable
    public String getJson() {
        return ComponentDataImpl.getJson(this);
    }

}
