/*
 * Copyright © 2013 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.time;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

abstract class AbstractFiscalDateCalculator implements FiscalDateCalculator {

    protected final int fiscalYearStartMonth;

    protected AbstractFiscalDateCalculator(final int fiscalStartMonth) {
        fiscalYearStartMonth = fiscalStartMonth;
    }

    @Override
    public final long calculateFiscalMonth(final LocalDate calendarDate) {
        final int calendarMonth = calendarDate.getMonthValue();
        final int maximumNumberOfMonths = Month.values().length;

        if (fiscalYearStartMonth <= calendarMonth) {
            return calendarMonth - fiscalYearStartMonth + 1;
        }

        return calendarMonth + maximumNumberOfMonths - fiscalYearStartMonth + 1;
    }

    @Override
    public final long calculateFiscalWeekOfYear(final LocalDate calendarDate) {
        final LocalDate fiscalYearStartDate = createMatchingFiscalYearStartDate(calendarDate);

        return ChronoUnit.WEEKS.between(fiscalYearStartDate, calendarDate) + 1;
    }

    @Override
    public final long calculateFiscalDayOfYear(final LocalDate calendarDate) {
        final LocalDate fiscalYearStartDate = createMatchingFiscalYearStartDate(calendarDate);

        return ChronoUnit.DAYS.between(fiscalYearStartDate, calendarDate) + 1;
    }

    private LocalDate createMatchingFiscalYearStartDate(final LocalDate calendarDate) {
        if (fiscalYearStartMonth <= calendarDate.getMonthValue()) {
            return LocalDate.of(calendarDate.getYear(), fiscalYearStartMonth, 1);
        }

        return LocalDate.of(calendarDate.getYear() - 1, fiscalYearStartMonth, 1);
    }

    @Override
    public LocalDate calculateCalendarDate(final int fiscalYear, final int fiscalMonth, final int fiscalDay) {
        final int calendarYear = calculateCalendarYear(fiscalYear, fiscalMonth);
        final int calendarMonth = calculateCalendarMonth(fiscalMonth);

        return LocalDate.of(calendarYear, calendarMonth, fiscalDay);
    }

    private final int calculateCalendarMonth(final int fiscalMonth) {
        return (fiscalMonth + fiscalYearStartMonth - 1) % 12;
    }

    protected abstract int calculateCalendarYear(int fiscalYear, int fiscalMonth);

}
