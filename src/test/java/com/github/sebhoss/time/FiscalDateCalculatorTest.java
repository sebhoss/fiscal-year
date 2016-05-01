/*
 * This file is part of fiscal-year. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of fiscal-year,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
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
