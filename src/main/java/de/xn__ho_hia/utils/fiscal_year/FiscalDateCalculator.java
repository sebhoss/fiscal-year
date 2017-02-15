/*
 * This file is part of fiscal-year. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of fiscal-year,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.utils.fiscal_year;

import java.time.LocalDate;

/**
 * Performs calculations between fiscal- and calendar-years based dates.
 */
public interface FiscalDateCalculator {

    /**
     * @param calendarDate
     *            The calendar date to transform.
     * @return The fiscal year of the given calendar date.
     */
    int calculateFiscalYear(LocalDate calendarDate);

    /**
     * @param calendarDate
     *            The calendar date to transform.
     * @return The fiscal month of the given calendar date.
     */
    long calculateFiscalMonth(LocalDate calendarDate);

    /**
     * @param calendarDate
     *            The calendar date to transform.
     * @return The fiscal week-of-year of the given calendar date.
     */
    long calculateFiscalWeekOfYear(LocalDate calendarDate);

    /**
     * @param calendarDate
     *            The calendar date to transform.
     * @return The fiscal day-of-year of the given calendar date.
     */
    long calculateFiscalDayOfYear(LocalDate calendarDate);

    /**
     * @param fiscalYear
     *            The fiscal year.
     * @param fiscalMonth
     *            The fiscal month.
     * @param fiscalDay
     *            The fiscal day.
     * @return The corresponding calendar date.
     */
    LocalDate calculateCalendarDate(int fiscalYear, int fiscalMonth, int fiscalDay);

}
