/*
Problem 1.	Unique Usernames
        Write a simple program that reads a sequence of usernames from the console and keeps a collection with only the unique ones. Print the collection on the console in order of insertion:
*/

import java.util.LinkedHashSet;
import java.util.Scanner;

public class P01_UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashSet<String> uniqueName = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            uniqueName.add(name);
        }
        uniqueName.forEach(System.out::println);

    }
}

