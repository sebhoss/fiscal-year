/*
 * This file is part of fiscal-year. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of fiscal-year,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.utils.fiscal_year;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import de.xn__ho_hia.quality.suppression.CompilerWarnings;

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
