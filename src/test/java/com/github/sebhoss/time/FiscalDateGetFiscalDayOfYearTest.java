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

import java.time.LocalDate;

import com.github.sebhoss.warnings.CompilerWarnings;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for {@link FiscalDate#getFiscalDayOfYear()}.
 */
@SuppressWarnings(CompilerWarnings.STATIC_METHOD)
public class FiscalDateGetFiscalDayOfYearTest {

    /**
     * Ensures that the first day of a fiscal-year has the index number 1.
     */
    @Test
    public void shouldReturnFirstDayAtStartOfFiscalYear() {
        // given
        final FiscalYearFactory fiscalYearFactory = FiscalYears.earlyFiscalYear(11);
        final FiscalDate fiscalDate = fiscalYearFactory.createFromCalendarDate(LocalDate.of(2015, 11, 1));

        // when
        final long dayOfYear = fiscalDate.getFiscalDayOfYear();

        // then
        Assert.assertEquals(1, dayOfYear);
    }

    /**
     * Ensures that the last day of a fiscal-year has the index number 365.
     */
    @Test
    public void shouldReturnLastDayAtStartOfFiscalYear() {
        // given
        final FiscalYearFactory fiscalYearFactory = FiscalYears.earlyFiscalYear(11);
        final FiscalDate fiscalDate = fiscalYearFactory.createFromCalendarDate(LocalDate.of(2015, 10, 31));

        // when
        final long dayOfYear = fiscalDate.getFiscalDayOfYear();

        // then
        Assert.assertEquals(365, dayOfYear);
    }

}
