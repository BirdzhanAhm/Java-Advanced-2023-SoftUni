/*
7. Cities by Continent and Country
        Write a program to read continents, countries, and their cities put them on a nested map, and print them in the
        order of their first appearance.
        Hints
        • Use a nested Map (String -> (Map -> ArrayList<String>)) .
        • Check if the continent exists before adding the country. If it doesn't, add it to the dictionary.• Check if the country exists before adding the city. If it doesn't, add it to the dictionary.

*/

import java.util.*;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, LinkedHashMap<String, List<String>>> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            String continent = command[0];
            String country = command[1];
            String city = command[2];
            if (!map.containsKey(continent)) {
                map.put(continent, new LinkedHashMap<>());
                if (!map.get(continent).containsKey(country)) {
                    map.get(continent).put(country, new ArrayList<>());
                    map.get(continent).get(country).add(city);
                } else {
                    map.get(continent).get(country).add(city);
                }
            } else {
                if (!map.get(continent).containsKey(country)) {
                    map.get(continent).put(country, new ArrayList<>());
                    map.get(continent).get(country).add(city);
                } else {
                    map.get(continent).get(country).add(city);
                }
            }
        }

        for (Map.Entry<String, LinkedHashMap<String, List<String>>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":");
            entry.getValue().entrySet().forEach(e -> System.out.println("  " + e.getKey() + " -> " +
                    String.join(", ", e.getValue())));
        }
    }
}
