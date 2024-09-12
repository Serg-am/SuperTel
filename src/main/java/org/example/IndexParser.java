package org.example;

import java.util.*;

public class IndexParser {


    public static List<List<Integer>> parseIndexes(String[] indexes) {
        List<List<Integer>> result = new ArrayList<>();

        for (String index : indexes) {
            List<Integer> numbers = new ArrayList<>();
            String[] parts = index.split(",");
            for (String part : parts) {
                if (part.contains("-")) {
                    String[] range = part.split("-");
                    int start = Integer.parseInt(range[0]);
                    int end = Integer.parseInt(range[1]);
                    for (int i = start; i <= end; i++) {
                        numbers.add(i);
                    }
                } else {
                    numbers.add(Integer.parseInt(part));
                }
            }
            result.add(numbers);
        }
        return result;
    }
}
