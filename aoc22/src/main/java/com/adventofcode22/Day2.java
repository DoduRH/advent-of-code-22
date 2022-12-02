package com.adventofcode22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * AOC Day 1
 */
public final class Day2 {
    public static void main(String[] args) {
        System.out.println(solution("/Day2Input.txt"));
        System.out.println(solution2("/Day2Input.txt"));
    }

    public static Integer solution(String file) {
        InputStream inputStream = Day2.class.getResourceAsStream(file);
        assert inputStream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        Integer currentScore = 0;
        String line;

        try {
            while ((line = reader.readLine()) != null) {
                line = line.replace("X", "0").replace("Y", "1").replace("Z", "2");
                line = line.replace("A", "0").replace("B", "1").replace("C", "2");

                String[] scores = line.split(" ");

                Integer p1 = Integer.valueOf(scores[0]);
                Integer p2 = Integer.valueOf(scores[1]);

                if (p1 == p2) {
                    currentScore += 3;
                } else if ((p1 - p2 + 3) % 3 == 1) {
                    currentScore += 0;
                } else if ((p2 - p1 + 3) % 3 == 1) {
                    currentScore += 6;
                }

                currentScore += p2 + 1;
            }
        } catch (

        IOException e) {

        }

        // Calculate max
        return currentScore;
    }

    public static Integer solution2(String file) {
        InputStream inputStream = Day2.class.getResourceAsStream(file);
        assert inputStream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        Integer currentScore = 0;
        String line;

        try {
            while ((line = reader.readLine()) != null) {
                line = line.replace("A", "0").replace("B", "1").replace("C", "2");
                line = line.replace("X", "-1").replace("Y", "0").replace("Z", "1");

                String[] scores = line.split(" ");

                Integer p1 = Integer.valueOf(scores[0]);
                Integer modifier = Integer.valueOf(scores[1]);
                Integer p2 = (p1 + modifier + 3) % 3;

                if (p1 == p2) {
                    currentScore += 3;
                } else if ((p1 - p2 + 3) % 3 == 1) {
                    currentScore += 0;
                } else if ((p2 - p1 + 3) % 3 == 1) {
                    currentScore += 6;
                }

                currentScore += p2 + 1;
            }
        } catch (IOException e) {

        }

        return currentScore;
    }
}
