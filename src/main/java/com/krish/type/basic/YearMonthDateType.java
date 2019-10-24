package com.krish.type.basic;

import com.krish.type.AbstractHibernateType;
import com.krish.type.basic.internal.YearMonthTypeDescriptor;
import com.krish.type.util.Configuration;

import org.hibernate.type.descriptor.sql.DateTypeDescriptor;

import java.time.YearMonth;

/**
 * Maps a Java {@link java.time.YearMonth} object to a {@code DATE} column type.
 * <p>
 * For more details about how to use it, check out <a href="https://vladmihalcea.com/java-yearmonth-jpa-hibernate/">this article</a> on <a href="https://vladmihalcea.com/">vladmihalcea.com</a>.
 *
 * @author Vlad Mihalcea
 */
public class YearMonthDateType
        extends AbstractHibernateType<YearMonth> {

    public static final YearMonthDateType INSTANCE = new YearMonthDateType();

    public YearMonthDateType() {
        super(
            DateTypeDescriptor.INSTANCE,
            YearMonthTypeDescriptor.INSTANCE
        );
    }

    public YearMonthDateType(Configuration configuration) {
        super(
            DateTypeDescriptor.INSTANCE,
            YearMonthTypeDescriptor.INSTANCE,
            configuration
        );
    }

    public String getName() {
        return "yearmonth-date";
    }

    @Override
    protected boolean registerUnderJavaType() {
        return true;
    }
}