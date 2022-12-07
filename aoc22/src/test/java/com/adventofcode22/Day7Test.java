package com.adventofcode22;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
class Day7Test {
    /**
     * Rigorous Test.
     */
    @Test
    void testStar1() {
        Integer answer = Day7.solution("/Day7Test.txt");

        assertEquals(95437, answer);
    }

    @Test
    void testStar2() {
        Integer answer = Day7.solution2("/Day7Test.txt");

        assertEquals(24933642, answer);
    }
}
