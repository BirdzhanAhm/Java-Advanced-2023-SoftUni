/*
7. Math Potato
        Rework the previous problem by using a PriorityQueue so that a child is removed only on a composite (not prime)
        cycle (cycles start from 1).
        If a cycle is prime, print the child's name.
        As before, print the name of the child that is left last.
        Examples
*/

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MathPotato07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split(" ");

        int steps = Integer.parseInt(scanner.nextLine());

        PriorityQueue<String> kids = new PriorityQueue<>();
        Collections.addAll(kids, names);

        int currentSteps = 1;
        while (kids.size() > 1) {
            for (int i = 1; i < steps; i++) {
                String kid = kids.poll();
                kids.offer(kid);
            }

            if (isPrime(currentSteps)) {
                System.out.println("Prime " + kids.peek());
            } else {
                String removedChild = kids.poll();
                System.out.println("Removed " + removedChild);
            }

            currentSteps++;
        }

        System.out.println("Last is " + kids.poll());
    }

    private static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}


/* SELF PROBE Klein Fehler Gibt
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MathPotato07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+"); //splitvane po space
        int n = Integer.parseInt(scanner.nextLine());                //direktno chetem ot konsolata bez da parsvame
        //ArrayDeque<String> ques = new ArrayDeque<>();
        PriorityQueue<String> ques = new PriorityQueue<>();

        int cycle = 1;

        for (String name : names) {   //Prochetenite imena gi dobavqme kam opashkata
            ques.offer(name);         //dobavq v opashkata
        }


        while (ques.size() > 1) {
            for (int i = 1; i < n; i++) {
                String move = ques.poll();

            }
            if (isPrime(cycle)) {
                System.out.println("Prime " + ques.peek());

            } else {
                System.out.println("Removed " + ques.poll());
            }
            cycle++;

        }
        System.out.println("Last is " + ques.poll());

    }

    private static boolean isPrime(int cycle) {
        //corner case
        if (cycle <= 1) {
            return false;
        }
        for (int i = 2; i < cycle; i++) {
            //base casses
            if (cycle % 1 == 0) {
                return false;
            }
        }
        return true;

    }
}
*/
