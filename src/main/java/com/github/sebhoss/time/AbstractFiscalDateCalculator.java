/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.time;

import org.joda.time.LocalDate;

abstract class AbstractFiscalDateCalculator implements FiscalDateCalculator {

    protected final int fiscalYearStartMonth;

    AbstractFiscalDateCalculator(final int fiscalStartMonth) {
        fiscalYearStartMonth = fiscalStartMonth;
    }

    @Override
    public final int calculateFiscalMonth(final LocalDate calendarDate) {
        final int calendarMonth = calendarDate.getMonthOfYear();
        final int maximumNumberOfMonths = calendarDate.monthOfYear().getMaximumValue();

        if (fiscalYearStartMonth <= calendarMonth) {
            return calendarMonth - fiscalYearStartMonth + 1;
        }

        return calendarMonth + maximumNumberOfMonths - fiscalYearStartMonth + 1;
    }

    @Override
    public final int calculateFiscalWeekOfYear(final LocalDate calendarDate) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public final int calculateFiscalDayOfYear(final LocalDate calendarDate) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public LocalDate calculateCalendarDate(final int fiscalYear, final int fiscalMonth, final int fiscalDay) {
        return new LocalDate();
    }

}
