/*
 * This file is part of fiscal-year. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of fiscal-year,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
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
