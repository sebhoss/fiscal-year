/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.time;

import java.util.Comparator;

import org.joda.time.LocalDate;
import org.joda.time.Months;
import org.junit.Assert;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import com.github.sebhoss.common.annotation.CompilerWarnings;

/**
 * TODO: document!
 */
@RunWith(Theories.class)
@SuppressWarnings(CompilerWarnings.STATIC_METHOD)
public class FiscalDateGetCalendarDayOfYearTest {

    /** @see TestObjects#supportedMonths() */
    @DataPoints
    public static Months[]             START_DATES        = TestObjects.supportedMonths();

    /** @see TestObjects#startDates() */
    @DataPoints
    public static LocalDate[]          MONTH_START_DATES  = TestObjects.startDates();

    /** @see TestObjects#middleDates() */
    @DataPoints
    public static LocalDate[]          MONTH_MIDDLE_DATES = TestObjects.middleDates();

    /** @see TestObjects#comparators() */
    @DataPoints
    public static Comparator<Months>[] COMPARATORS        = TestObjects.comparators();

    /**
     * Ensures that for any given date the correct calendar day of year will be returned.
     * 
     * @param startDate
     *            The start date of the fiscal year.
     * @param monthComparator
     *            The comparator to use.
     * @param currentDate
     *            The current date in a calendar year.
     */
    @Theory
    public void shouldReturnCalendarDayOfYear(final Months startDate, final Comparator<Months> monthComparator,
            final LocalDate currentDate) {
        // Given
        final FiscalDate fiscalDate = new FiscalDateImplementation(startDate, monthComparator, currentDate);

        // When
        final int calendarDayOfYear = fiscalDate.getCalendarDayOfYear();

        // Then
        Assert.assertEquals(currentDate.getDayOfYear(), calendarDayOfYear);
    }

}
