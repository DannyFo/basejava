package com.urise.webapp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainStream {
    public static void main(String[] args) {
        int[] value = {1, 2, 3, 3, 2, 3};
        System.out.println(minValue(value));

        List<Integer> list = Arrays.asList(15, 20, 18, 17, 21); //91
        List<Integer> list1 = Arrays.asList(8, 19, 40, 17, 20); //104
        System.out.println(oddOrEven(list1));
        System.out.println(oddOrEven(list));
    }

    private static List<Integer> oddOrEven(List<Integer> integers) {
        int counter = 0;
        for (Integer x : integers) {
            counter = x + counter;
        }
        int finalCounter = counter;
        List<Integer> list = integers.stream().filter(x -> filtrator(finalCounter, x)).collect(Collectors.toList());
        return list;
    }

    private static boolean filtrator(int counter, Integer accumulator) {
        if (counter % 2 > 0) {
            if (accumulator % 2 > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            if (accumulator % 2 > 0) {
                return false;
            } else {
                return true;
            }
        }
    }

    private static int minValue(int[] values) {
        int i = Arrays.stream(values).sorted().reduce(0, (x, y) ->
                reduсer(x, y));
        return i;
    }

    private static int reduсer(int summ, int current) {
        if (summ % 10 != current) {
            summ = summ * 10 + current;
            return summ;
        }
        return summ;
    }
}

