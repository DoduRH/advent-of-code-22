package com.adventofcode22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ADayTemplate {
    public static void main(String[] args) {
        int dayNumber = 0;
        if(dayNumber == 0) {
            throw new IllegalArgumentException("Day number must not be zero");
        }
        System.out.println(solution(String.format("/Day%dInput.txt", dayNumber)));
        System.out.println(solution(String.format("/Day%dInput.txt", dayNumber)));
    }

    public static Integer solution(String file) {
        InputStream inputStream = Day2.class.getResourceAsStream(file);
        assert inputStream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;

        try {
            while ((line = reader.readLine()) != null) {

            }
        } catch (IOException e) {

        }
        
        return 0;
    }

    public static Integer solution2(String file) {
        InputStream inputStream = Day2.class.getResourceAsStream(file);
        assert inputStream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;

        try {
            while ((line = reader.readLine()) != null) {

            }
        } catch (IOException e) {

        }

        return 0;
    }
}
