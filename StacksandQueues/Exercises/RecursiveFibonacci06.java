/*
6. Recursive Fibonacci
        Each member of the Fibonacci sequence is calculated from the sum of the two previous members. The first two
        elements are 1, 1. Therefore, the sequence goes like 1, 1, 2, 3, 5, 8, 13, 21, 34…
        The following sequence can be generated with an array, but that's easy, so your task is to implement it recursively.
        If the function getFibonacci(n) returns the n
        th
        Fibonacci number, we can express it using getFibonacci(n) =
        getFibonacci(n-1) + getFibonacci(n-2).
        However, this will never end, and a Stack Overflow Exception is thrown in a few seconds. For the recursion to stop, it
        has to have a "bottom". The bottom of the recursion is getFibonacci(1), and should return 1. The same goes for
        getFibonacci(0).
        Input
        • On the only line in the input, the user should enter the wanted Fibonacci number N where 1 ≤ N ≤ 49.
        Output
        • The output should be the n
        th
        Fibonacci number counting from 0.

*/

import java.util.Scanner;
public class RecursiveFibonacci06 {
    public static  long [] memoryForFib;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        memoryForFib = new long [n + 1];
        System.out.println(fib(n));


    }
    public static long fib (int n) {
        if (n <= 1) {
            return 1;
        }

        if (memoryForFib[n] != 0) {
            //имаме го изчислено
            return memoryForFib[n];
        }

        return memoryForFib[n] = fib(n - 1) + fib (n - 2);

    }


}
