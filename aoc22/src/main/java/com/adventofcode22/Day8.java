package com.adventofcode22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Day8 {
    public static void main(String[] args) {
        int dayNumber = 8;
        if (dayNumber == 0) {
            throw new IllegalArgumentException("Day number must not be zero");
        }
        System.out.println(solution(String.format("/Day%dInput.txt", dayNumber)));
        System.out.println(solution2(String.format("/Day%dInput.txt", dayNumber)));
    }

    public static Integer solution(String file) {
        InputStream inputStream = Day8.class.getResourceAsStream(file);
        assert inputStream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;

        List<List<Integer>> trees = new ArrayList<>();
        List<List<Boolean>> visible = new ArrayList<>();

        try {
            while ((line = reader.readLine()) != null) {
                List<Integer> rowHeight = new ArrayList<>();
                List<Boolean> rowVis = new ArrayList<>();

                for (int i = 0; i < line.length(); i++) {
                    rowHeight.add(Character.getNumericValue(line.charAt(i)));
                    rowVis.add(false); // true == can be seen
                }

                trees.add(rowHeight);
                visible.add(rowVis);
            }
        } catch (IOException e) {

        }

        int visibleHeight;

        for (int rowNum = 0; rowNum < trees.size(); rowNum++) {
            // Up the rows
            visibleHeight = -1;
            for (int colNum = 0; colNum < trees.get(rowNum).size(); colNum++) {
                if (trees.get(rowNum).get(colNum) > visibleHeight) {
                    visible.get(rowNum).set(colNum, true);
                    visibleHeight = trees.get(rowNum).get(colNum);
                }
            }

            // Down the rows
            visibleHeight = -1;
            for (int colNum = trees.get(rowNum).size() - 1; colNum > 0; colNum--) {
                if (trees.get(rowNum).get(colNum) > visibleHeight) {
                    visible.get(rowNum).set(colNum, true);
                    visibleHeight = trees.get(rowNum).get(colNum);
                }
            }
        }

        for (int colNum = 0; colNum < trees.size(); colNum++) {
            visibleHeight = -1;
            for (int rowNum = 0; rowNum < trees.get(colNum).size(); rowNum++) {
                if (trees.get(rowNum).get(colNum) > visibleHeight) {
                    visible.get(rowNum).set(colNum, true);
                    visibleHeight = trees.get(rowNum).get(colNum);
                }
            }

            // Down the rows
            visibleHeight = -1;
            for (int rowNum = trees.get(colNum).size() - 1; rowNum > 0; rowNum--) {
                if (trees.get(rowNum).get(colNum) > visibleHeight) {
                    visible.get(rowNum).set(colNum, true);
                    visibleHeight = trees.get(rowNum).get(colNum);
                }
            }
        }

        for (int i = 0; i < trees.size(); i++) {
            for (int j = 0; j < trees.size(); j++) {
                System.out.printf(visible.get(i).get(j) ? "X" : " ");
            }
            System.out.printf("\n");
        }

        return visible.stream().map(elm -> elm.stream().map(e -> e.compareTo(false)).reduce(0, Integer::sum)).reduce(0,
                Integer::sum);
    }

    public static Integer getScenicScore(List<List<Integer>> trees, int row, int col) {
        int total = 1;
        // Check down
        int visibleTrees = 0;
        int visibleHeight = trees.get(row).get(col);

        System.out.printf("Tree %d, %d has ", row, col);

        for (int i = row+1; i < trees.size(); i++) {
            if (trees.get(i).get(col) < visibleHeight) {
                visibleTrees += 1;
            } else {
                visibleTrees += 1;
                break;
            }
        }

        System.out.printf("down: %d ", visibleTrees);
        total *= visibleTrees;
        visibleTrees = 0;

        // Check up
        for (int i = row-1; i >= 0; i--) {
            if (trees.get(i).get(col) < visibleHeight) {
                visibleTrees += 1;
            } else {
                visibleTrees += 1;
                break;
            }
        }

        System.out.printf("up: %d ", visibleTrees);
        total *= visibleTrees;
        visibleTrees = 0;

        // Check right
        for (int i = col+1; i < trees.size(); i++) {
            if (trees.get(row).get(i) < visibleHeight) {
                visibleTrees += 1;
            } else {
                visibleTrees += 1;
                break;
            }
        }

        System.out.printf("right: %d ", visibleTrees);
        total *= visibleTrees;
        visibleTrees = 0;

        // Check left
        for (int i = col-1; i >= 0; i--) {
            if (trees.get(row).get(i) < visibleHeight) {
                visibleTrees += 1;
            } else {
                visibleTrees += 1;
                break;
            }
        }

        System.out.printf("left: %d with a total of ", visibleTrees);
        total *= visibleTrees;
        visibleTrees = 0;

        System.out.println(total);

        return total;
    }

    public static Integer solution2(String file) {
        InputStream inputStream = Day8.class.getResourceAsStream(file);
        assert inputStream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;

        List<List<Integer>> trees = new ArrayList<>();

        try {
            while ((line = reader.readLine()) != null) {
                List<Integer> rowHeight = new ArrayList<>();

                for (int i = 0; i < line.length(); i++) {
                    rowHeight.add(Character.getNumericValue(line.charAt(i)));
                }

                trees.add(rowHeight);
            }
        } catch (IOException e) {

        }

        List<Integer> scores = new ArrayList<>();
        for (int i = 1; i < trees.size()-1; i++) {
            for (int j = 1; j < trees.size()-1; j++) {
                scores.add(getScenicScore(trees, i, j));
            }
        }

        int idx = IntStream.range(0, scores.size())
                .reduce((a, b) -> scores.get(a) < scores.get(b) ? b : a)
                .orElse(0);

        int maxVal = scores.get(idx);

        System.out.printf("Maximum is at index %d with a score of %d\n", idx, maxVal);

        return maxVal;
    }
}
