package com.krish.type.array;

import com.krish.type.AbstractHibernateType;
import com.krish.type.array.internal.ArraySqlTypeDescriptor;
import com.krish.type.array.internal.IntArrayTypeDescriptor;
import com.krish.type.util.Configuration;

import org.hibernate.usertype.DynamicParameterizedType;

import java.util.Properties;

/**
 * Maps an {@code int[]} array on a PostgreSQL ARRAY type.
 * <p>
 * For more details about how to use it, check out <a href="https://vladmihalcea.com/how-to-map-java-and-sql-arrays-with-jpa-and-hibernate/">this article</a> on <a href="https://vladmihalcea.com/">vladmihalcea.com</a>.
 *
 * @author Vlad Mihalcea
 */
public class IntArrayType
        extends AbstractHibernateType<int[]>
        implements DynamicParameterizedType {

    public static final IntArrayType INSTANCE = new IntArrayType();

    public IntArrayType() {
        super(
            ArraySqlTypeDescriptor.INSTANCE,
            new IntArrayTypeDescriptor()
        );
    }

    public IntArrayType(Configuration configuration) {
        super(
            ArraySqlTypeDescriptor.INSTANCE,
            new IntArrayTypeDescriptor(), configuration
        );
    }

    public String getName() {
        return "int-array";
    }

    @Override
    protected boolean registerUnderJavaType() {
        return true;
    }

    @Override
    public void setParameterValues(Properties parameters) {
        ((IntArrayTypeDescriptor) getJavaTypeDescriptor()).setParameterValues(parameters);
    }
}