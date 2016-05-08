/*
 * This file is part of fiscal-year. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of fiscal-year,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.utils.fiscal_year;

import java.time.LocalDate;
import java.time.Month;

import de.xn__ho_hia.utils.fiscal_year.FiscalDate;
import de.xn__ho_hia.utils.fiscal_year.FiscalYears;
import de.xn__ho_hia.utils.jdt.CompilerWarnings;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * Test cases for {@link FiscalDate#getFiscalMonth()}.
 */
@RunWith(Theories.class)
@SuppressWarnings(CompilerWarnings.STATIC_METHOD)
public class FiscalDateGetFiscalMonthTest {

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
     * Ensures that for any given date the fiscal month will be decreased if the current calendar date is after the
     * fiscal year start date in an early fiscal year.
     *
     * @param startDate
     *            The start date of the fiscal year.
     * @param currentDate
     *            The current date in a calendar year.
     */
    @Theory
    public void shouldSubtractMonthWhenCurrentDateIsAfterStartDateInEarlyFiscalYear(final Month startDate,
            final LocalDate currentDate) {
        // Given
        Assume.assumeTrue(currentDate.getMonthValue() >= startDate.getValue());
        final FiscalDate fiscalDate = FiscalYears.earlyFiscalYear(startDate).createFromCalendarDate(currentDate);

        // When
        final long fiscalMonth = fiscalDate.getFiscalMonth();

        // Then
        Assert.assertEquals(currentDate.getMonthValue() - startDate.getValue() + 1, fiscalMonth);
    }

    /**
     * Ensures that for any given date the fiscal month will be increased if the current calendar date is before the
     * fiscal year start date in an early fiscal year.
     *
     * @param startDate
     *            The start date of the fiscal year.
     * @param currentDate
     *            The current date in a calendar year.
     */
    @Theory
    public void shouldAddMonthWhenCurrentDateIsBeforeStartDateInEarlyFiscalYear(final Month startDate,
            final LocalDate currentDate) {
        // Given
        Assume.assumeTrue(currentDate.getMonthValue() < startDate.getValue());
        final FiscalDate fiscalDate = FiscalYears.earlyFiscalYear(startDate).createFromCalendarDate(currentDate);
        final int fiscalMonthOffset = Month.values().length - startDate.getValue() + 1;

        // When
        final long fiscalMonth = fiscalDate.getFiscalMonth();

        // Then
        Assert.assertEquals(currentDate.getMonthValue() + fiscalMonthOffset, fiscalMonth);
    }

    /**
     * Ensures that for any given date the fiscal month will be decreased if the current calendar date is after the
     * fiscal year start date in a late fiscal year.
     *
     * @param startDate
     *            The start date of the fiscal year.
     * @param currentDate
     *            The current date in a calendar year.
     */
    @Theory
    public void shouldSubtractMonthWhenCurrentDateIsAfterStartDateInLateFiscalYear(final Month startDate,
            final LocalDate currentDate) {
        // Given
        Assume.assumeTrue(currentDate.getMonthValue() >= startDate.getValue());
        final FiscalDate fiscalDate = FiscalYears.lateFiscalYear(startDate).createFromCalendarDate(currentDate);

        // When
        final long fiscalMonth = fiscalDate.getFiscalMonth();

        // Then
        Assert.assertEquals(currentDate.getMonthValue() - startDate.getValue() + 1, fiscalMonth);
    }

    /**
     * Ensures that for any given date the fiscal month will be increased if the current calendar date is before the
     * fiscal year start date in a late fiscal year.
     *
     * @param startDate
     *            The start date of the fiscal year.
     * @param currentDate
     *            The current date in a calendar year.
     */
    @Theory
    public void shouldAddMonthWhenCurrentDateIsBeforeStartDateInLateFiscalYear(final Month startDate,
            final LocalDate currentDate) {
        // Given
        Assume.assumeTrue(currentDate.getMonthValue() < startDate.getValue());
        final FiscalDate fiscalDate = FiscalYears.lateFiscalYear(startDate).createFromCalendarDate(currentDate);
        final int fiscalMonthOffset = Month.values().length - startDate.getValue() + 1;

        // When
        final long fiscalMonth = fiscalDate.getFiscalMonth();

        // Then
        Assert.assertEquals(currentDate.getMonthValue() + fiscalMonthOffset, fiscalMonth);
    }

}
