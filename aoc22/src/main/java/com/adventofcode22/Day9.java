package com.adventofcode22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day9 {
    public static void main(String[] args) {
        int dayNumber = 9;
        if (dayNumber == 0) {
            throw new IllegalArgumentException("Day number must not be zero");
        }
        // System.out.println(solution(String.format("/Day%dInput.txt", dayNumber)));
        System.out.println(solution(String.format("/Day%dInput.txt", dayNumber), 10));
    }

    public static void printState(List<Integer> headPos, List<Integer> tailPos) {
        printState(List.of(headPos, tailPos));
    }

    public static void printState(List<List<Integer>> knots) {
        int SIZE = 30;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                String c = ".";
                // for (Integer k = 9; k >= 0; k--) {
                for (Integer k = 0; k < knots.size(); k++) {
                    if (knots.get(k).get(1) == i && knots.get(k).get(0) == j) {
                        c = k.toString();
                    }
                }
                System.out.print(c);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static Integer solution(String file) {
        return solution(file, 2);
    }

    public static Integer solution(String file, int numKnots) {
        InputStream inputStream = Day9.class.getResourceAsStream(file);
        assert inputStream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        List<List<Integer>> knots = new ArrayList<>();

        for (int i = 0; i < numKnots; i++) {
            knots.add(new ArrayList<>(List.of(15, 20)));
        }


        Set<String> visited = new HashSet<>();

        String line;

        try {
            while ((line = reader.readLine()) != null) {
                String[] action = line.split(" ");

                String dir = action[0];
                Integer num = Integer.valueOf(action[1].strip());
                System.out.printf("== %d moves %s ==\n", num, dir);
                for (int i = 0; i < num; i++) {
                    switch (dir) {
                        case "R":
                            knots.get(0).set(0, knots.get(0).get(0) + 1);
                            break;
                        case "L":
                            knots.get(0).set(0, knots.get(0).get(0) - 1);
                            break;
                        case "U":
                            knots.get(0).set(1, knots.get(0).get(1) - 1);
                            break;
                        case "D":
                            knots.get(0).set(1, knots.get(0).get(1) + 1);
                            break;
                    }

                    // Deep copy of list
                    for (int k = 1; k < numKnots; k++) {
                        // Update tail
                        Integer difX = knots.get(k).get(0) - knots.get(k-1).get(0);
                        Integer difY = knots.get(k).get(1) - knots.get(k-1).get(1);

                        if (Math.abs(difX) > 1 || Math.abs(difY) > 1) {
                            // Move it left/right
                            knots.get(k).set(0, knots.get(k).get(0) - (int) Math.signum(difX));
                            knots.get(k).set(1, knots.get(k).get(1) - (int) Math.signum(difY));
                        }
                        // System.out.printf("Knot %d\n", k);
                    }
                    
                    visited.add(String.format("%d,%d", knots.get(numKnots-1).get(0), knots.get(numKnots-1).get(1)));
                }
                // printState(knots);

                System.out.println("");
            }
        } catch (IOException e) {

        }
        return visited.size();
    }
}
