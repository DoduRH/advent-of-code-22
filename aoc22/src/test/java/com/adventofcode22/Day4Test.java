package com.adventofcode22;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
class Day4Test {
    /**
     * Rigorous Test.
     */
    @Test
    void testStar1() {
        Integer answer = Day4.solution("/Day4Test.txt");

        assertEquals(2, answer);
    }

    @Test
    void testStar2() {
        Integer answer = Day4.solution2("/Day4Test.txt");

        assertEquals(4, answer);
    }
}
