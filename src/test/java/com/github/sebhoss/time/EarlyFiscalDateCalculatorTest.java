/*
 * This file is part of fiscal-year. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of fiscal-year,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package com.github.sebhoss.time;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 *
 */
public class EarlyFiscalDateCalculatorTest {

    /**
     */
    @SuppressWarnings("static-method")
    @Test
    public void shouldRemainWithinCurrentYear() {
        final EarlyFiscalDateCalculator calculator = new EarlyFiscalDateCalculator(2);

        final int calendarYear = calculator.calculateCalendarYear(2035, 12);

        Assert.assertEquals(2035, calendarYear);
    }

    /**
     */
    @SuppressWarnings("static-method")
    @Test
    public void shouldBeInPastCalendarYear() {
        final EarlyFiscalDateCalculator calculator = new EarlyFiscalDateCalculator(2);

        final int calendarYear = calculator.calculateCalendarYear(2035, 11);

        Assert.assertEquals(2034, calendarYear);
    }

}