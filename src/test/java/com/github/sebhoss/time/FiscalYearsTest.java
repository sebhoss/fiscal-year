/*
 * This file is part of fiscal-year. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of fiscal-year,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package com.github.sebhoss.time;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 *
 */
public class FiscalYearsTest {

    /**
     * Ensures that the constructor of the {@link FiscalYears} class is private.
     * <p>
     * The class should never be instantiated.
     *
     * @throws NoSuchMethodException
     *             Should not fail in case the StorageUnits class has a constructor..
     * @throws IllegalAccessException
     *             Should not fail in case the StorageUnits class has a constructor..
     * @throws InvocationTargetException
     *             Should not fail in case the StorageUnits class has a constructor..
     * @throws InstantiationException
     *             Should not fail in case the StorageUnits class has a constructor..
     */
    @SuppressWarnings("static-method")
    @Test
    public void shouldDeclarePrivateConstructor()
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // Given
        final Constructor<FiscalYears> constructor = FiscalYears.class.getDeclaredConstructor();

        // When
        final boolean isPrivate = Modifier.isPrivate(constructor.getModifiers());

        // Then
        Assert.assertTrue("Constructor is not private", isPrivate); //$NON-NLS-1$
        constructor.setAccessible(true);
        constructor.newInstance();
    }

}
