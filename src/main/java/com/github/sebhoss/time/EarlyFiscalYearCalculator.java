/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.time;

import org.joda.time.LocalDate;

final class EarlyFiscalYearCalculator implements FiscalYearCalculator {

    private final int fiscalYearStartMonth;

    EarlyFiscalYearCalculator(final int fiscalYearStartMonth) {
        this.fiscalYearStartMonth = fiscalYearStartMonth;
    }

    @Override
    public int calculateFiscalYear(final LocalDate calendarDate) {
        if (fiscalYearStartMonth <= calendarDate.getMonthOfYear()) {
            return calendarDate.getYear() + 1;
        }

        return calendarDate.getYear();
    }

}
