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
 * TODO: Write documentation
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
    int calculateFiscalMonth(LocalDate calendarDate);

    /**
     * @param calendarDate
     *            The calendar date to transform.
     * @return The fiscal week-of-year of the given calendar date.
     */
    int calculateFiscalWeekOfYear(LocalDate calendarDate);

    /**
     * @param calendarDate
     *            The calendar date to transform.
     * @return The fiscal day-of-year of the given calendar date.
     */
    int calculateFiscalDayOfYear(LocalDate calendarDate);

}
