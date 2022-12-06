package com.adventofcode22;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Day6Test {
    @Test
    void testStar1() {
        Integer answer = Day6.solution("/Day6Test.txt", 4);

        assertEquals(10, answer);
    }

    @Test
    void testStar2() {
        Integer answer = Day6.solution("/Day6Test.txt", 14);

        assertEquals(29, answer);
    }
}
