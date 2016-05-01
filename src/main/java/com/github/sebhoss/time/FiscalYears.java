/*
 * This file is part of fiscal-year. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of fiscal-year,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package com.github.sebhoss.time;

import java.time.Month;

/**
 * Factory for {@link FiscalYearFactory}s.
 */
public final class FiscalYears {

    /**
     * @param startMonth
     *            The calendar month in the previous calendar year where the fiscal year begins.
     * @return A new factory which creates appropriate {@link FiscalDate}s.
     */
    public static FiscalYearFactory earlyFiscalYear(final Month startMonth) {
        return earlyFiscalYear(startMonth.getValue());
    }

    /**
     * @param startMonth
     *            The calendar month in the previous calendar year where the fiscal year begins.
     * @return A new factory which creates appropriate {@link FiscalDate}s.
     */
    public static FiscalYearFactory earlyFiscalYear(final int startMonth) {
        return new FiscalYearFactory(new EarlyFiscalDateCalculator(startMonth));
    }

    /**
     * @param startMonth
     *            The calendar month in the current calendar year where the fiscal year begins.
     * @return A new factory which creates appropriate {@link FiscalDate}s.
     */
    public static FiscalYearFactory lateFiscalYear(final Month startMonth) {
        return lateFiscalYear(startMonth.getValue());
    }

    /**
     * @param startMonth
     *            The calendar month in the current calendar year where the fiscal year begins.
     * @return A new factory which creates appropriate {@link FiscalDate}s.
     */
    public static FiscalYearFactory lateFiscalYear(final int startMonth) {
        return new FiscalYearFactory(new LateFiscalDateCalculator(startMonth));
    }

    private FiscalYears() {
        // Factory class
    }

}
