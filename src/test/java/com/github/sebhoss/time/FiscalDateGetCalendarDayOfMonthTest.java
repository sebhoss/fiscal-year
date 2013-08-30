/*
 * Copyright © 2013 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
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

/**
 * Test cases for {@link FiscalDate#getCalendarDayOfMonth()}.
 */
@RunWith(Theories.class)
@SuppressWarnings(CompilerWarnings.STATIC_METHOD)
public class FiscalDateGetCalendarDayOfMonthTest {

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
     * Ensures that for any given date the correct calendar day of month will be returned in an early fiscal year.
     * 
     * @param startDate
     *            The start date of the fiscal year.
     * @param currentDate
     *            The current date in a calendar year.
     */
    @Theory
    public void shouldReturnCalendarDayOfMonthInEarlyFiscalYear(final Months startDate, final LocalDate currentDate) {
        // Given
        final FiscalDate fiscalDate = FiscalYears.earlyFiscalYear(startDate).createFromCalendarDate(currentDate);

        // When
        final int calendarDayOfMonth = fiscalDate.getCalendarDayOfMonth();

        // Then
        Assert.assertEquals(currentDate.getDayOfMonth(), calendarDayOfMonth);
    }

    /**
     * Ensures that for any given date the correct calendar day of month will be returned in a late fiscal year.
     * 
     * @param startDate
     *            The start date of the fiscal year.
     * @param currentDate
     *            The current date in a calendar year.
     */
    @Theory
    public void shouldReturnCalendarDayOfMonthInLateFiscalYear(final Months startDate, final LocalDate currentDate) {
        // Given
        final FiscalDate fiscalDate = FiscalYears.lateFiscalYear(startDate).createFromCalendarDate(currentDate);

        // When
        final int calendarDayOfMonth = fiscalDate.getCalendarDayOfMonth();

        // Then
        Assert.assertEquals(currentDate.getDayOfMonth(), calendarDayOfMonth);
    }

}
