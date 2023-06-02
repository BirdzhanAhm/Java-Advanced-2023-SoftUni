/*
Problem 3.	Periodic Table
        You are given an n number of chemical compounds. You need to keep track of all chemical elements used in the compounds and at the end, print all unique ones in ascending order:

*/

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> chemichalElement = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                chemichalElement.add(input[j]);
            }

        }
        chemichalElement.forEach(el -> System.out.print(el + " "));
    }
}
