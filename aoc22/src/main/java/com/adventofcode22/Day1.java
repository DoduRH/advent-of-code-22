package com.adventofcode22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * AOC Day 1
 */
public final class Day1 {
    public static void main(String[] args) {
        System.out.println(solution("/Day1Input.txt", 3));
    }

    public static Integer solution(String file, Integer num) {
        InputStream inputStream = Day1.class.getResourceAsStream(file);
        assert inputStream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        List<Integer> elves = new java.util.ArrayList<>(Collections.emptyList());

        Integer maxCapacity = 0;
        Integer currentCap = 0;
        String line;

        try {
            while ((line = reader.readLine()) != null) {
                if (line.equals("")) {
                    elves.add(currentCap);
                    if (maxCapacity < currentCap) {
                        maxCapacity = currentCap;
                    }
                    currentCap = 0;
                } else {
                    currentCap += Integer.valueOf(line);
                }
            }
            elves.add(currentCap);
        } catch (IOException e) {

        }

        // Calculate max
        return elves.stream()
                .sorted(Comparator.reverseOrder())
                .limit(num)
                .reduce(0, Integer::sum);
    }
}
