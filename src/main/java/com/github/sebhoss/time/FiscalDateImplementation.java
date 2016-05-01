/*
 * Copyright © 2013 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.time;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

import javax.annotation.Nullable;

import com.github.sebhoss.nullanalysis.Nullsafe;

final class FiscalDateImplementation implements FiscalDate {

    private final FiscalDateCalculator fiscalDateCalculator;
    private final LocalDate            currentCalendarDate;

    FiscalDateImplementation(final FiscalDateCalculator fiscalDateCalculator, final LocalDate currentCalendarDate) {
        this.fiscalDateCalculator = fiscalDateCalculator;
        this.currentCalendarDate = currentCalendarDate;
    }

    @Override
    public long getFiscalYear() {
        return fiscalDateCalculator.calculateFiscalYear(currentCalendarDate);
    }

    @Override
    public long getFiscalMonth() {
        return fiscalDateCalculator.calculateFiscalMonth(currentCalendarDate);
    }

    @Override
    public long getFiscalDayOfYear() {
        return fiscalDateCalculator.calculateFiscalDayOfYear(currentCalendarDate);
    }

    @Override
    public long getFiscalWeekOfWeekyear() {
        return fiscalDateCalculator.calculateFiscalWeekOfYear(currentCalendarDate);
    }

    @Override
    public long getCalendarYear() {
        return currentCalendarDate.getYear();
    }

    @Override
    public long getCalendarMonth() {
        return currentCalendarDate.getMonthValue();
    }

    @Override
    public long getCalendarDayOfMonth() {
        return currentCalendarDate.getDayOfMonth();
    }

    @Override
    public long getCalendarDayOfYear() {
        return currentCalendarDate.getDayOfYear();
    }

    @Override
    public long getCalendarWeekOfWeekyear() {
        return currentCalendarDate.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
    }

    @Override
    public FiscalDate plusYears(final long years) {
        return copyWithNewDate(currentCalendarDate.plusYears(years));
    }

    @Override
    public FiscalDate plusMonths(final long months) {
        return copyWithNewDate(currentCalendarDate.plusMonths(months));
    }

    @Override
    public FiscalDate plusWeeks(final long weeks) {
        return copyWithNewDate(currentCalendarDate.plusWeeks(weeks));
    }

    @Override
    public FiscalDate plusDays(final long days) {
        return copyWithNewDate(currentCalendarDate.plusDays(days));
    }

    @Override
    public FiscalDate minusYears(final long years) {
        return copyWithNewDate(currentCalendarDate.minusYears(years));
    }

    @Override
    public FiscalDate minusMonths(final long months) {
        return copyWithNewDate(currentCalendarDate.minusMonths(months));
    }

    @Override
    public FiscalDate minusWeeks(final long weeks) {
        return copyWithNewDate(currentCalendarDate.minusWeeks(weeks));
    }

    @Override
    public FiscalDate minusDays(final long days) {
        return copyWithNewDate(currentCalendarDate.minusDays(days));
    }

    private FiscalDateImplementation copyWithNewDate(final @Nullable LocalDate newDate) {
        return new FiscalDateImplementation(fiscalDateCalculator, Nullsafe.nullsafe(newDate));
    }

    @Override
    public LocalDate asLocalDate() {
        return currentCalendarDate;
    }

}
