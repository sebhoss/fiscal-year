/*
 * Copyright © 2013 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.time;

import java.time.LocalDate;
import java.time.Month;

import com.github.sebhoss.warnings.CompilerWarnings;

import org.junit.Assert;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * Test cases for {@link FiscalDate#getCalendarDayOfYear()}.
 */
@RunWith(Theories.class)
@SuppressWarnings(CompilerWarnings.STATIC_METHOD)
public class FiscalDateGetCalendarDayOfYearTest {

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
     * Ensures that for any given date the correct calendar day of year will be returned in an early fiscal year.
     *
     * @param startDate
     *            The start date of the fiscal year.
     * @param currentDate
     *            The current date in a calendar year.
     */
    @Theory
    public void shouldReturnCalendarDayOfYearInEarlyFiscalYear(final Month startDate, final LocalDate currentDate) {
        // Given
        final FiscalDate fiscalDate = FiscalYears.earlyFiscalYear(startDate).createFromCalendarDate(currentDate);

        // When
        final long calendarDayOfYear = fiscalDate.getCalendarDayOfYear();

        // Then
        Assert.assertEquals(currentDate.getDayOfYear(), calendarDayOfYear);
    }

    /**
     * Ensures that for any given date the correct calendar day of year will be returned in a late fiscal year.
     *
     * @param startDate
     *            The start date of the fiscal year.
     * @param currentDate
     *            The current date in a calendar year.
     */
    @Theory
    public void shouldReturnCalendarDayOfYearInLateFiscalYear(final Month startDate, final LocalDate currentDate) {
        // Given
        final FiscalDate fiscalDate = FiscalYears.lateFiscalYear(startDate).createFromCalendarDate(currentDate);

        // When
        final long calendarDayOfYear = fiscalDate.getCalendarDayOfYear();

        // Then
        Assert.assertEquals(currentDate.getDayOfYear(), calendarDayOfYear);
    }

}
