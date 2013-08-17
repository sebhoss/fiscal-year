/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.time;

import org.joda.time.LocalDate;
import org.joda.time.Months;

/**
 * Collection of common test objects.
 */
public final class TestObjects {

    /**
     * @return An array of all supported months.
     */
    public static Months[] supportedMonths() {
        return new Months[] { Months.TWO, Months.THREE, Months.FOUR, Months.FIVE, Months.SIX, Months.SEVEN,
                Months.EIGHT, Months.NINE, Months.TEN, Months.ELEVEN, Months.TWELVE };
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
        return new LocalDate[] { new LocalDate(year, 1, dayOfMonth), new LocalDate(year, 2, dayOfMonth),
                new LocalDate(year, 3, dayOfMonth), new LocalDate(year, 4, dayOfMonth),
                new LocalDate(year, 5, dayOfMonth), new LocalDate(year, 6, dayOfMonth),
                new LocalDate(year, 7, dayOfMonth), new LocalDate(year, 8, dayOfMonth),
                new LocalDate(year, 9, dayOfMonth), new LocalDate(year, 10, dayOfMonth),
                new LocalDate(year, 11, dayOfMonth), new LocalDate(year, 12, dayOfMonth) };
    }

    private TestObjects() {
        // Factory class
    }

}
