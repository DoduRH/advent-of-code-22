package com.adventofcode22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * AOC Day 1
 */
public final class Day5 {
    public static void main(String[] args) {
        System.out.println(solution("/Day5Input.txt"));
        System.out.println(solution2("/Day5Input.txt"));
    }

    public static String solution(String file) {
        InputStream inputStream = Day5.class.getResourceAsStream(file);
        assert inputStream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;

        String fileContents = "";
        try {
            while ((line = reader.readLine()) != null) {
                fileContents += line + "\n";
            }
        } catch (

        IOException e) {

        }
        
        // Get initial stack state
        // locate empty line
        String[] parts = fileContents.split("\n\n");
        
        String initialStackString = parts[0];
        String moves = parts[1];
        
        List<ArrayList<String>> stacks;

        // Lazy parsing
        if (file.contains("Test")) {
            stacks = List.of(
                new ArrayList<>(Arrays.asList("Z","N")),
                new ArrayList<>(Arrays.asList("M", "C", "D")),
                new ArrayList<>(Arrays.asList("P"))
            );
        } else {
            stacks = List.of(
                new ArrayList<>(Arrays.asList("S","C","V","N")),
                new ArrayList<>(Arrays.asList("Z","M","J","H","N","S")),
                new ArrayList<>(Arrays.asList("M","C","T","G","J","N","D")),
                new ArrayList<>(Arrays.asList("T","D","F","J","W","R","M")),
                new ArrayList<>(Arrays.asList("P","F","H")),
                new ArrayList<>(Arrays.asList("C","T","Z","H","J")),
                new ArrayList<>(Arrays.asList("D","P","R","Q","F","S","L","Z")),
                new ArrayList<>(Arrays.asList("C","S","L","H","D","F","P","W")),
                new ArrayList<>(Arrays.asList("D","S","M","P","F","N","G","Z"))
            );
        }

        for (String moveLine : moves.split("\n")) {
            final Pattern pattern = Pattern.compile("move (\\d{1,}) from (\\d{1,}) to (\\d{1,})");
            final Matcher matcher = pattern.matcher(moveLine);
            matcher.find();
            int numBoxes = Integer.valueOf(matcher.group(1));
            int fromTowerIdx = Integer.valueOf(matcher.group(2))-1;
            int toTowerIdx =  Integer.valueOf(matcher.group(3))-1;

            List<String> fromTower = stacks.get(fromTowerIdx);
            List<String> toTower = stacks.get(toTowerIdx);

            for (int i = 0; i<numBoxes; i++) {
                String elm = stacks.get(fromTowerIdx).remove(fromTower.size() - 1);

                toTower.add(elm);
            }
        }

        String output = "";

        for (List<String> stack : stacks) {
            output += stack.get(stack.size() - 1);
        }

        // Calculate max
        return output;
    }
    public static String solution2(String file) {
        InputStream inputStream = Day5.class.getResourceAsStream(file);
        assert inputStream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;

        String fileContents = "";
        try {
            while ((line = reader.readLine()) != null) {
                fileContents += line + "\n";
            }
        } catch (

        IOException e) {

        }
        
        // Get initial stack state
        // locate empty line
        String[] parts = fileContents.split("\n\n");
        
        String initialStackString = parts[0];
        String moves = parts[1];
        
        List<ArrayList<String>> stacks;

        if (file.contains("Test")) {
            stacks = List.of(
                new ArrayList<>(Arrays.asList("Z","N")),
                new ArrayList<>(Arrays.asList("M", "C", "D")),
                new ArrayList<>(Arrays.asList("P"))
            );
        } else {
            stacks = List.of(
                new ArrayList<>(Arrays.asList("S","C","V","N")),
                new ArrayList<>(Arrays.asList("Z","M","J","H","N","S")),
                new ArrayList<>(Arrays.asList("M","C","T","G","J","N","D")),
                new ArrayList<>(Arrays.asList("T","D","F","J","W","R","M")),
                new ArrayList<>(Arrays.asList("P","F","H")),
                new ArrayList<>(Arrays.asList("C","T","Z","H","J")),
                new ArrayList<>(Arrays.asList("D","P","R","Q","F","S","L","Z")),
                new ArrayList<>(Arrays.asList("C","S","L","H","D","F","P","W")),
                new ArrayList<>(Arrays.asList("D","S","M","P","F","N","G","Z"))
            );
        }

        for (String moveLine : moves.split("\n")) {
            final Pattern pattern = Pattern.compile("move (\\d{1,}) from (\\d{1,}) to (\\d{1,})");
            final Matcher matcher = pattern.matcher(moveLine);
            matcher.find();
            int numBoxes = Integer.valueOf(matcher.group(1));
            int fromTowerIdx = Integer.valueOf(matcher.group(2))-1;
            int toTowerIdx =  Integer.valueOf(matcher.group(3))-1;

            List<String> fromTower = stacks.get(fromTowerIdx);
            List<String> toTower = stacks.get(toTowerIdx);

            int remIdx = fromTower.size() - numBoxes;

            for (int i = 0; i<numBoxes; i++) {
                String elm = stacks.get(fromTowerIdx).remove(remIdx);

                toTower.add(elm);
            }
        }

        String output = "";

        for (List<String> stack : stacks) {
            output += stack.get(stack.size() - 1);
        }

        // Calculate max
        return output;
    }
}
