package com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier;

import com.adobe.cq.wcm.core.components.models.datalayer.AssetData;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Data layer field value supplier.
 * A supplier for every possible Data Layer field is provided via this interface.
 */
public interface DataLayerSupplier {

    /**
     * Get the ID field value supplier.
     *
     * @return The ID field value supplier, or empty if not set.
    */
    @NotNull
    default Optional<Supplier<String>> getId() {
        return Optional.empty();
    }

    /**
     * Get the type field value supplier.
     *
     * @return The type field value supplier, or empty if not set.
    */
    @NotNull
    default Optional<Supplier<String>> getType() {
        return Optional.empty();
    }

    /**
     * Get the last modified date field value supplier.
     *
     * @return The last modified data field value supplier, or empty if not set.
    */
    @NotNull
    default Optional<Supplier<Date>> getLastModifiedDate() {
        return Optional.empty();
    }

    /**
     * Get the parent ID field value supplier.
     *
     * @return The parent ID field value supplier, or empty if not set.
    */
    @NotNull
    default Optional<Supplier<String>> getParentId() {
        return Optional.empty();
    }

    /**
     * Get the title field value supplier.
     *
     * @return The title field value supplier, or empty if not set.
    */
    @NotNull
    default Optional<Supplier<String>> getTitle() {
        return Optional.empty();
    }

    /**
     * Get the description field value supplier.
     *
     * @return The description field value supplier, or empty if not set.
    */
    @NotNull
    default Optional<Supplier<String>> getDescription() {
        return Optional.empty();
    }

    /**
     * Get the text field value supplier.
     *
     * @return The text field value supplier, or empty if not set.
    */
    @NotNull
    default Optional<Supplier<String>> getText() {
        return Optional.empty();
    }

    /**
     * Get the link URL field value supplier.
     *
     * @return The link URL field value supplier, or empty if not set.
    */
    @NotNull
    default Optional<Supplier<String>> getLinkUrl() {
        return Optional.empty();
    }

    /**
     * Get the shown items field value supplier.
     *
     * @return The shown items field value supplier, or empty if not set.
    */
    @NotNull
    default Optional<Supplier<String[]>> getShownItems() {
        return Optional.empty();
    }

    /**
     * Get the URL field value supplier.
     *
     * @return The URL field value supplier, or empty if not set.
    */
    @NotNull
    default Optional<Supplier<String>> getUrl() {
        return Optional.empty();
    }

    /**
     * Get the format field value supplier.
     *
     * @return The format field value supplier, or empty if not set.
    */
    @NotNull
    default Optional<Supplier<String>> getFormat() {
        return Optional.empty();
    }

    /**
     * Get the tags field value supplier.
     *
     * @return The tags field value supplier, or empty if not set.
    */
    @NotNull
    default Optional<Supplier<String[]>> getTags() {
        return Optional.empty();
    }

    /**
     * Get the asset data field value supplier.
     *
     * @return The asset data field value supplier, or empty if not set.
    */
    @NotNull
    default Optional<Supplier<AssetData>> getAssetData()  {
        return Optional.empty();
    }


    /**
     * Get the template path field value supplier.
     *
     * @return The template path field value supplier, or empty if not set.
     */
    @NotNull
    default Optional<Supplier<String>> getTemplatePath() {
        return Optional.empty();
    }

    /**
     * Get the language field value supplier.
     *
     * @return The language field value supplier, or empty if not set.
     */
    @NotNull
    default Optional<Supplier<String>> getLanguage() {
        return Optional.empty();
    }
}
