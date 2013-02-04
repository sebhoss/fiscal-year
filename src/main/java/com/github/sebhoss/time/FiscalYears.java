/* This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://www.wtfpl.net/ for more details. */
package com.github.sebhoss.time;

import org.joda.time.Months;

import com.github.sebhoss.common.annotation.CompilerWarnings;

/**
 * TODO: document
 */
public final class FiscalYears {

    /**
     * @param startMonth
     *            The calendar month in the previous calendar year where the fiscal year begins.
     * @return A new factory which creates appropriate {@link FiscalDate}s.
     */
    @SuppressWarnings(CompilerWarnings.NULL)
    public static FiscalYearFactory earlyFiscalYear(final int startMonth) {
        return FiscalYears.earlyFiscalYear(Months.months(startMonth));
    }

    /**
     * @param startMonth
     *            The calendar month in the previous calendar year where the fiscal year begins.
     * @return A new factory which creates appropriate {@link FiscalDate}s.
     */
    public static FiscalYearFactory earlyFiscalYear(final Months startMonth) {
        return new FiscalYearFactory(startMonth, new FiscalYearStartsEarly());
    }

    /**
     * @param startMonth
     *            The calendar month in the current calendar year where the fiscal year begins.
     * @return A new factory which creates appropriate {@link FiscalDate}s.
     */
    @SuppressWarnings(CompilerWarnings.NULL)
    public static FiscalYearFactory lateFiscalYear(final int startMonth) {
        return FiscalYears.lateFiscalYear(Months.months(startMonth));
    }

    /**
     * @param startMonth
     *            The calendar month in the current calendar year where the fiscal year begins.
     * @return A new factory which creates appropriate {@link FiscalDate}s.
     */
    public static FiscalYearFactory lateFiscalYear(final Months startMonth) {
        return new FiscalYearFactory(startMonth, new FiscalYearStartsLate());
    }

    private FiscalYears() {
        // Factory class
    }

}
