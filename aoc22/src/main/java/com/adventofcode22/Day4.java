package com.adventofcode22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day4 {
    public static void main(String[] args) {
        int dayNumber = 4;
        if(dayNumber == 0) {
            throw new IllegalArgumentException("Day number must not be zero");
        }
        System.out.println(solution(String.format("/Day%dInput.txt", dayNumber)));
        System.out.println(solution2(String.format("/Day%dInput.txt", dayNumber)));
    }

    public static boolean between(int num, int low, int high) {
        return low <= num && num <= high;
    }

    public static Integer solution(String file) {
        InputStream inputStream = Day4.class.getResourceAsStream(file);
        assert inputStream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;

        int overlaps = 0;

        final Pattern pattern = Pattern.compile("(\\d{1,})-(\\d{1,}),(\\d{1,})-(\\d{1,})", Pattern.MULTILINE);
        
        try {
            while ((line = reader.readLine()) != null) {
                final Matcher matcher = pattern.matcher(line);

                matcher.find();

                int s1 = Integer.valueOf(matcher.group(1));
                int e1 = Integer.valueOf(matcher.group(2));
                int s2 = Integer.valueOf(matcher.group(3));
                int e2 = Integer.valueOf(matcher.group(4));

                if ((between(s1, s2, e2) && between(e1, s2, e2)) || (between(s2, s1, e1) && between(e2, s1, e1))) {
                    overlaps += 1;
                }
            }
        } catch (IOException e) {

        }
        
        return overlaps;
    }

    public static Integer solution2(String file) {
        InputStream inputStream = Day4.class.getResourceAsStream(file);
        assert inputStream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;

        int overlaps = 0;

        final Pattern pattern = Pattern.compile("(\\d{1,})-(\\d{1,}),(\\d{1,})-(\\d{1,})", Pattern.MULTILINE);
        
        try {
            while ((line = reader.readLine()) != null) {
                final Matcher matcher = pattern.matcher(line);

                matcher.find();

                int s1 = Integer.valueOf(matcher.group(1));
                int e1 = Integer.valueOf(matcher.group(2));
                int s2 = Integer.valueOf(matcher.group(3));
                int e2 = Integer.valueOf(matcher.group(4));

                if (between(s1, s2, e2) || between(e1, s2, e2) || between(s2, s1, e1) || between(e2, s1, e1)) {
                    overlaps += 1;
                }
            }
        } catch (IOException e) {

        }
        
        return overlaps;
    }
}
