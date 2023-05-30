/*
3. "Voina" – Number Game
        Write a program that:
        • Reads 20 numbers for both players, separated with " " (single space).
        o Every player can hold unique numbers.
        Each Round, both players get the top number from their deck. The player with the bigger number gets both
        numbers and adds them to the bottom of his sequence.
        The game ends after 50 rounds or if any player loses all of his numbers.
        Input
        • Numbers – Integer
        Output
        • Output must be "First player win!", "Second player win!" or "Draw!".
*/

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class P03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> player1 = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors
                        .toCollection(LinkedHashSet::new));
        Set<Integer> player2 = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors
                        .toCollection(LinkedHashSet::new));
        int rounds = 50;
        while (!player1.isEmpty() || !player2.isEmpty()) {
            if (rounds == 0) {
                break;
            }
            int p1Card = player1.iterator().next();
            int p2Card = player2.iterator().next();
            player1.remove(p1Card);
            player2.remove(p2Card);
            if (p1Card > p2Card) {
                player1.add(p1Card);
                player1.add(p2Card);
            } else if (p2Card > p1Card) {
                player2.add(p1Card);
                player2.add(p2Card);
            }
            rounds--;
        }
        if (player1.size() > player2.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Second player win!");
        }
    }
}
