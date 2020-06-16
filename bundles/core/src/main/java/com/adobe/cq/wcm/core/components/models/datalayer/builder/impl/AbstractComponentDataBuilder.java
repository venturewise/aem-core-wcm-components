package com.adobe.cq.wcm.core.components.models.datalayer.builder.impl;

import com.adobe.cq.wcm.core.components.models.datalayer.ComponentData;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.GenericComponentDataBuilder;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.DataLayerSupplier;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.fields.DescriptionFieldWrapper;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.fields.IdFieldWrapper;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.fields.LastModifiedDateFieldWrapper;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.fields.LinkUrlFieldWrapper;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.fields.ParentIdFieldWrapper;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.fields.TextFieldWrapper;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.fields.TitleFieldWrapper;
import com.adobe.cq.wcm.core.components.models.datalayer.builder.impl.supplier.fields.TypeFieldWrapper;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.function.Supplier;

/**
 * Abstract component data builder.
 *
 * All data builders that produce {@link ComponentData} should extend this class.
 *
 * @param <T> The data builder type.
 * @param <K> The data type.
 */
abstract class AbstractComponentDataBuilder<T extends GenericComponentDataBuilder<T, K>, K extends ComponentData>
    extends AbstractDataBuilder<T, K>
    implements GenericComponentDataBuilder<T, K> {

    /**
     * Construct an abstract component data builder.
     *
     * @param supplier The data layer supplier.
     */
    protected AbstractComponentDataBuilder(@NotNull final DataLayerSupplier supplier) {
        super(supplier);
    }

    @Override
    @NotNull
    public T withId(@NotNull final Supplier<String> supplier) {
        return this.createInstance(new IdFieldWrapper(this.getDataLayerSupplier(), supplier));
    }

    @Override
    @NotNull
    public T withType(@NotNull final Supplier<String> supplier) {
        return this.createInstance(new TypeFieldWrapper(this.getDataLayerSupplier(), supplier));
    }

    @Override
    @NotNull
    public T withLastModifiedDate(@NotNull final Supplier<Date> supplier) {
        return this.createInstance(new LastModifiedDateFieldWrapper(this.getDataLayerSupplier(), supplier));
    }

    @Override
    @NotNull
    public T withParentId(@NotNull final Supplier<String> supplier) {
        return this.createInstance(new ParentIdFieldWrapper(this.getDataLayerSupplier(), supplier));
    }

    @Override
    @NotNull
    public T withTitle(@NotNull final Supplier<String> supplier) {
        return this.createInstance(new TitleFieldWrapper(this.getDataLayerSupplier(), supplier));
    }

    @Override
    @NotNull
    public T withDescription(@NotNull final Supplier<String> supplier) {
        return this.createInstance(new DescriptionFieldWrapper(this.getDataLayerSupplier(), supplier));
    }

    @Override
    @NotNull
    public T withText(@NotNull final Supplier<String> supplier) {
        return this.createInstance(new TextFieldWrapper(this.getDataLayerSupplier(), supplier));
    }

    @Override
    @NotNull
    public T withLinkUrl(@NotNull final Supplier<String> supplier) {
        return this.createInstance(new LinkUrlFieldWrapper(this.getDataLayerSupplier(), supplier));
    }

}
