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
        System.out.println(oddOrEven(list));
        System.out.println(oddOrEven(list1));
    }

    private static List<Integer> oddOrEven(List<Integer> integers) {
        int finalCounter = integers.stream().reduce(0, Integer::sum);
        return integers.stream()
                .filter(x -> (finalCounter % 2 > 0) != (x % 2 > 0))
                .collect(Collectors.toList());
    }

    private static int minValue(int[] values) {
        return Arrays.stream(values)
                .sorted()
                .distinct()
                .reduce(0, (x, y) ->
                x * 10 + y);
    }

}

