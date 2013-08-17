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

    private final FiscalYearCalculator       fiscalYearCalculator;
    private final FiscalMonthCalculator      fiscalMonthCalculator;
    private final FiscalDayOfYearCalculator  fiscalDayOfYearCalculator;
    private final FiscalWeekOfYearCalculator fiscalWeekOfYearCalculator;

    FiscalYearFactory(final FiscalYearCalculator fiscalYearCalculator,
            final FiscalMonthCalculator fiscalMonthCalculator,
            final FiscalDayOfYearCalculator fiscalDayOfYearCalculator,
            final FiscalWeekOfYearCalculator fiscalWeekOfYearCalculator) {
        this.fiscalYearCalculator = fiscalYearCalculator;
        this.fiscalMonthCalculator = fiscalMonthCalculator;
        this.fiscalDayOfYearCalculator = fiscalDayOfYearCalculator;
        this.fiscalWeekOfYearCalculator = fiscalWeekOfYearCalculator;
    }

    /**
     * @param calendarDate
     *            The date in a calendar year.
     * @return The corresponding date in a fiscal year.
     */
    public FiscalDate create(final LocalDate calendarDate) {
        return new FiscalDateImplementation(fiscalYearCalculator, fiscalMonthCalculator, fiscalDayOfYearCalculator,
                fiscalWeekOfYearCalculator, calendarDate);
    }

}
