package com.adventofcode22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

/**
 * AOC Day 1
 */
public final class Day2 {
    public static void main(String[] args) {
        System.out.println(solution2("/Day2Input.txt"));
    }

    public static Integer solution(String file) {
        InputStream inputStream = Day2.class.getResourceAsStream(file);
        assert inputStream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        List<Integer> elves = new java.util.ArrayList<>(Collections.emptyList());

        Integer currentScore = 0;
        String line;

        try {
            while ((line = reader.readLine()) != null) {
                // System.out.print(line);
                line = line.replace("X", "R").replace("Y", "P").replace("Z", "S");
                line = line.replace("A", "R").replace("B", "P").replace("C", "S");

                String[] scores = line.split(" ");

                Integer p1;
                Integer p2;
                switch (scores[0]) {
                    case "R":
                        p1 = 0;
                        break;

                    case "P":
                        p1 = 1;
                        break;

                    case "S":
                        p1 = 2;
                        break;

                    default:
                        p1 = -1;
                }

                switch (scores[1]) {
                    case "R":
                        p2 = 0;
                        break;

                    case "P":
                        p2 = 1;
                        break;

                    case "S":
                        p2 = 2;
                        break;

                    default:
                        p2 = -1;
                }

                if (p1 == p2) {
                    currentScore += 3;
                    // System.out.println(" Draw");
                } else if ((p1 - p2 + 3) % 3 == 1) {
                    currentScore += 0;
                    // System.out.println(" P1 wins");
                } else if ((p2 - p1 + 3) % 3 == 1) {
                    currentScore += 6;
                    // System.out.println(" P2 wins");
                }

                currentScore += p2 + 1;

                // System.out.println(currentScore);
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
                System.out.print(line);
                line = line.replace("A", "R").replace("B", "P").replace("C", "S");
                line = line.replace("X", "L").replace("Y", "D").replace("Z", "W");

                String[] scores = line.split(" ");

                Integer p1;
                Integer p2;
                switch (scores[0]) {
                    case "R":
                        p1 = 0;
                        break;

                    case "P":
                        p1 = 1;
                        break;

                    case "S":
                        p1 = 2;
                        break;

                    default:
                        p1 = -1;
                }

                switch (scores[1]) {
                    case "W":
                        p2 = (p1 + 1) % 3;
                        break;

                    case "L":
                        p2 = (p1 - 1 + 3) % 3;
                        break;

                    case "D":
                        p2 = p1;
                        break;

                    default:
                        p2 = -1;
                }

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
