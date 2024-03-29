package com.krish.type.array;

import com.krish.type.AbstractHibernateType;
import com.krish.type.array.internal.ArraySqlTypeDescriptor;
import com.krish.type.array.internal.StringArrayTypeDescriptor;
import com.krish.type.util.Configuration;

import org.hibernate.usertype.DynamicParameterizedType;

import java.util.Properties;

/**
 * Maps an {@code String[]} array on a PostgreSQL ARRAY type.
 * <p>
 * For more details about how to use it, check out <a href="https://vladmihalcea.com/how-to-map-java-and-sql-arrays-with-jpa-and-hibernate/">this article</a> on <a href="https://vladmihalcea.com/">vladmihalcea.com</a>.
 *
 * @author Vlad Mihalcea
 */
public class StringArrayType
        extends AbstractHibernateType<String[]>
        implements DynamicParameterizedType {

    public static final StringArrayType INSTANCE = new StringArrayType();

    public StringArrayType() {
        super(
            ArraySqlTypeDescriptor.INSTANCE,
            new StringArrayTypeDescriptor()
        );
    }

    public StringArrayType(Configuration configuration) {
        super(
            ArraySqlTypeDescriptor.INSTANCE,
            new StringArrayTypeDescriptor(),
            configuration
        );
    }

    public String getName() {
        return "string-array";
    }

    @Override
    protected boolean registerUnderJavaType() {
        return true;
    }

    @Override
    public void setParameterValues(Properties parameters) {
        ((StringArrayTypeDescriptor) getJavaTypeDescriptor()).setParameterValues(parameters);
    }
}