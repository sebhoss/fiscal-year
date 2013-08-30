/*
 * Copyright © 2013 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.time;

import org.joda.time.LocalDate;

import com.github.sebhoss.common.annotation.CompilerWarnings;

final class FiscalDateImplementation implements FiscalDate {

    private final FiscalDateCalculator fiscalDateCalculator;
    private final LocalDate            currentCalendarDate;

    FiscalDateImplementation(final FiscalDateCalculator fiscalDateCalculator, final LocalDate currentCalendarDate) {
        this.fiscalDateCalculator = fiscalDateCalculator;
        this.currentCalendarDate = currentCalendarDate;
    }

    @Override
    public int getFiscalYear() {
        return fiscalDateCalculator.calculateFiscalYear(currentCalendarDate);
    }

    @Override
    public int getFiscalMonth() {
        return fiscalDateCalculator.calculateFiscalMonth(currentCalendarDate);
    }

    @Override
    public int getFiscalDayOfYear() {
        return fiscalDateCalculator.calculateFiscalDayOfYear(currentCalendarDate);
    }

    @Override
    public int getFiscalWeekOfWeekyear() {
        return fiscalDateCalculator.calculateFiscalWeekOfYear(currentCalendarDate);
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
        return new FiscalDateImplementation(fiscalDateCalculator, newDate);
    }

    @Override
    public LocalDate asLocalDate() {
        return currentCalendarDate;
    }

}
