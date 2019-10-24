package com.krish.type.array;

import com.krish.type.AbstractHibernateType;
import com.krish.type.array.internal.ArraySqlTypeDescriptor;
import com.krish.type.array.internal.LongArrayTypeDescriptor;
import com.krish.type.util.Configuration;

import org.hibernate.usertype.DynamicParameterizedType;

import java.util.Properties;

/**
 * Maps an {@code long[]} array on a PostgreSQL ARRAY type.
 * <p>
 * For more details about how to use it, check out <a href=
 * "https://vladmihalcea.com/how-to-map-java-and-sql-arrays-with-jpa-and-hibernate/">this
 * article</a> on <a href="https://vladmihalcea.com/">vladmihalcea.com</a>.
 *
 * @author Vlad Mihalcea
 */
public class LongArrayType
		extends AbstractHibernateType<long[]>
        implements DynamicParameterizedType {

    public static final LongArrayType INSTANCE = new LongArrayType();

    public LongArrayType() {
		super(
            ArraySqlTypeDescriptor.INSTANCE,
            new LongArrayTypeDescriptor()
        );
    }

    public LongArrayType(Configuration configuration) {
        super(
            ArraySqlTypeDescriptor.INSTANCE,
            new LongArrayTypeDescriptor(),
            configuration
        );
    }

    @Override
	public String getName() {
		return "long-array";
    }

    @Override
    protected boolean registerUnderJavaType() {
        return true;
    }

    @Override
    public void setParameterValues(Properties parameters) {
		((LongArrayTypeDescriptor) getJavaTypeDescriptor()).setParameterValues(parameters);
    }
}