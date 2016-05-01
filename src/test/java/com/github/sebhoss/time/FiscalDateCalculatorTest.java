/*
 * Copyright © 2013 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.time;

import java.time.LocalDate;

import com.github.sebhoss.warnings.CompilerWarnings;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for {@link FiscalDateCalculator}.
 */
@SuppressWarnings(CompilerWarnings.STATIC_METHOD)
public class FiscalDateCalculatorTest {

    /**
     * Ensures that the EarlyFiscalDateCalculator can calculate the calendar date.
     */
    @Test
    public void shouldCalculateCalendarDateInEarlyFiscalYear() {
        // given
        final FiscalDateCalculator earlyCalculator = new EarlyFiscalDateCalculator(11);
        final int fiscalYear = 2013;
        final int fiscalMonth = 1;
        final int fiscalDay = 1;

        // when
        final LocalDate calendarDate = earlyCalculator.calculateCalendarDate(fiscalYear, fiscalMonth, fiscalDay);

        // then
        Assert.assertEquals(2012, calendarDate.getYear());
        Assert.assertEquals(11, calendarDate.getMonthValue());
        Assert.assertEquals(1, calendarDate.getDayOfMonth());
    }

    /**
     * Ensures that the LateFiscalDateCalculator can calculate the calendar date.
     */
    @Test
    public void shouldCalculateCalendarDateInLateFiscalYear() {
        // given
        final FiscalDateCalculator earlyCalculator = new LateFiscalDateCalculator(3);
        final int fiscalYear = 2013;
        final int fiscalMonth = 1;
        final int fiscalDay = 1;

        // when
        final LocalDate calendarDate = earlyCalculator.calculateCalendarDate(fiscalYear, fiscalMonth, fiscalDay);

        // then
        Assert.assertEquals(2013, calendarDate.getYear());
        Assert.assertEquals(3, calendarDate.getMonthValue());
        Assert.assertEquals(1, calendarDate.getDayOfMonth());
    }

}
