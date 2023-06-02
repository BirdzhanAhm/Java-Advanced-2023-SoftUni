/*
Problem 4.	Count Symbols
        Write a program that reads some text from the console and counts the occurrences of each character in it. Print the results in alphabetical (lexicographical) order.
*/

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        char[] chars = inputString.toCharArray();
        Map<Character, Integer> mapCount = new TreeMap<>();
        for (int i = 0; i < chars.length; i++) {
            char inputSplit = chars[i];
            if (!mapCount.containsKey(inputSplit)) {
                mapCount.put(inputSplit, 1);
            } else {
                int curennt = mapCount.get(inputSplit);
                mapCount.put(inputSplit, curennt + 1);
            }
        }

        mapCount.entrySet().forEach(el -> System.out.println(el.getKey() + ": " + el.getValue() + " time/s"));

        //System.out.println("Test");
    }
}
