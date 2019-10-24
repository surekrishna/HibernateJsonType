package com.krish.type.basic;

import com.krish.type.AbstractHibernateType;
import com.krish.type.basic.internal.YearMonthEpochTypeDescriptor;
import com.krish.type.util.Configuration;

import org.hibernate.type.descriptor.sql.SmallIntTypeDescriptor;

import java.time.YearMonth;

/**
 * Maps a Java {@link YearMonth} object to an small and continuous {@code INT} column type
 * which defines the months that passed since the Unix epoch.
 *
 * @author Vlad Mihalcea
 */
public class YearMonthEpochType
        extends AbstractHibernateType<YearMonth> {

    public static final YearMonthEpochType INSTANCE = new YearMonthEpochType();

    public YearMonthEpochType() {
        super(
            SmallIntTypeDescriptor.INSTANCE,
            YearMonthEpochTypeDescriptor.INSTANCE
        );
    }

    public YearMonthEpochType(Configuration configuration) {
        super(
            SmallIntTypeDescriptor.INSTANCE,
            YearMonthEpochTypeDescriptor.INSTANCE,
            configuration
        );
    }

    public String getName() {
        return "yearmonth-epoch";
    }

    @Override
    protected boolean registerUnderJavaType() {
        return true;
    }
}