package com.company.Day3;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * --- Day 3: Binary Diagnostic ---
 * The submarine has been making some odd creaking noises, so you ask it to produce a diagnostic report just in case.
 * <p>
 * The diagnostic report (your puzzle input) consists of a list of binary numbers which, when decoded properly, can tell you many useful things about the conditions of the submarine. The first parameter to check is the power consumption.
 * <p>
 * You need to use the binary numbers in the diagnostic report to generate two new binary numbers (called the gamma rate and the epsilon rate). The power consumption can then be found by multiplying the gamma rate by the epsilon rate.
 * <p>
 * Each bit in the gamma rate can be determined by finding the most common bit in the corresponding position of all numbers in the diagnostic report. For example, given the following diagnostic report:
 * <p>
 * 00100
 * 11110
 * 10110
 * 10111
 * 10101
 * 01111
 * 00111
 * 11100
 * 10000
 * 11001
 * 00010
 * 01010
 * Considering only the first bit of each number, there are five 0 bits and seven 1 bits. Since the most common bit is 1, the first bit of the gamma rate is 1.
 * <p>
 * The most common second bit of the numbers in the diagnostic report is 0, so the second bit of the gamma rate is 0.
 * <p>
 * The most common value of the third, fourth, and fifth bits are 1, 1, and 0, respectively, and so the final three bits of the gamma rate are 110.
 * <p>
 * So, the gamma rate is the binary number 10110, or 22 in decimal.
 * <p>
 * The epsilon rate is calculated in a similar way; rather than use the most common bit, the least common bit from each position is used. So, the epsilon rate is 01001, or 9 in decimal. Multiplying the gamma rate (22) by the epsilon rate (9) produces the power consumption, 198.
 * <p>
 * Use the binary numbers in your diagnostic report to calculate the gamma rate and epsilon rate, then multiply them together. What is the power consumption of the submarine? (Be sure to represent your answer in decimal, not binary.)
 */

public class Main {
    public static void main(String[] args) throws IOException {
//        partOne();
         partTwo();
//          3351 * 851
//        System.out.println("----------");
        partTwoOfTwo();


    }

    private static void partTwoOfTwo() throws IOException {
        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(Path.of("third.txt"));
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0");
        AtomicInteger ones = new AtomicInteger();
        AtomicInteger twos = new AtomicInteger();
        while(list.size() > 1) {
            list.forEach(e -> {
                if (e.startsWith(stringBuilder.toString())) {
                    ones.getAndIncrement();
                } else {
                    twos.getAndIncrement();
                }
            });
            if(ones.get() == twos.get()) {
                stringBuilder.append("0");
            } else if(ones.get() > twos.get()) {
                stringBuilder.append("0");
            } else {
                stringBuilder.append("1");
            }
            ones.set(0);
            twos.set(0);

            list.removeIf(e -> !e.startsWith(stringBuilder.toString()));
        }

        System.out.println(Integer.parseInt(list.get(0), 2));
    }




    private static void partTwo() throws IOException {
        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(Path.of("third.txt"));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0");
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());

        }
        int ones = 0;
        int zero = 0;

        while (list.size() != 1) {
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.get(i).length(); j++) {
                    if (list.get(i).startsWith(String.valueOf(stringBuilder))) {
                        ones++;
                    } else {
                        zero++;
                    }
                }
                if (ones == zero || ones > zero) {
                    stringBuilder.append("1");
                } else {
                    stringBuilder.append("0");
                }
                ones = 0;
                zero = 0;
                list.removeIf(e -> !e.startsWith(String.valueOf(stringBuilder)));

            }

        }
        System.out.println(Integer.parseInt(list.get(0), 2));
        System.out.println("-------------------");
        // 4094

        list.forEach(System.out::println);

    }

    private static void partOne() throws IOException {
        Map<Integer, Integer> list = new HashMap<>();
        Scanner scanner = new Scanner(Path.of("third.txt"));
        while (scanner.hasNextLine()) {
            String[] splitInput = scanner.nextLine().split("");
            for (int i = 0; i < splitInput.length; i++) {
                if (Integer.parseInt(splitInput[i]) == 1) {
                    int holder = 0;
                    if (list.get(i) != null) {
                        holder = list.get(i);
                    }
                    list.put(i, holder + Integer.parseInt(splitInput[i]));
                }
            }
        }


        StringBuilder stringBuilder = new StringBuilder();
        list.forEach((key, value) -> {
            if (value > list.size()) {
                stringBuilder.append("1");
            } else {
                stringBuilder.append("0");
            }
        });

        StringBuilder stringBuilderOne = new StringBuilder();
        list.forEach((key, value) -> {
            if (value < list.size()) {
                stringBuilderOne.append("1");
            } else {
                stringBuilderOne.append("0");
            }
        });
        System.out.println(Integer.parseInt(stringBuilder.toString(), 2) * Integer.parseInt(stringBuilderOne.toString(), 2));
    }


}


