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
import org.junit.Assume;
import org.junit.Before;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import com.github.sebhoss.common.annotation.CompilerWarnings;

/**
 * TODO: document!
 */
@RunWith(Theories.class)
public class LateFiscalDateGetYearTest {

    /** @see TestObjects#supportedMonths() */
    @DataPoints
    public static Months[]     START_DATES        = TestObjects.supportedMonths();

    /** @see TestObjects#startDates() */
    @DataPoints
    public static LocalDate[]  MONTH_START_DATES  = TestObjects.startDates();

    /** @see TestObjects#middleDates() */
    @DataPoints
    public static LocalDate[]  MONTH_MIDDLE_DATES = TestObjects.middleDates();

    @SuppressWarnings(CompilerWarnings.NULL)
    private Comparator<Months> monthComparator;

    /**
     * Builds the comparator which is used inside this test class.
     */
    @Before
    public void createComparator() {
        monthComparator = new FiscalYearStartsLate();
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
    public void shouldNotAddYearWhenCurrentDateIsAfterStartDate(final Months startDate, final LocalDate currentDate) {
        // Given
        Assume.assumeTrue(currentDate.getMonthOfYear() >= startDate.getMonths());
        final FiscalDate fiscalDate = new FiscalDateImplementation(startDate, monthComparator, currentDate);

        // When
        final int fiscalYear = fiscalDate.getFiscalYear();

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
    public void shouldSubtractYearWhenCurrentDateIsBeforeStartDate(final Months startDate, final LocalDate currentDate) {
        // Given
        Assume.assumeTrue(currentDate.getMonthOfYear() < startDate.getMonths());
        final FiscalDate fiscalDate = new FiscalDateImplementation(startDate, monthComparator, currentDate);

        // When
        final int fiscalYear = fiscalDate.getFiscalYear();

        // Then
        Assert.assertEquals(currentDate.getYear() - 1, fiscalYear);
    }

}
