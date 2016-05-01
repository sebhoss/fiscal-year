/*
 * Copyright © 2013 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.time;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 *
 */
public class FiscalYearFactoryTest {

    /**
     *
     */
    @SuppressWarnings({ "static-method", "nls" })
    @Test
    public void shouldCreateFiscalYear() {
        // given
        final int fiscalYear = 2035;
        final int fiscalMonth = 1;
        final int fiscalDay = 1;

        // when
        final FiscalDate fiscalDate = FiscalYears.earlyFiscalYear(1).create(fiscalYear, fiscalMonth, fiscalDay);

        // then
        Assert.assertNotNull("Could not create fiscal date", fiscalDate);
    }

}
