/*1. Reverse Numbers with a Stack
        Write a program that reads N integers from the console and reverses them using a stack. Use the
        ArrayDeque<Integer> class. Just put the input numbers in the stack and pop them.
*/
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithAStack01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        //scanner.nextLine().split("\\s+");
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int number : numbers) {
            stack.push(number);
        }

        while (!stack.isEmpty()){
            System.out.println(stack.poll());
        }
    }
}
