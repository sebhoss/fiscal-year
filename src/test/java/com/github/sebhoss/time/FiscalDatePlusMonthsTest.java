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
import com.github.sebhoss.datasets.DataSets;

/**
 * TODO: document!
 */
@RunWith(Theories.class)
@SuppressWarnings(CompilerWarnings.STATIC_METHOD)
public class FiscalDatePlusMonthsTest {

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

    /** The amount of months to add a given date */
    @DataPoints
    public static int[]                ADDITIONAL_MONTHS  = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 25, 50, 100, 5000 };

    /** The amount of random months to add a given date */
    @DataPoints
    public static int[]                RANDOM_MONTHS      = DataSets.ints().build();

    /**
     * Ensures that for any given date a number of years can be added.
     * 
     * @param startDate
     *            The start date of the fiscal year.
     * @param monthComparator
     *            The comparator to use.
     * @param currentDate
     *            The current date in a calendar year.
     * @param additionalMonths
     *            The amounts of months to add.
     */
    @Theory
    public void shouldAddMonths(final Months startDate, final Comparator<Months> monthComparator,
            final LocalDate currentDate, final int additionalMonths) {
        // Given
        final FiscalDate fiscalDate = new FiscalDateImplementation(startDate, monthComparator, currentDate);

        // When
        final FiscalDate newDate = fiscalDate.plusMonths(additionalMonths);

        // Then
        Assert.assertEquals(
                additionalMonths,
                Months.monthsBetween(FiscalDatePlusMonthsTest.toLocalDate(fiscalDate),
                        FiscalDatePlusMonthsTest.toLocalDate(newDate)).getMonths());
    }

    private static LocalDate toLocalDate(final FiscalDate fiscalDate) {
        return new LocalDate(fiscalDate.getCalendarYear(), fiscalDate.getCalendarMonth(),
                fiscalDate.getCalendarDayOfMonth());
    }

}
