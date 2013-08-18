/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.time;

import org.joda.time.LocalDate;

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
