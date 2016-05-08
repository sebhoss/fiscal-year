/*
 * This file is part of fiscal-year. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of fiscal-year,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.utils.fiscal_year;

import java.time.LocalDate;

import de.xn__ho_hia.utils.fiscal_year.FiscalDate;
import de.xn__ho_hia.utils.fiscal_year.FiscalYearFactory;
import de.xn__ho_hia.utils.fiscal_year.FiscalYears;
import de.xn__ho_hia.utils.jdt.CompilerWarnings;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for {@link FiscalDate#getFiscalWeekOfWeekyear()}.
 */
@SuppressWarnings(CompilerWarnings.STATIC_METHOD)
public class FiscalDateGetFiscalWeekOfWeekyearTest {

    /**
     * Ensures that the first week of a fiscal-year has the index number 1.
     */
    @Test
    public void shouldReturnFirstWeekAtStartOfFiscalYear() {
        // given
        final FiscalYearFactory fiscalYearFactory = FiscalYears.earlyFiscalYear(11);
        final FiscalDate fiscalDate = fiscalYearFactory.createFromCalendarDate(LocalDate.of(2015, 11, 1));

        // when
        final long weekOfWeekyear = fiscalDate.getFiscalWeekOfWeekyear();

        // then
        Assert.assertEquals(1, weekOfWeekyear);
    }

    /**
     * Ensures that the last week of a fiscal-year has the index number 52.
     */
    @Test
    public void shouldReturnLastWeekAtEndOfFiscalYear() {
        // given
        final FiscalYearFactory fiscalYearFactory = FiscalYears.earlyFiscalYear(11);
        final FiscalDate fiscalDate = fiscalYearFactory.createFromCalendarDate(LocalDate.of(2015, 10, 30));

        // when
        final long weekOfWeekyear = fiscalDate.getFiscalWeekOfWeekyear();

        // then
        Assert.assertEquals(52, weekOfWeekyear);
    }

}
