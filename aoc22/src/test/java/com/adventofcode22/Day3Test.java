package com.adventofcode22;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
class Day3Test {
    /**
     * Rigorous Test.
     */
    @Test
    void testStar1() {
        Integer answer = Day3.solution("/Day3Test.txt");

        assertEquals(157, answer);
    }

    @Test
    void testStar2() {
        Integer answer = Day3.solution2("/Day3Test.txt");

        assertEquals(70, answer);
    }
}
