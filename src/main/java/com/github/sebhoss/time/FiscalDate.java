/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.time;

import org.joda.time.LocalDate;

/**
 * Represents a single date within a fiscal year.
 */
public interface FiscalDate {

    /**
     * @return The current fiscal year.
     */
    int getFiscalYear();

    /**
     * @return The current month in the current fiscal year.
     */
    int getFiscalMonth();

    /**
     * @return The current day in the current month in the current fiscal year.
     */
    int getFiscalDayOfMonth();

    /**
     * @return The current day in the current fiscal year.
     */
    int getFiscalDayOfYear();

    /**
     * @return The current week in the current fiscal year.
     */
    int getFiscalWeekOfYear();

    /**
     * @return The current fiscal year as calendar year.
     */
    int getCalendarYear();

    /**
     * @return The current month in the current fiscal year as calendar month in a calendar year.
     */
    int getCalendarMonth();

    /**
     * @return The current day in the current month in the current fiscal year as calendar day in a calendar month in a
     *         calendar year.
     */
    int getCalendarDayOfMonth();

    /**
     * @return The current day in the current fiscal year as calendar day in a calendar year.
     */
    int getCalendarDayOfYear();

    /**
     * @return The current week in the current fiscal year as calendar week in a calendar year.
     */
    int getCalendarWeekOfWeekyear();

    /**
     * @param years
     *            The years to add to this fiscal date.
     * @return A new fiscal date representing this fiscal date plus the given years.
     */
    FiscalDate plusYears(int years);

    /**
     * @param months
     *            The months to add to this fiscal date.
     * @return A new fiscal date representing this fiscal date plus the given months.
     */
    FiscalDate plusMonths(int months);

    /**
     * @param weeks
     *            The weeks to add to this fiscal date.
     * @return A new fiscal date representing this fiscal date plus the given weeks;
     */
    FiscalDate plusWeeks(int weeks);

    /**
     * @param days
     *            The days to add to this fiscal date.
     * @return A new fiscal date representing this fiscal date plus the given days.
     */
    FiscalDate plusDays(int days);

    /**
     * @param years
     *            The years to subtract from this fiscal date.
     * @return A new fiscal date representing this fiscal date minus the given years.
     */
    FiscalDate minusYears(int years);

    /**
     * @param months
     *            The months to subtract from this fiscal date.
     * @return A new fiscal date representing this fiscal date minus the given months.
     */
    FiscalDate minusMonths(int months);

    /**
     * @param weeks
     *            The weeks to subtract from this fiscal date.
     * @return A new fiscal date representing this fiscal date minus the given weeks;
     */
    FiscalDate minusWeeks(int weeks);

    /**
     * @param days
     *            The days to subtract from this fiscal date.
     * @return A new fiscal date representing this fiscal date minus the given days.
     */
    FiscalDate minusDays(int days);

    /**
     * @return This fiscal date as a calendar date.
     */
    LocalDate asLocalDate();

}
