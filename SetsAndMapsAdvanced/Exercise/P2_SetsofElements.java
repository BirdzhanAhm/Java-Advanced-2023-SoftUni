/*
Problem 2.	Sets of Elements
        On the first line, you are given the length of two sets, N and M. On the next N + M lines, there are N numbers that are in the first set and M numbers that are in the second one. Find all non-repeating element that appears in both of them, and print them in the same order at the console:
        Set with length N = 4: {1, 3, 5, 7}
        Set with length M = 3: {3, 4, 5}
        Set that contains all repeating elements -> {3, 5}
*/


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P2_SetsofElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        Set<Integer> firstSet = new HashSet<>();
        Set<Integer> secondSet = new HashSet<>();
        TreeSet<Integer> compareSet = new TreeSet<>();

        for (int i = 1; i <= n; i++) {
            int nummer = Integer.parseInt(scanner.nextLine());
            firstSet.add(nummer);
        }
        for (int i = 1; i <= m; i++) {
            int nummer = Integer.parseInt(scanner.nextLine());
            secondSet.add(nummer);
        }

        firstSet.retainAll(secondSet);

        firstSet.forEach(el->System.out.print(el+" "));
        //  secondSet.forEach(System.out::println);


    }
}
