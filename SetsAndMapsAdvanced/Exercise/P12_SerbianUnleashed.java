/*
12.***Сръбско Unleashed
        Admit it – the СРЪБСКО is your favorite sort of music. You never miss a concert, and you have become quite the geek concerning everything involved with СРЪБСКО. You can't decide between all the singers you know who your favorite one is. One way to find out is to keep a statistic of how much money their concerts make. Write a program that does all the boring calculations for you.
        On each input line you’ll be given data in format: "{singer} @{venue} {ticketsPrice} {ticketsCount}". There will be no redundant whitespaces anywhere in the input. Aggregate the data by venue and by the singer. For each venue, print the singer and the total amount of money his/her concerts have made on a separate line. Venues
        should be kept in the same order they were entered, the singers should be sorted by how much money they have made in descending order. If two singers have made the same amount of money, keep them in the order in which they were entered.
        Keep in mind that if a line is in incorrect format, it should be skipped, and its data should not be added to the output. Each of the four tokens must be separated by a space, everything else is invalid. The venue should be denoted with @ in front of it, such as @Sunny Beach
        SKIP THOSE: Ceca@Belgrade125 12378, Ceca @Belgrade12312 123
        The singer and town name may consist of one to three words.

*/


import java.util.LinkedHashMap;
import java.util.Scanner;

public class P12_SerbianUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Integer>> concerts = new LinkedHashMap<>();

        String input = scanner.nextLine();
        // input = "Lepa Brena @Sunny Beach 25 3500"
        while (!input.equals("End")) {
            //Lepa Brena @Sunny Beach 25 3500
            //chek input contein @ and before @ have "Space"
            if (!input.contains("@") || input.charAt(input.indexOf("@") - 1) != ' ') {
                input = scanner.nextLine();
                continue;
            }
            //Take subtext from input String Startet at 0 index to Index "@" -1
            String singer = input.substring(0, input.indexOf("@") - 1);
            //Create variable to contain which index ist last char von Name zala
            int firstIndexOfNumber = 0;
            //@Sunny Beach 25
            for (int i = input.indexOf("@"); i < input.length(); i++) { // we loop through the entire string
                char currentSymbol = input.charAt(i);
                if (Character.isDigit(currentSymbol) && input.charAt(i - 1) == ' ') { //checking if it is not a number and before have "space"
                    firstIndexOfNumber = i; //we keep the first number encountered
                    break;
                }
            }

            if (firstIndexOfNumber == 0) {  //if it does not match but the condition and the index is equal to 0
                input = scanner.nextLine();
                continue;
            }
//Sunny Beach
            String venue = input.substring(input.indexOf("@") + 1, firstIndexOfNumber - 1); //von index @+! to firstNumber taken
            String numbers = input.substring(firstIndexOfNumber);//"25 3000"
            String[] numbersArray = numbers.split("\\s+");
            if (numbersArray.length != 2) { //chek for contein 2
                input = scanner.nextLine();
                continue;
            }
            int price = Integer.parseInt(numbersArray[0]); //25
            int capacity = Integer.parseInt(numbersArray[1]); //3000

            //venue -> {singer -> price}

            if (!concerts.containsKey(venue)) {
                LinkedHashMap<String, Integer> singers = new LinkedHashMap<>();
                singers.put(singer, price * capacity);
                concerts.put(venue, singers);
            } else {
                LinkedHashMap<String, Integer> currentSingers = concerts.get(venue);
                if (currentSingers.containsKey(singer)) {
                    currentSingers.put(singer, currentSingers.get(singer) + price * capacity);
                } else {
                    currentSingers.put(singer, price * capacity);
                }

                concerts.put(venue, currentSingers);
            }
            input = scanner.nextLine();
        }

        for (String venue : concerts.keySet()) {
            System.out.println(venue);

            LinkedHashMap<String, Integer> singers = concerts.get(venue);
            singers.entrySet().stream().sorted((singer1, singer2) -> singer2.getValue().compareTo(singer1.getValue()))
                    .forEach(singer -> System.out.println(String.format("#  %s -> %d", singer.getKey(), singer.getValue())));

        }
    }


}
