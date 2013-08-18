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
import org.junit.Assume;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import com.github.sebhoss.common.annotation.CompilerWarnings;

/**
 * Test cases for {@link FiscalDate#getFiscalMonth()}.
 */
@RunWith(Theories.class)
@SuppressWarnings(CompilerWarnings.STATIC_METHOD)
public class FiscalDateGetFiscalMonthTest {

    /** @see TestObjects#supportedMonths() */
    @DataPoints
    public static Months[]    START_DATES        = TestObjects.supportedMonths();

    /** @see TestObjects#startDates() */
    @DataPoints
    public static LocalDate[] MONTH_START_DATES  = TestObjects.startDates();

    /** @see TestObjects#middleDates() */
    @DataPoints
    public static LocalDate[] MONTH_MIDDLE_DATES = TestObjects.middleDates();

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
    public void shouldSubtractMonthWhenCurrentDateIsAfterStartDateInEarlyFiscalYear(final Months startDate,
            final LocalDate currentDate) {
        // Given
        Assume.assumeTrue(currentDate.getMonthOfYear() >= startDate.getMonths());
        final FiscalDate fiscalDate = FiscalYears.earlyFiscalYear(startDate).createFromCalendarDate(currentDate);

        // When
        final int fiscalMonth = fiscalDate.getFiscalMonth();

        // Then
        Assert.assertEquals(currentDate.getMonthOfYear() - startDate.getMonths() + 1, fiscalMonth);
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
    public void shouldAddMonthWhenCurrentDateIsBeforeStartDateInEarlyFiscalYear(final Months startDate,
            final LocalDate currentDate) {
        // Given
        Assume.assumeTrue(currentDate.getMonthOfYear() < startDate.getMonths());
        final FiscalDate fiscalDate = FiscalYears.earlyFiscalYear(startDate).createFromCalendarDate(currentDate);
        final int fiscalMonthOffset = currentDate.monthOfYear().getMaximumValue() - startDate.getMonths() + 1;

        // When
        final int fiscalMonth = fiscalDate.getFiscalMonth();

        // Then
        Assert.assertEquals(currentDate.getMonthOfYear() + fiscalMonthOffset, fiscalMonth);
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
    public void shouldSubtractMonthWhenCurrentDateIsAfterStartDateInLateFiscalYear(final Months startDate,
            final LocalDate currentDate) {
        // Given
        Assume.assumeTrue(currentDate.getMonthOfYear() >= startDate.getMonths());
        final FiscalDate fiscalDate = FiscalYears.lateFiscalYear(startDate).createFromCalendarDate(currentDate);

        // When
        final int fiscalMonth = fiscalDate.getFiscalMonth();

        // Then
        Assert.assertEquals(currentDate.getMonthOfYear() - startDate.getMonths() + 1, fiscalMonth);
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
    public void shouldAddMonthWhenCurrentDateIsBeforeStartDateInLateFiscalYear(final Months startDate,
            final LocalDate currentDate) {
        // Given
        Assume.assumeTrue(currentDate.getMonthOfYear() < startDate.getMonths());
        final FiscalDate fiscalDate = FiscalYears.lateFiscalYear(startDate).createFromCalendarDate(currentDate);
        final int fiscalMonthOffset = currentDate.monthOfYear().getMaximumValue() - startDate.getMonths() + 1;

        // When
        final int fiscalMonth = fiscalDate.getFiscalMonth();

        // Then
        Assert.assertEquals(currentDate.getMonthOfYear() + fiscalMonthOffset, fiscalMonth);
    }

}
