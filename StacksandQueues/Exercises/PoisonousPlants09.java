/*
9. **Poisonous Plants
        You are given N plants in a garden. Each of these plants has been added with some amount of pesticide. You are
        given the pesticide's initial values and each plant's position. After each day, if any plant has more pesticide than the
        plant at its left, being weaker (more GMO) than the left one, it dies. Print the number of days after which no plant
        dies, i.e. the time after which there are no plants with more pesticide content than the plant to their left.
        Input
        • The input consists of an integer N representing the number of plants.
        • The next single line consists of N integers, where every integer represents each plant's position and amount
        of pesticides. 1 ≤ N ≤ 100000.
        • Pesticides amount on a plant is between 0 and 1000000000.
        Output
        • Output a single value equal to the number of days after which no plants die.
*/

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class PoisonousPlants09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] plants = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        ArrayDeque<Integer> prevPlants = new ArrayDeque<>();
        int[] days = new int[plants.length];
        prevPlants.push(0);
        for (int x = 1; x < plants.length; x++) {
            int maxDays = 0;
            while (prevPlants.size() > 0 && plants[prevPlants.peek()] >= plants[x]) {

                maxDays = Integer.max(days[prevPlants.pop()], maxDays);
            }

            if (prevPlants.size() > 0) {
                days[x] = maxDays + 1;
            }

            prevPlants.push(x);
        }

        System.out.printf("%d", Arrays.stream(days).max().getAsInt());
    }
}
