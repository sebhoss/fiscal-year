/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.time;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.Weeks;

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
        final LocalDate fiscalYearStartDate = createMatchingFiscalYearStartDate(calendarDate);

        return Weeks.weeksBetween(fiscalYearStartDate, calendarDate).getWeeks() + 1;
    }

    @Override
    public final int calculateFiscalDayOfYear(final LocalDate calendarDate) {
        final LocalDate fiscalYearStartDate = createMatchingFiscalYearStartDate(calendarDate);

        return Days.daysBetween(fiscalYearStartDate, calendarDate).getDays() + 1;
    }

    private LocalDate createMatchingFiscalYearStartDate(final LocalDate calendarDate) {
        if (fiscalYearStartMonth <= calendarDate.getMonthOfYear()) {
            return new LocalDate(calendarDate.getYear(), fiscalYearStartMonth, 1);
        }

        return new LocalDate(calendarDate.getYear() - 1, fiscalYearStartMonth, 1);
    }

    @Override
    public LocalDate calculateCalendarDate(final int fiscalYear, final int fiscalMonth, final int fiscalDay) {
        final int calendarYear = calculateCalendarYear(fiscalYear, fiscalMonth);
        final int calendarMonth = calculateCalendarMonth(fiscalMonth);

        return new LocalDate(calendarYear, calendarMonth, fiscalDay);
    }

    private final int calculateCalendarMonth(final int fiscalMonth) {
        return (fiscalMonth + fiscalYearStartMonth - 1) % 12;
    }

    protected abstract int calculateCalendarYear(int fiscalYear, int fiscalMonth);

}
