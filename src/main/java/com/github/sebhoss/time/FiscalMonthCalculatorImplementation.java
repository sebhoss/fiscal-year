/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.time;

import org.joda.time.LocalDate;

final class FiscalMonthCalculatorImplementation implements FiscalMonthCalculator {

    private static final int MAXIMUM_NUMBER_OF_MONTHS = 12;

    private final int        fiscalStartMonth;

    FiscalMonthCalculatorImplementation(final int fiscalStartMonth) {
        this.fiscalStartMonth = fiscalStartMonth;
    }

    @Override
    public int calculateFiscalMonth(final LocalDate calendarDate) {
        final int calendarMonth = calendarDate.getMonthOfYear();

        if (fiscalStartMonth <= calendarMonth) {
            return calendarMonth - fiscalStartMonth + 1;
        }

        return calendarMonth + MAXIMUM_NUMBER_OF_MONTHS - fiscalStartMonth + 1;
    }

}
