/*
 * This file is part of fiscal-year. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of fiscal-year,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.utils.fiscal_year;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

import org.junit.Assert;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import de.xn__ho_hia.quality.suppression.CompilerWarnings;

/**
 * Test cases for {@link FiscalDate#getCalendarWeekOfWeekyear()}.
 */
@RunWith(Theories.class)
@SuppressWarnings(CompilerWarnings.STATIC_METHOD)
public class FiscalDateGetCalendarWeekOfWeekyearTest {

    /** @see TestObjects#supportedMonths() */
    @DataPoints
    public static final Month[]     START_DATES        = TestObjects.supportedMonths();

    /** @see TestObjects#startDates() */
    @DataPoints
    public static final LocalDate[] MONTH_START_DATES  = TestObjects.startDates();

    /** @see TestObjects#middleDates() */
    @DataPoints
    public static final LocalDate[] MONTH_MIDDLE_DATES = TestObjects.middleDates();

    /**
     * Ensures that for any given date the correct calendar week of weekyear will be returned in an early fiscal year.
     *
     * @param startDate
     *            The start date of the fiscal year.
     * @param currentDate
     *            The current date in a calendar year.
     */
    @Theory
    public void shouldReturnCalendarWeekOfWeekyearInEarlyFiscalYear(final Month startDate,
            final LocalDate currentDate) {
        // Given
        final FiscalDate fiscalDate = FiscalYears.earlyFiscalYear(startDate).createFromCalendarDate(currentDate);

        // When
        final long calendarWeekOfWeekyear = fiscalDate.getCalendarWeekOfWeekyear();

        // Then
        Assert.assertEquals(currentDate.get(ChronoField.ALIGNED_WEEK_OF_YEAR), calendarWeekOfWeekyear);
    }

    /**
     * Ensures that for any given date the correct calendar week of weekyear will be returned in a late fiscal year.
     *
     * @param startDate
     *            The start date of the fiscal year.
     * @param currentDate
     *            The current date in a calendar year.
     */
    @Theory
    public void shouldReturnCalendarWeekOfWeekyearInLateFiscalYear(final Month startDate, final LocalDate currentDate) {
        // Given
        final FiscalDate fiscalDate = FiscalYears.lateFiscalYear(startDate).createFromCalendarDate(currentDate);

        // When
        final long calendarWeekOfWeekyear = fiscalDate.getCalendarWeekOfWeekyear();

        // Then
        Assert.assertEquals(currentDate.get(ChronoField.ALIGNED_WEEK_OF_YEAR), calendarWeekOfWeekyear);
    }

}
