package com.company.Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnePartTwo {
    public static void main(String[] args) throws FileNotFoundException {
//        List<Integer> list = new ArrayList<>();
//
//        try(Scanner scanner = new Scanner(Path.of("two.txt"))) {
//            while(scanner.hasNextLine()) {
//                list.add(Integer.parseInt(scanner.nextLine()));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        Integer[] array = list.toArray(new Integer[0]);
//        int first = array[0];
//        int second = array[1];
//        int third = array[2];
//        int sum = first + second + third;
//        int holder = 0;
//        int counter = 0;
//
//        for(int i = 3; i < array.length; i++) {
//            first = second;
//            second = third;
//            third = array[i];
//            holder = first + second + third;
//            if(holder > sum) {
//                counter++;
//                sum = holder;
//                System.out.println("NEW SUM : " + sum);
//
//            }
//
//        }
//        System.out.println("-------------------");
//        System.out.println(array[array.length-3] + "|" + array[array.length-2] + "|" + array[array.length-1]);
//
//
//        System.out.println(counter);
        ArrayList<Integer> data = new ArrayList<>();
        File text = new File("two.txt");
        Scanner input = new Scanner(text);
        while(input.hasNextLine()) {
            data.add(Integer.parseInt(input.nextLine()));
        }

        //solution for problem one
        int result = 0;
        for(int i = 1; i < data.size(); i++) {
            if(data.get(i) > data.get(i - 1))
                result++;
        }
        System.out.println("Problem one answer :: " + result);

        //solution for problem two
        result = 0;
        int prevSum = 0;
        for(int i = 2; i < data.size(); i++) {
            int sum = data.get(i - 2) + data.get(i - 1) + data.get(i);
            if(prevSum != 0)
                if(sum > prevSum)

                    result++;
            prevSum = sum;
            System.out.println("NEW SUM :: " + prevSum );

        }
        System.out.println("Problem two answer :: " + result);

    }
}
