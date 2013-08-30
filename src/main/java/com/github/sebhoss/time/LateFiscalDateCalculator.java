/*
 * Copyright © 2013 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.time;

import org.joda.time.LocalDate;

final class LateFiscalDateCalculator extends AbstractFiscalDateCalculator {

    LateFiscalDateCalculator(final int fiscalStartMonth) {
        super(fiscalStartMonth);
    }

    @Override
    public int calculateFiscalYear(final LocalDate calendarDate) {
        if (fiscalYearStartMonth <= calendarDate.getMonthOfYear()) {
            return calendarDate.getYear();
        }

        return calendarDate.getYear() - 1;
    }

    @Override
    protected int calculateCalendarYear(final int fiscalYear, final int fiscalMonth) {
        if (fiscalMonth <= 12 - fiscalYearStartMonth + 1) {
            return fiscalYear;
        }

        return fiscalYear + 1;
    }

}
