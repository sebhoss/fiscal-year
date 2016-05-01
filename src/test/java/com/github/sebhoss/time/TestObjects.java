/*
 * Copyright © 2013 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.time;

import java.time.LocalDate;
import java.time.Month;

/**
 * Collection of common test objects.
 */
public final class TestObjects {

    /**
     * @return An array of all supported months.
     */
    public static Month[] supportedMonths() {
        return Month.values();
    }

    /**
     * @return An array of start dates of months in the year 2015.
     */
    public static LocalDate[] startDates() {
        return startDates(2015);
    }

    /**
     * @param year
     *            The year to use.
     * @return An array of start dates of months in the given year.
     */
    public static LocalDate[] startDates(final int year) {
        return currentDates(year, 1);
    }

    /**
     * @return An array of middle dates of months in the year 2015.
     */
    public static LocalDate[] middleDates() {
        return middleDates(2015);
    }

    /**
     * @param year
     *            The year to use.
     * @return An array of middle dates of months in the given year.
     */
    public static LocalDate[] middleDates(final int year) {
        return currentDates(year, 15);
    }

    /**
     * @param year
     *            The year to use.
     * @param dayOfMonth
     *            The day of month to use.
     * @return An array of dates in the given year on the given day.
     */
    public static LocalDate[] currentDates(final int year, final int dayOfMonth) {
        return new LocalDate[] { LocalDate.of(year, 1, dayOfMonth), LocalDate.of(year, 2, dayOfMonth),
                LocalDate.of(year, 3, dayOfMonth), LocalDate.of(year, 4, dayOfMonth),
                LocalDate.of(year, 5, dayOfMonth), LocalDate.of(year, 6, dayOfMonth),
                LocalDate.of(year, 7, dayOfMonth), LocalDate.of(year, 8, dayOfMonth),
                LocalDate.of(year, 9, dayOfMonth), LocalDate.of(year, 10, dayOfMonth),
                LocalDate.of(year, 11, dayOfMonth), LocalDate.of(year, 12, dayOfMonth) };
    }

    private TestObjects() {
        // Factory class
    }

}
