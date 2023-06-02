/*
Problem 7.	Hands Of Cards
        You are given a sequence of people and what cards he draws from the deck for every person. The input will be separate lines in the format:
        "{personName}: {PT, PT, PT,… PT}"
        Where P (2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A) is the power of the card and T (S, H, D, C) is the type. The input ends when a "JOKER" is drawn. The name can contain any ASCII symbol except ":". The input will always be valid, and in the format described, there is no need to check it.
        A single person cannot have more than one card with the same power and type. If he draws such a card, he discards it. The people are playing with multiple decks. Each card has a value that is calculated by the power multiplied by the type. Powers 2 to 10 have the same value, and J to A is 11 to 14. Types are mapped to multipliers the following way (S -> 4, H-> 3, D -> 2, C -> 1).
        Finally, print out the total value each player has in his hand in the format:
        "{personName}: {value}"

*/


import java.util.*;

public class P07_HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> mapAllCards = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("JOKER")) {
            String[] partsInput = input.split(": ");
            String name = partsInput[0];
            String[] cardsArr = partsInput[1].split(", ");
            Set<String> cardsSet = new HashSet<>(); //Create new Set for contein all cardsArr
            cardsSet.addAll(Arrays.asList(cardsArr)); // Add all elements von cardsArr to cardsSet
            if (!mapAllCards.containsKey(name)) {
                mapAllCards.put(name, cardsSet);
            } else {
                Set<String> allcardUserCurrentHave = mapAllCards.get(name);
                allcardUserCurrentHave.addAll(Arrays.asList(cardsArr));
                mapAllCards.put(name, allcardUserCurrentHave);
            }
            input = scanner.nextLine();
        }
        mapAllCards.entrySet().forEach(el -> {
            String name = el.getKey();
            Set<String> cards = el.getValue();
            int point = getCardsPoint(cards);
            System.out.printf("%s: %d%n", name, point);
        });

    }

    private static int getCardsPoint(Set<String> cards) {
        int pointSum = 0;
        Map<Character, Integer> symvolsValue = getSymvolValue();
        for (String card : cards) {
            int point = 0;
            if (card.startsWith("10")) {
                char type = card.charAt(2);
                point = 10 * symvolsValue.get(type);
            } else {
                char power = card.charAt(0);
                char type = card.charAt(1);
                point = symvolsValue.get(power) * symvolsValue.get(type);
            }
            pointSum += point;
        }

        return pointSum;
    }

    private static Map<Character, Integer> getSymvolValue() {
        Map<Character, Integer> charackterValues = new HashMap<>();
        charackterValues.put('2', 2);
        charackterValues.put('3', 3);
        charackterValues.put('4', 4);
        charackterValues.put('5', 5);
        charackterValues.put('6', 6);
        charackterValues.put('7', 7);
        charackterValues.put('8', 8);
        charackterValues.put('9', 9);
        charackterValues.put('J', 11);
        charackterValues.put('Q', 12);
        charackterValues.put('K', 13);
        charackterValues.put('A', 14);
        charackterValues.put('S', 4);
        charackterValues.put('H', 3);
        charackterValues.put('D', 2);
        charackterValues.put('C', 1);

        return charackterValues;
    }
}
