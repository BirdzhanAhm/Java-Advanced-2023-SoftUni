/*
2. Basic Stack Operations
        You will be given an integer N representing the number of elements to push into the stack, an integer S
        representing the number of elements to pop from the stack, and an integer X, an element that you should check
        whether is present in the stack. If it is, print "true" on the console. If it's not, print the smallest element currently
        present in the stack.
        Input
        • On the first line, you will be given N, S, and X separated by a single space.
        • On the next line, you will be given a line of numbers separated by one or more white spaces.
        Output
        • On a single line print, either "true" if X is present in the stack, otherwise, print the smallest element in the
        stack.
        • If the stack is empty – print 0.
*/


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//String one line all date Split to space each one
        String[] token = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(token[0]); //Convert String to Int
        int s = Integer.parseInt(token[1]);
        int x = Integer.parseInt(token[2]);

        //Create Stack
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        //add all to the Stack
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(stack::push);
        //Delete S elements on Steck
        for (int i = 0; i < s; i++) {
            stack.pop();
        }
    // Check Steak to contein
        if (stack.isEmpty()) {
            System.out.println(0);
        } else if (stack.contains(x)) {
            System.out.println(true);
        } else {
            System.out.println(Collections.min(stack));
        }
    }
}
