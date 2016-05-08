/*
 * This file is part of fiscal-year. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of fiscal-year,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.utils.fiscal_year;

import java.time.LocalDate;

final class EarlyFiscalDateCalculator extends AbstractFiscalDateCalculator {

    EarlyFiscalDateCalculator(final int fiscalStartMonth) {
        super(fiscalStartMonth);
    }

    @Override
    public long calculateFiscalYear(final LocalDate calendarDate) {
        final int offset = fiscalYearStartMonth <= calendarDate.getMonthValue() ? 1 : 0;

        return calendarDate.getYear() + offset;
    }

    @Override
    protected int calculateCalendarYear(final int fiscalYear, final int fiscalMonth) {
        final int offset = fiscalMonth <= 12 - fiscalYearStartMonth + 1 ? -1 : 0;

        return fiscalYear + offset;
    }

}
