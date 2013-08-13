/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.time;

import java.io.Serializable;
import java.util.Comparator;

import org.joda.time.Months;

/**
 * TODO: document
 */
final class FiscalYearStartsLate implements Comparator<Months>, Serializable {

    private static final long serialVersionUID = 524301361114072673L;

    @Override
    public int compare(final Months fiscalStartMonth, final Months currentMonth) {
        return fiscalStartMonth.compareTo(currentMonth) <= 0 ? 0 : -1;
    }

}
