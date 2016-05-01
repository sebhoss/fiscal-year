/*
 * Copyright © 2013 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
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
