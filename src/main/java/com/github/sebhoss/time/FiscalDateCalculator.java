/*
 * Copyright © 2013 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.time;

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
    long calculateFiscalYear(LocalDate calendarDate);

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
