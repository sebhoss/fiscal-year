/*
 * This file is part of fiscal-year. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of fiscal-year,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.utils.fiscal_year;

import java.time.LocalDate;

/**
 * Represents a single date within a fiscal year.
 */
public interface FiscalDate {

    /**
     * @return The current fiscal year.
     */
    long getFiscalYear();

    /**
     * @return The current month in the current fiscal year.
     */
    long getFiscalMonth();

    /**
     * @return The current day in the current fiscal year.
     */
    long getFiscalDayOfYear();

    /**
     * @return The current week in the current fiscal year.
     */
    long getFiscalWeekOfWeekyear();

    /**
     * @return The current fiscal year as calendar year.
     */
    long getCalendarYear();

    /**
     * @return The current month in the current fiscal year as calendar month in a calendar year.
     */
    long getCalendarMonth();

    /**
     * @return The current day in the current month in the current fiscal year as calendar day in a calendar month in a
     *         calendar year.
     */
    long getCalendarDayOfMonth();

    /**
     * @return The current day in the current fiscal year as calendar day in a calendar year.
     */
    long getCalendarDayOfYear();

    /**
     * @return The current week in the current fiscal year as calendar week in a calendar year.
     */
    long getCalendarWeekOfWeekyear();

    /**
     * @param years
     *            The years to add to this fiscal date.
     * @return A new fiscal date representing this fiscal date plus the given years.
     */
    FiscalDate plusYears(long years);

    /**
     * @param months
     *            The months to add to this fiscal date.
     * @return A new fiscal date representing this fiscal date plus the given months.
     */
    FiscalDate plusMonths(long months);

    /**
     * @param weeks
     *            The weeks to add to this fiscal date.
     * @return A new fiscal date representing this fiscal date plus the given weeks;
     */
    FiscalDate plusWeeks(long weeks);

    /**
     * @param days
     *            The days to add to this fiscal date.
     * @return A new fiscal date representing this fiscal date plus the given days.
     */
    FiscalDate plusDays(long days);

    /**
     * @param years
     *            The years to subtract from this fiscal date.
     * @return A new fiscal date representing this fiscal date minus the given years.
     */
    FiscalDate minusYears(long years);

    /**
     * @param months
     *            The months to subtract from this fiscal date.
     * @return A new fiscal date representing this fiscal date minus the given months.
     */
    FiscalDate minusMonths(long months);

    /**
     * @param weeks
     *            The weeks to subtract from this fiscal date.
     * @return A new fiscal date representing this fiscal date minus the given weeks;
     */
    FiscalDate minusWeeks(long weeks);

    /**
     * @param days
     *            The days to subtract from this fiscal date.
     * @return A new fiscal date representing this fiscal date minus the given days.
     */
    FiscalDate minusDays(long days);

    /**
     * @return This fiscal date as a calendar date.
     */
    LocalDate asLocalDate();

}
