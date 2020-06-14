package com.adobe.cq.wcm.core.components.models.datalayer.builder.impl;

import com.adobe.cq.wcm.core.components.models.datalayer.ComponentData;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.DataLayerSupplier;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.function.Supplier;

class ComponentDataImpl implements ComponentData {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ComponentDataImpl.class);

    /**
     * The current data layer supplier.
     */
    @NotNull
    private final DataLayerSupplier dataLayerSupplier;

    ComponentDataImpl(@NotNull final DataLayerSupplier supplier) {
        this.dataLayerSupplier = supplier;
    }

    @Override
    //TODO: should null be allowed
    public String getId() {
        return this.dataLayerSupplier
            .getId()
            .map(Supplier::get)
            .orElse(null);
    }

    @Override
    @Nullable
    public String getType() {
        return this.dataLayerSupplier
            .getType()
            .map(Supplier::get)
            .orElse(null);
    }

    @Override
    @Nullable
    public Date getLastModifiedDate() {
        return this.dataLayerSupplier
            .getLastModifiedDate()
            .map(Supplier::get)
            .orElse(null);
    }

    @Override
    @Nullable
    public String getParentId() {
        return this.dataLayerSupplier
            .getParentId()
            .map(Supplier::get)
            .orElse(null);
    }

    @Override
    @Nullable
    public String getTitle() {
        return this.dataLayerSupplier
            .getTitle()
            .map(Supplier::get)
            .orElse(null);
    }

    @Override
    @Nullable
    public String getDescription() {
        return this.dataLayerSupplier
            .getDescription()
            .map(Supplier::get)
            .orElse(null);
    }

    @Override
    @Nullable
    public String getText() {
        return this.dataLayerSupplier
            .getText()
            .map(Supplier::get)
            .orElse(null);
    }

    @Override
    @Nullable
    public String getLinkUrl() {
        return this.dataLayerSupplier
            .getLinkUrl()
            .map(Supplier::get)
            .orElse(null);
    }

    @Override
    @Nullable
    public String getJson() {
        try {
            return String.format("{\"%s\":%s}",
                getId(),
                new ObjectMapper().writeValueAsString(this));
        } catch (JsonProcessingException e) {
            LOGGER.error("Unable to generate dataLayer JSON string", e);
        }
        return null;
    }

    /**
     * Get the data layer supplier.
     *
     * @return The data layer supplier.
     */
    @NotNull
    protected DataLayerSupplier getDataLayerSupplier() {
        return this.dataLayerSupplier;
    }
}
