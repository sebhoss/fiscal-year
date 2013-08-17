/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.time;

import org.joda.time.LocalDate;
import org.joda.time.Months;

/**
 * Creates {@link FiscalDate fiscal dates} from {@link LocalDate local dates}. Thus converts between calendar years to
 * fiscal years.
 */
public final class FiscalYearFactory {

    private final Months               fiscalYearStartMonth;
    private final FiscalYearCalculator fiscalYearCalculator;

    FiscalYearFactory(final Months fiscalYearStartMonth, final FiscalYearCalculator fiscalYearCalculator) {
        this.fiscalYearStartMonth = fiscalYearStartMonth;
        this.fiscalYearCalculator = fiscalYearCalculator;
    }

    /**
     * @param calendarDate
     *            The date in a calendar year.
     * @return The corresponding date in a fiscal year.
     */
    public FiscalDate create(final LocalDate calendarDate) {
        return new FiscalDateImplementation(fiscalYearStartMonth, fiscalYearCalculator, calendarDate);
    }

}
