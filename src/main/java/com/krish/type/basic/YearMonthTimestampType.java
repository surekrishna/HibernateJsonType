package com.krish.type.basic;

import com.krish.type.AbstractHibernateType;
import com.krish.type.basic.internal.YearMonthTypeDescriptor;
import com.krish.type.util.Configuration;

import org.hibernate.type.descriptor.sql.DateTypeDescriptor;
import org.hibernate.type.descriptor.sql.TimestampTypeDescriptor;

import java.time.YearMonth;

/**
 * Maps a Java {@link YearMonth} object to a {@code TIMESTAMP} column type.
 * <p>
 *
 * @author Vlad Mihalcea
 */
public class YearMonthTimestampType
        extends AbstractHibernateType<YearMonth> {

    public static final YearMonthTimestampType INSTANCE = new YearMonthTimestampType();

    public YearMonthTimestampType() {
        super(
            TimestampTypeDescriptor.INSTANCE,
            YearMonthTypeDescriptor.INSTANCE
        );
    }

    public YearMonthTimestampType(Configuration configuration) {
        super(
            TimestampTypeDescriptor.INSTANCE,
            YearMonthTypeDescriptor.INSTANCE,
            configuration
        );
    }

    public String getName() {
        return "yearmonth-timestamp";
    }

    @Override
    protected boolean registerUnderJavaType() {
        return true;
    }
}