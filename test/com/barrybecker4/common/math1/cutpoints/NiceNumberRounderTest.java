// Copyright by Barry G. Becker, 2012. Licensed under MIT License: http://www.opensource.org/licenses/MIT
package com.barrybecker4.common.math1.cutpoints;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Barry Becker
 */
public class NiceNumberRounderTest {


    private static final double BASE_VALUE = 101.34;

    private static final double TOLERANCE = 0.0;

    private static double[] EXPECTED_ROUNDED_VALUES = {
        100.0, 100.0, 200.0, 200.0, 200.0, 200.0, 200.0,
        500.0, 500.0, 500.0, 500.0, 500.0, 500.0, 500.0, 500.0, 500.0, 500.0, 500.0, 500.0, 500.0,
        1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0,
        1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0
    };
    private static double[] EXPECTED_CEILED_VALUES = {
        200.0, 200.0, 200.0, 200.0,
        500.0, 500.0, 500.0, 500.0, 500.0, 500.0, 500.0, 500.0, 500.0, 500.0,
        1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0,
        1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0,
        2000.0, 2000.0, 2000.0, 2000.0,
    };

    @Test
    public void testRoundNumberSmall() {
        assertEquals("Unexpected ", 0.001, Rounder.roundDown(0.001234567), TOLERANCE);
    }

    @Test
    public void testRoundNumberMediumUpper() {
        assertEquals("Unexpected ", 10.0, Rounder.roundDown(8.87653), TOLERANCE);
    }

    @Test
    public void testRoundNumberMediumLower() {
        assertEquals("Unexpected ", 5.0, Rounder.roundDown(4.363), TOLERANCE);
    }

    @Test
    public void testRoundNumberLargeUpper() {
        assertEquals("Unexpected ", 200000000000.0, Rounder.roundDown(172034506708.90123), TOLERANCE);
    }

    @Test
    public void testRoundNumberLargeLower() {
        assertEquals("Unexpected ", 200000000000.0, Rounder.roundDown(172034506708.90123), TOLERANCE);
    }

    @Test
    public void testRoundNumber() {
        int index = 0;
        for (double inc = 0; inc < 1000; inc += 30.0) {
            double value = BASE_VALUE + inc;
            //System.out.print(Rounder.round(value, true) +", ");
            assertEquals("Unexpected rounded value for " + value,
                    EXPECTED_ROUNDED_VALUES[index], Rounder.roundDown(value), TOLERANCE);
            index++;
        }
        assertEquals("Unexpected ", 200000000000.0, Rounder.roundDown(172034506708.90123), TOLERANCE);
    }



    public void testCielNumberSmall() {
        assertEquals("Unexpected ", 0.002, Rounder.roundUp(0.001234567), TOLERANCE);
    }

    public void testCielNumberMediumUpper() {
        assertEquals("Unexpected ", 10.0, Rounder.roundUp(8.87653), TOLERANCE);
    }

    public void testCielNumberMediumLower() {
        assertEquals("Unexpected ", 5.0, Rounder.roundUp(4.363), TOLERANCE);
    }

    public void testCielNumberLargeUpper() {
        assertEquals("Unexpected ", 200000000000.0, Rounder.roundUp(172034506708.90123), TOLERANCE);
    }

    public void testCielNumberLargeLower() {
        assertEquals("Unexpected ", 200000000000.0, Rounder.roundUp(102034506708.90123), TOLERANCE);
    }

    public void testCieledNumber() {
        int index = 0;
        for (double inc = 0; inc < 1000; inc += 30.0) {
            double value = BASE_VALUE + inc;
            //System.out.print(Rounder.round(value, false) +", ");
            assertEquals("Unexpected rounded value for " + value,
                    EXPECTED_CEILED_VALUES[index], Rounder.roundUp(value), TOLERANCE);
            index++;
        }
    }
}