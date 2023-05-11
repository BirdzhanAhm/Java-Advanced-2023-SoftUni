/*6. Hot Potato
        Hot potato is a game in which children form a circle and start passing a hot potato. The counting starts with the
        first kid. Every n
        th
        toss, the child left with the potato leaves the game. When a kid leaves the game, it passes the
        potato forward. This continues repeating until there is only one kid left.
        Create a program that simulates the game of Hot Potato. Print every kid that is removed from the circle. In the end,
        print the kid that is left last.*/


import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split("\\s+"); //splitvane po space
        int n = scanner.nextInt();                 //direktno chetem ot konsolata bez da parsvame
        ArrayDeque<String> ques = new ArrayDeque<>();

        for (String name : names) {   //Prochetenite imena gi dobavqme kam opashkata
            ques.offer(name);         //dobavq v opashkata
        }

        while (ques.size() > 1) {
            for (int i = 1; i < n; i++) {
                String move = ques.poll();
                ques.offer(move);
            }
            System.out.println("Removed " + ques.poll());

        }
        System.out.println("Last is " + ques.poll());
    }
}
