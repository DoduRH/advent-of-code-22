package com.adventofcode22;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
class Day1Test {
    /**
     * Rigorous Test.
     */
    @Test
    void testStar1() {
        Integer answer = Day1.solution("/Day1Test.txt", 1);

        assertEquals(24000, answer);
    }

    @Test
    void testStar2() {
        Integer answer = Day1.solution("/Day1Test.txt", 3);

        assertEquals(45000, answer);
    }
}
