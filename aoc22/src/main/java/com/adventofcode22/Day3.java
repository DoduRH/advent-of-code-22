package com.adventofcode22;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Day3 {
    public static void main(String[] args) {
        int dayNumber = 3;
        if (dayNumber == 0) {
            throw new IllegalArgumentException("Day number must not be zero");
        }
        System.out.println(solution(String.format("/Day%dInput.txt", dayNumber)));
        System.out.println(solution2(String.format("/Day%dInput.txt", dayNumber)));
    }

    public static Integer solution(String file) {
        InputStream inputStream = Day2.class.getResourceAsStream(file);
        assert inputStream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;

        int total = 0;

        try {
            while ((line = reader.readLine()) != null) {
                int mid = line.length() / 2;
                String part1 = line.substring(0, mid);
                String part2 = line.substring(mid);

                Set<Character> commonChars = part1.chars().mapToObj(e->(char)e).collect(Collectors.toSet());
                commonChars.retainAll(part2.chars().mapToObj(e->(char)e).collect(Collectors.toSet()));

                int ascii = (int) commonChars.iterator().next();

                total += ascii;

                if (ascii > 95) {
                    //lower case
                    total -= 96;
                } else {
                    total -= 65-27;
                }
            }
        } catch (IOException e) {

        }

        return total;
    }

    public static Integer solution2(String file) {
        InputStream inputStream = Day2.class.getResourceAsStream(file);
        assert inputStream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String elf1;

        int total = 0;

        try {
            while ((elf1 = reader.readLine()) != null) {
                String elf2 = reader.readLine();
                String elf3 = reader.readLine();

                Set<Character> commonChars = elf1.chars().mapToObj(e->(char)e).collect(Collectors.toSet());
                commonChars.retainAll(elf2.chars().mapToObj(e->(char)e).collect(Collectors.toSet()));
                commonChars.retainAll(elf3.chars().mapToObj(e->(char)e).collect(Collectors.toSet()));

                int ascii = (int) commonChars.iterator().next();

                total += ascii;

                if (ascii > 95) {
                    //lower case
                    total -= 96;
                } else {
                    total -= 65-27;
                }
            }
        } catch (IOException e) {

        }

        return total;
    }
}
