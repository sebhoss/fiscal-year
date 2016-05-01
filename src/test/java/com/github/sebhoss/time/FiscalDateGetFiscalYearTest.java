/*
 * This file is part of fiscal-year. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of fiscal-year,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package com.github.sebhoss.time;

import java.time.LocalDate;
import java.time.Month;

import com.github.sebhoss.warnings.CompilerWarnings;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * Test cases for {@link FiscalDate#getFiscalYear()}.
 */
@RunWith(Theories.class)
@SuppressWarnings(CompilerWarnings.STATIC_METHOD)
public class FiscalDateGetFiscalYearTest {

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
     * Ensures that for any given date the fiscal year will be increased if the current calendar date is after the
     * fiscal year start date.
     *
     * @param startDate
     *            The start date of the fiscal year.
     * @param currentDate
     *            The current date in a calendar year.
     */
    @Theory
    public void shouldAddYearWhenCurrentDateIsAfterStartDate(final Month startDate, final LocalDate currentDate) {
        // Given
        Assume.assumeTrue(currentDate.getMonthValue() >= startDate.getValue());
        final FiscalDate fiscalDate = FiscalYears.earlyFiscalYear(startDate.getValue()).createFromCalendarDate(
                currentDate);

        // When
        final long fiscalYear = fiscalDate.getFiscalYear();

        // Then
        Assert.assertEquals(currentDate.getYear() + 1, fiscalYear);
    }

    /**
     * Ensures that for any given date the fiscal year will not be increased if the current calendar date is before the
     * fiscal year start date.
     *
     * @param startDate
     *            The start date of the fiscal year.
     * @param currentDate
     *            The current date in a calendar year.
     */
    @Theory
    public void shouldNotAddYearWhenCurrentDateIsBeforeStartDate(final Month startDate, final LocalDate currentDate) {
        // Given
        Assume.assumeTrue(currentDate.getMonthValue() < startDate.getValue());
        final FiscalDate fiscalDate = FiscalYears.earlyFiscalYear(startDate.getValue()).createFromCalendarDate(
                currentDate);

        // When
        final long fiscalYear = fiscalDate.getFiscalYear();

        // Then
        Assert.assertEquals(currentDate.getYear(), fiscalYear);
    }

    /**
     * Ensures that for any given date the fiscal year will not be increased if the current calendar date is after the
     * fiscal year start date.
     *
     * @param startDate
     *            The start date of the fiscal year.
     * @param currentDate
     *            The current date in a calendar year.
     */
    @Theory
    public void shouldNotAddYearWhenCurrentDateIsAfterStartDate(final Month startDate, final LocalDate currentDate) {
        // Given
        Assume.assumeTrue(currentDate.getMonthValue() >= startDate.getValue());
        final FiscalDate fiscalDate = FiscalYears.lateFiscalYear(startDate.getValue()).createFromCalendarDate(
                currentDate);

        // When
        final long fiscalYear = fiscalDate.getFiscalYear();

        // Then
        Assert.assertEquals(currentDate.getYear(), fiscalYear);
    }

    /**
     * Ensures that for any given date the fiscal year will be decreased if the current calendar date is before the
     * fiscal year start date.
     *
     * @param startDate
     *            The start date of the fiscal year.
     * @param currentDate
     *            The current date in a calendar year.
     */
    @Theory
    public void shouldSubtractYearWhenCurrentDateIsBeforeStartDate(final Month startDate, final LocalDate currentDate) {
        // Given
        Assume.assumeTrue(currentDate.getMonthValue() < startDate.getValue());
        final FiscalDate fiscalDate = FiscalYears.lateFiscalYear(startDate.getValue()).createFromCalendarDate(
                currentDate);

        // When
        final long fiscalYear = fiscalDate.getFiscalYear();

        // Then
        Assert.assertEquals(currentDate.getYear() - 1, fiscalYear);
    }

}
