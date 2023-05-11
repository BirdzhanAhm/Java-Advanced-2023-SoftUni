/* Example Stack proparteis*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Stack_simple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>(); //Create Stack
        //Add ->push(1); , Remove top-> pop(); look at top->peek(); This is Stack
        // Add ->offer(1); , Remove top-> pop(); look at top->peek(); This is Que

        //Add Elemnt on Stack
        stack.push(5);
        stack.push(42);
        stack.push(34);
        stack.push(42);
        stack.push(65);
        // Print Top ELement on Stack
        /* int topElement = stack.pop();
        System.out.println(topElement);
         topElement = stack.pop();
        System.out.println(topElement);
         topElement = stack.pop();
        System.out.println(topElement); */

        // Obhozhdane na celiq Stack sas While cikal sas For cical ne moje poneje nemoje da se
        //obhozjda stacka po Index

       /* while (stack.size() > 0) {
            int topelement = stack.pop();
            System.out.println(topelement);
        } */

        System.out.println(stack.contains(34)); //Check Stack contein this Element
        stack.remove(34); // Remove Element on Stack one time
        stack.removeAll(Arrays.asList(42));  //Remove all Number 42 on Stack
        while (stack.size() > 0) {
            int topelement = stack.pop();
            System.out.println(topelement);
        }

    }
}
