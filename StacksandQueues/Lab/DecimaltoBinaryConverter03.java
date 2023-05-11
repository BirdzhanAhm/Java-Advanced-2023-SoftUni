/*
3. Decimal to Binary Converter
        Create a simple program that can convert a decimal number to its binary representation. Implement an elegant
        solution using a Stack.
        Print the binary representation back at the terminal.
        Examples
Hints
• If the given number is 0, just print 0.
• Else, while the number is greater than zero, divide it by 2 and push the reminder into the stack.
*/

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimaltoBinaryConverter03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> decimalNumber = new ArrayDeque<>();
        int number = Integer.parseInt(scanner.nextLine());


        if (number == 0) {
            System.out.println(number);

        }

        while (number!=0){
            decimalNumber.push(number%2);
            number/=2;
        }
        while (!decimalNumber.isEmpty()){
            System.out.print(decimalNumber.pop());
        }


    }
}
