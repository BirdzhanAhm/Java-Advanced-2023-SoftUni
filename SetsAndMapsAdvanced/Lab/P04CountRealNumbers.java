/*
4. Count Real Numbers
        Write a program that counts the occurrence of real numbers. The input is a single line with real numbers separated
        by a space. Print the numbers in the order of appearance. All numbers must be formatted to one digit after the
        decimal point.
*/

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Double, Integer> mapsStackeNumbers = new LinkedHashMap<>();

        String[] nummbers = scanner.nextLine().split(" ");

        for (String number : nummbers) {
            Double courrent = Double.parseDouble(number);
            if (mapsStackeNumbers.containsKey(courrent)) {
                int counter = mapsStackeNumbers.get(courrent);
                mapsStackeNumbers.put(courrent, counter + 1);
            } else {
                mapsStackeNumbers.put(courrent, 1);
            }
        }

        for (Double current : mapsStackeNumbers.keySet()) {
            System.out.printf("%.1f -> %d %n", current, mapsStackeNumbers.get(current));
        }
    }
}
