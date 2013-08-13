/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.time;

import java.util.Comparator;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.Months;
import org.joda.time.Weeks;

import com.github.sebhoss.common.annotation.CompilerWarnings;

/**
 * TODO: document
 */
final class FiscalDateImplementation implements FiscalDate {

    private final Months             fiscalYearStartMonth;
    private final Comparator<Months> monthComparatorForFiscalYearCalculation;
    private final LocalDate          currentCalendarDate;

    /**
     * @param fiscalYearStartMonth
     *            The start date of the fiscal year.
     * @param monthComparatorForFiscalYearCalculation
     *            The comparator to use for month comparison when asking for the fiscal year.
     * @param currentCalendarDate
     *            The current calendar date.
     */
    FiscalDateImplementation(final Months fiscalYearStartMonth,
            final Comparator<Months> monthComparatorForFiscalYearCalculation, final LocalDate currentCalendarDate) {
        this.fiscalYearStartMonth = fiscalYearStartMonth;
        this.monthComparatorForFiscalYearCalculation = monthComparatorForFiscalYearCalculation;
        this.currentCalendarDate = currentCalendarDate;
    }

    @Override
    public int getFiscalYear() {
        final int calendarYear = currentCalendarDate.getYear();
        final int calendarMonth = currentCalendarDate.getMonthOfYear();
        final Months currentCalendarMonth = Months.months(calendarMonth);
        final int yearOffset = monthComparatorForFiscalYearCalculation.compare(fiscalYearStartMonth,
                currentCalendarMonth);

        return calendarYear + yearOffset;
    }

    @Override
    public int getFiscalMonth() {
        final int calendarMonth = currentCalendarDate.getMonthOfYear();
        final int fiscalStartMonth = fiscalYearStartMonth.getMonths();
        int month = 0;

        if (fiscalStartMonth <= calendarMonth) {
            month = calendarMonth - fiscalStartMonth + 1;
        } else {
            final int maximumNumberOfMonths = currentCalendarDate.monthOfYear().getMaximumValue();
            final int fiscalMonthOffset = maximumNumberOfMonths - fiscalStartMonth + 1;
            month = calendarMonth + fiscalMonthOffset;
        }

        return month;
    }

    @Override
    public int getFiscalDayOfYear() {
        final LocalDate fiscalYearStartDate = new LocalDate(getFiscalYear(), fiscalYearStartMonth.getMonths(), 1);
        final Days daysBetween = Days.daysBetween(fiscalYearStartDate, currentCalendarDate);

        return daysBetween.getDays();
    }

    @Override
    public int getFiscalWeekOfYear() {
        final LocalDate fiscalYearStartDate = new LocalDate(getFiscalYear(), fiscalYearStartMonth.getMonths(), 1);
        final Weeks weeksBetween = Weeks.weeksBetween(fiscalYearStartDate, currentCalendarDate);

        return weeksBetween.getWeeks();
    }

    @Override
    public int getCalendarYear() {
        return currentCalendarDate.getYear();
    }

    @Override
    public int getCalendarMonth() {
        return currentCalendarDate.getMonthOfYear();
    }

    @Override
    public int getCalendarDayOfMonth() {
        return currentCalendarDate.getDayOfMonth();
    }

    @Override
    public int getCalendarDayOfYear() {
        return currentCalendarDate.getDayOfYear();
    }

    @Override
    public int getCalendarWeekOfWeekyear() {
        return currentCalendarDate.getWeekOfWeekyear();
    }

    @Override
    @SuppressWarnings(CompilerWarnings.NULL)
    public FiscalDate plusYears(final int years) {
        return copyWithNewDate(currentCalendarDate.plusYears(years));
    }

    @Override
    @SuppressWarnings(CompilerWarnings.NULL)
    public FiscalDate plusMonths(final int months) {
        return copyWithNewDate(currentCalendarDate.plusMonths(months));
    }

    @Override
    @SuppressWarnings(CompilerWarnings.NULL)
    public FiscalDate plusWeeks(final int weeks) {
        return copyWithNewDate(currentCalendarDate.plusWeeks(weeks));
    }

    @Override
    @SuppressWarnings(CompilerWarnings.NULL)
    public FiscalDate plusDays(final int days) {
        return copyWithNewDate(currentCalendarDate.plusDays(days));
    }

    @Override
    @SuppressWarnings(CompilerWarnings.NULL)
    public FiscalDate minusYears(final int years) {
        return copyWithNewDate(currentCalendarDate.minusYears(years));
    }

    @Override
    @SuppressWarnings(CompilerWarnings.NULL)
    public FiscalDate minusMonths(final int months) {
        return copyWithNewDate(currentCalendarDate.minusMonths(months));
    }

    @Override
    @SuppressWarnings(CompilerWarnings.NULL)
    public FiscalDate minusWeeks(final int weeks) {
        return copyWithNewDate(currentCalendarDate.minusWeeks(weeks));
    }

    @Override
    @SuppressWarnings(CompilerWarnings.NULL)
    public FiscalDate minusDays(final int days) {
        return copyWithNewDate(currentCalendarDate.minusDays(days));
    }

    private FiscalDateImplementation copyWithNewDate(final LocalDate newDate) {
        return new FiscalDateImplementation(fiscalYearStartMonth, monthComparatorForFiscalYearCalculation, newDate);
    }

    @Override
    public LocalDate asLocalDate() {
        return currentCalendarDate;
    }

}
