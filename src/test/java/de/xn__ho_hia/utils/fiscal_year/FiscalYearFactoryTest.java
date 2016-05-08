/*
 * This file is part of fiscal-year. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of fiscal-year,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.utils.fiscal_year;

import org.junit.Assert;
import org.junit.Test;

import de.xn__ho_hia.utils.fiscal_year.FiscalDate;
import de.xn__ho_hia.utils.fiscal_year.FiscalYears;

/**
 *
 *
 */
public class FiscalYearFactoryTest {

    /**
     *
     */
    @SuppressWarnings({ "static-method", "nls" })
    @Test
    public void shouldCreateFiscalYear() {
        // given
        final int fiscalYear = 2035;
        final int fiscalMonth = 1;
        final int fiscalDay = 1;

        // when
        final FiscalDate fiscalDate = FiscalYears.earlyFiscalYear(1).create(fiscalYear, fiscalMonth, fiscalDay);

        // then
        Assert.assertNotNull("Could not create fiscal date", fiscalDate);
    }

}
