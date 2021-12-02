package com.company.Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        dayTwoPartOne();
        dayTwoPartTwo();
    }

    private static void dayTwoPartOne() throws FileNotFoundException {
        Map<String, Integer> cordinates = new HashMap<>();
        File text = new File("two.txt");
        Scanner scanner = new Scanner(text);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int val = 0;
            if (cordinates.get(line.substring(0, line.indexOf(" "))) != null) {
                val = cordinates.get(line.substring(0, line.indexOf(" ")));
            }
            int i = Integer.parseInt(line.substring(line.indexOf(" ") + 1));
            cordinates.put(line.substring(0, line.indexOf(" ")), val + i);

        }
        cordinates.forEach((s, integer) -> System.out.println(s + " : " + integer));
    }

    private static void dayTwoPartTwo() throws FileNotFoundException {
        Map<String, Integer> coordinates = new HashMap<>();
        File text = new File("two.txt");
        Scanner scanner = new Scanner(text);
        coordinates.put("depth", 0);
        coordinates.put("aim", 0);
        coordinates.put("forward", 0);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int val;
            int i = Integer.parseInt(line.substring(line.indexOf(" ") + 1));
            if (line.substring(0, line.indexOf(" ")).equals("forward")) {
                coordinates.put("forward", coordinates.get("forward") + i);
                coordinates.put("depth", (i * coordinates.get("aim")) + coordinates.get("depth"));
            }
            if (line.substring(0, line.indexOf(" ")).equals("down")) {
                val = coordinates.get("aim");
                coordinates.put("aim", val + i);
            }
            if (line.substring(0, line.indexOf(" ")).equals("up")) {
                val = coordinates.get("aim");
                coordinates.put("aim", val - i);
            }
        }
        System.out.println(coordinates.get("depth") * coordinates.get("forward"));

    }
}

