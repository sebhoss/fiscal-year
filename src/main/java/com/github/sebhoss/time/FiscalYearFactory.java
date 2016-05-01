/*
 * This file is part of fiscal-year. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of fiscal-year,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package com.github.sebhoss.time;

import java.time.LocalDate;

/**
 * Creates {@link FiscalDate fiscal dates} from {@link LocalDate local dates}. Thus converts between calendar years to
 * fiscal years.
 */
public final class FiscalYearFactory {

    private final FiscalDateCalculator fiscalDateCalculator;

    FiscalYearFactory(final FiscalDateCalculator fiscalDateCalculator) {
        this.fiscalDateCalculator = fiscalDateCalculator;
    }

    /**
     * @param calendarDate
     *            The date in a calendar year.
     * @return The corresponding date in a fiscal year.
     */
    public FiscalDate createFromCalendarDate(final LocalDate calendarDate) {
        return new FiscalDateImplementation(fiscalDateCalculator, calendarDate);
    }

    /**
     * @param fiscalYear
     *            The fiscal year.
     * @param fiscalMonth
     *            The fiscal month.
     * @param fiscalDay
     *            The fiscal day.
     * @return A new FiscalDate representing the given parameters.
     */
    public FiscalDate create(final int fiscalYear, final int fiscalMonth, final int fiscalDay) {
        final LocalDate calendarDate = fiscalDateCalculator.calculateCalendarDate(fiscalYear, fiscalMonth, fiscalDay);

        return new FiscalDateImplementation(fiscalDateCalculator, calendarDate);
    }

}
