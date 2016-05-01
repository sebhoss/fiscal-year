/*
 * Copyright © 2013 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.time;

import org.junit.Assert;
import org.junit.Test;

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
