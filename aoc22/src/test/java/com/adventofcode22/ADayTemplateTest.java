package com.adventofcode22;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
class ADayTemplateTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testStar1() {
        Integer answer = ADayTemplate.solution("/Day1Test.txt");

        assertEquals(24000, answer);
    }

    @Test
    void testStar2() {
        Integer answer = ADayTemplate.solution("/Day1Test.txt");

        assertEquals(45000, answer);
    }
}
