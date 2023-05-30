/*
9. Largest 3 Numbers
        Read a list of integers and print the largest 3 of them. If there are less than 3, print all of them.
        Hints
        • Read a list of integers.
        • Order the list using Stream API.

*/


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listNumbers = new ArrayList<>();
        String[] input = scanner.nextLine().split(" ");

        for (String elem : input) {
            listNumbers.add(Integer.parseInt(elem));
        }

        List<Integer> sortedList = listNumbers
                .stream()
                .sorted((l, r) -> r.compareTo(l))
                .collect(Collectors.toList());
        int limit = Math.min(sortedList.size(), 3);
        for (int i = 0; i < limit; i++) {
            System.out.print(sortedList.get(i)+" ");
            ;
        }
        // System.out.printf("DENEME");
    }
}
