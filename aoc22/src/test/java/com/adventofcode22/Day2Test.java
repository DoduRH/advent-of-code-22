package com.adventofcode22;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
class Day2Test {
    /**
     * Rigorous Test.
     */
    @Test
    void testStar1() {
        Integer answer = Day2.solution("/Day2Test.txt");

        assertEquals(15, answer);
    }

    @Test
    void testStar2() {
        Integer answer = Day2.solution2("/Day2Test.txt");

        assertEquals(12, answer);
    }
}
