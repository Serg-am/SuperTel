package org.example;


import java.util.*;

public class CombinationGenerator {

    // для генерации комбинаций из списка
    public static List<List<Integer>> generateCombinations(List<List<Integer>> input) {
        List<List<Integer>> result = new ArrayList<>();
        generateRecursive(input, 0, new ArrayList<>(), result);
        return result;
    }

    private static void generateRecursive(List<List<Integer>> input, int depth, List<Integer> current, List<List<Integer>> result) {
        if (depth == input.size()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (Integer num : input.get(depth)) {
            current.add(num);
            generateRecursive(input, depth + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
