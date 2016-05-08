/*
 * This file is part of fiscal-year. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of fiscal-year,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.utils.fiscal_year;

import org.junit.Assert;
import org.junit.Test;

import de.xn__ho_hia.utils.fiscal_year.LateFiscalDateCalculator;

/**
 *
 *
 */
public class LateFiscalDateCalculatorTest {

    /**
     */
    @SuppressWarnings("static-method")
    @Test
    public void shouldBeInNextCalendarYear() {
        final LateFiscalDateCalculator calculator = new LateFiscalDateCalculator(2);

        final int calendarYear = calculator.calculateCalendarYear(2035, 12);

        Assert.assertEquals(2036, calendarYear);
    }

    /**
     */
    @SuppressWarnings("static-method")
    @Test
    public void shouldBeInCurrentCalendarYear() {
        final LateFiscalDateCalculator calculator = new LateFiscalDateCalculator(2);

        final int calendarYear = calculator.calculateCalendarYear(2035, 11);

        Assert.assertEquals(2035, calendarYear);
    }

}
