package com.krish.type.array;

import com.krish.type.AbstractHibernateType;
import com.krish.type.array.internal.ArraySqlTypeDescriptor;
import com.krish.type.array.internal.UUIDArrayTypeDescriptor;
import com.krish.type.util.Configuration;

import org.hibernate.usertype.DynamicParameterizedType;

import java.util.Properties;
import java.util.UUID;

/**
 * Maps an {@code UUID[]} array on a PostgreSQL ARRAY type.
 * <p>
 * For more details about how to use it, check out <a href="https://vladmihalcea.com/how-to-map-java-and-sql-arrays-with-jpa-and-hibernate/">this article</a> on <a href="https://vladmihalcea.com/">vladmihalcea.com</a>.
 *
 * @author Rafael Acevedo
 */
public class UUIDArrayType
        extends AbstractHibernateType<UUID[]>
        implements DynamicParameterizedType {

    public static final UUIDArrayType INSTANCE = new UUIDArrayType();

    public UUIDArrayType() {
        super(
            ArraySqlTypeDescriptor.INSTANCE,
            new UUIDArrayTypeDescriptor()
        );
    }

    public UUIDArrayType(Configuration configuration) {
        super(
            ArraySqlTypeDescriptor.INSTANCE,
            new UUIDArrayTypeDescriptor(),
            configuration
        );
    }

    public String getName() {
        return "uuid-array";
    }

    @Override
    protected boolean registerUnderJavaType() {
        return true;
    }

    @Override
    public void setParameterValues(Properties parameters) {
        ((UUIDArrayTypeDescriptor) getJavaTypeDescriptor()).setParameterValues(parameters);
    }
}