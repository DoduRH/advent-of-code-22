package com.adventofcode22;

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

        return 0;
    }

    public static Integer solution2(String file) {

        // Calculate max
        return 0;
    }
}
