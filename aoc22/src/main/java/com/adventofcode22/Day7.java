package com.adventofcode22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

enum State {
    NONE,
    LS;
}

public class Day7 {
    public static void main(String[] args) {
        int dayNumber = 7;
        if (dayNumber == 0) {
            throw new IllegalArgumentException("Day number must not be zero");
        }
        System.out.println(solution(String.format("/Day%dInput.txt", dayNumber)));
        System.out.println(solution2(String.format("/Day%dInput.txt", dayNumber)));
    }

    public static Integer solution(String file) {
        InputStream inputStream = Day7.class.getResourceAsStream(file);
        assert inputStream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;

        List<String> cwd = new ArrayList<>();
        Map<String, Integer> dirSize = new HashMap<>();
        dirSize.put("", 0);

        try {
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("$")) {
                    // A command
                    String[] lineParts = line.strip().split(" ");
                    String cmd = lineParts[1];

                    switch (cmd) {
                        case "ls":
                            // Listing directory
                            break;

                        case "cd":
                            // Change directory
                            String arg = lineParts[2];
                            if (arg.equals("..")) {
                                cwd.remove(cwd.size() - 1);
                            } else if (arg.equals("/")) {
                                cwd = new ArrayList<>();
                            } else {
                                cwd.add(arg);
                            }
                            break;

                        default:
                            // In the process of making a line
                            break;

                    }
                } else {
                    String[] lineParts = line.split(" ");
                    if (!lineParts[0].equals("dir")) {
                        for (int i = 0; i < cwd.size() + 1; i++) {
                            dirSize.merge(String.join(
                                    "/",
                                    cwd.subList(0, i)),
                                    Integer.valueOf(lineParts[0]),
                                    Integer::sum);
                        }
                    }
                }

            }
        } catch (IOException e) {

        }

        int answer = dirSize.entrySet().stream()
                .map(elm -> elm.getValue())
                .filter(elm -> elm <= 100_000)
                .reduce(0, Integer::sum);

        return answer;
    }

    public static Integer solution2(String file) {
        InputStream inputStream = Day7.class.getResourceAsStream(file);
        assert inputStream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;

        List<String> cwd = new ArrayList<>();
        Map<String, Integer> dirSize = new HashMap<>();
        dirSize.put("", 0);

        try {
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("$")) {
                    // A command
                    String[] lineParts = line.strip().split(" ");
                    String cmd = lineParts[1];

                    switch (cmd) {
                        case "ls":
                            // Listing directory
                            break;

                        case "cd":
                            // Change directory
                            String arg = lineParts[2];
                            if (arg.equals("..")) {
                                cwd.remove(cwd.size() - 1);
                            } else if (arg.equals("/")) {
                                cwd = new ArrayList<>();
                            } else {
                                cwd.add(arg);
                            }
                            break;

                        default:
                            // In the process of making a line
                            break;

                    }
                } else {
                    String[] lineParts = line.split(" ");
                    if (!lineParts[0].equals("dir")) {
                        for (int i = 0; i < cwd.size() + 1; i++) {
                            dirSize.merge(String.join(
                                    "/",
                                    cwd.subList(0, i)),
                                    Integer.valueOf(lineParts[0]),
                                    Integer::sum);
                        }
                    }
                }

            }
        } catch (IOException e) {

        }

        int required = 30_000_000 - (70_000_000 - dirSize.get(""));

        Integer answer = dirSize.entrySet().stream()
                .filter(elm -> elm.getValue() >= required)
                .min((e1, e2) -> e1.getValue() - e2.getValue())
                .get().getValue();

        return answer;
    }
}
