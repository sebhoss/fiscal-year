/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.time;

import org.joda.time.LocalDate;
import org.joda.time.Months;
import org.junit.Assert;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import com.github.sebhoss.common.annotation.CompilerWarnings;
import com.github.sebhoss.datasets.Datasets;

/**
 * Test cases for {@link FiscalDate#plusYears(int)}.
 */
@RunWith(Theories.class)
@SuppressWarnings(CompilerWarnings.STATIC_METHOD)
public class FiscalDatePlusYearsTest {

    /** @see TestObjects#supportedMonths() */
    @DataPoints
    public static Months[]    START_DATES        = TestObjects.supportedMonths();

    /** @see TestObjects#startDates() */
    @DataPoints
    public static LocalDate[] MONTH_START_DATES  = TestObjects.startDates();

    /** @see TestObjects#middleDates() */
    @DataPoints
    public static LocalDate[] MONTH_MIDDLE_DATES = TestObjects.middleDates();

    /** The amount of years to add a given date */
    @DataPoints
    public static int[]       ADDITIONAL_YEARS   = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 25, 50, 100, 5000 };

    /** The amount of random years to add a given date */
    @DataPoints
    public static int[]       RANDOM_YEARS       = Datasets.ints().lowestInclusive(-292275054)
                                                         .highestInclusive(292278993).build();

    /**
     * Ensures that for any given date a number of years can be added in an early fiscal year.
     * 
     * @param startDate
     *            The start date of the fiscal year.
     * @param currentDate
     *            The current date in a calendar year.
     * @param additionalYears
     *            The amounts of years to add.
     */
    @Theory
    public void shouldAddYearsInEarlyFiscalYear(final Months startDate, final LocalDate currentDate,
            final int additionalYears) {
        // Given
        final FiscalDate fiscalDate = FiscalYears.earlyFiscalYear(startDate.getMonths()).create(currentDate);

        // When
        final FiscalDate newDate = fiscalDate.plusYears(additionalYears);

        // Then
        Assert.assertEquals(fiscalDate.getFiscalYear() + additionalYears, newDate.getFiscalYear());
    }

    /**
     * Ensures that for any given date a number of years can be added in a late fiscal year.
     * 
     * @param startDate
     *            The start date of the fiscal year.
     * @param currentDate
     *            The current date in a calendar year.
     * @param additionalYears
     *            The amounts of years to add.
     */
    @Theory
    public void shouldAddYearsInLateFiscalYear(final Months startDate, final LocalDate currentDate,
            final int additionalYears) {
        // Given
        final FiscalDate fiscalDate = FiscalYears.lateFiscalYear(startDate.getMonths()).create(currentDate);

        // When
        final FiscalDate newDate = fiscalDate.plusYears(additionalYears);

        // Then
        Assert.assertEquals(fiscalDate.getFiscalYear() + additionalYears, newDate.getFiscalYear());
    }

}
