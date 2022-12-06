package com.adventofcode22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * AOC Day 1
 */
public final class Day6 {
    public static void main(String[] args) {
        System.out.println(solution("/Day6Input.txt", 4));
        System.out.println(solution("/Day6Input.txt", 14));
    }

    public static Integer solution(String file, int limit) {
        InputStream inputStream = Day6.class.getResourceAsStream(file);
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

        for (int i = 3; i < fileContents.length(); i++) {
            Set<Character> current = fileContents.chars().skip(i).limit(limit).mapToObj(e->(char)e).collect(Collectors.toSet());
            
            if (current.size() == limit) {
                return i+limit;
            }
        }
        return 0;
    }
}
