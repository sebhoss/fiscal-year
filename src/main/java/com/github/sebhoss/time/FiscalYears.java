/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.time;

import org.joda.time.Months;

/**
 * TODO: document
 */
public final class FiscalYears {

    /**
     * @param startMonth
     *            The calendar month in the previous calendar year where the fiscal year begins.
     * @return A new factory which creates appropriate {@link FiscalDate}s.
     */
    public static FiscalYearFactory earlyFiscalYear(final Months startMonth) {
        return earlyFiscalYear(startMonth.getMonths());
    }

    /**
     * @param startMonth
     *            The calendar month in the previous calendar year where the fiscal year begins.
     * @return A new factory which creates appropriate {@link FiscalDate}s.
     */
    public static FiscalYearFactory earlyFiscalYear(final int startMonth) {
        return new FiscalYearFactory(new EarlyFiscalYearCalculator(startMonth),
                new FiscalMonthCalculatorImplementation(startMonth), new FiscalDayOfYearCalculatorImplementation(),
                new FiscalWeekOfYearCalculatorImplementation());
    }

    /**
     * @param startMonth
     *            The calendar month in the current calendar year where the fiscal year begins.
     * @return A new factory which creates appropriate {@link FiscalDate}s.
     */
    public static FiscalYearFactory lateFiscalYear(final Months startMonth) {
        return lateFiscalYear(startMonth.getMonths());
    }

    /**
     * @param startMonth
     *            The calendar month in the current calendar year where the fiscal year begins.
     * @return A new factory which creates appropriate {@link FiscalDate}s.
     */
    public static FiscalYearFactory lateFiscalYear(final int startMonth) {
        return new FiscalYearFactory(new LateFiscalYearCalculator(startMonth), new FiscalMonthCalculatorImplementation(
                startMonth), new FiscalDayOfYearCalculatorImplementation(),
                new FiscalWeekOfYearCalculatorImplementation());
    }

    private FiscalYears() {
        // Factory class
    }

}
