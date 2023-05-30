/*
6. Product Shop
        Write a program that prints information about food shops in Sofia and the products they store. Until"Revision" command you will receive an input in the format: "{shop}, {product}, {price}"
        Keep in mind that if you get a store that already exists, you must gather product information.
        Your output must be ordered by shop name and must be in the format:
        "{shop}->
        Product: {product}, Price: {price}"
        The price should be formatted to one digit after the decimal point.

*/


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P06_ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String item = scanner.nextLine();
        TreeMap<String, LinkedHashMap<String, Double>> map = new TreeMap<>();


        while (!item.equals("Revision")) {
            String[] input = item.split(", ");
            String nameMarket = input[0];
            String productname = input[1];
            Double price = Double.parseDouble(input[2]);

            if (!map.containsKey(nameMarket)) {
                map.put(nameMarket, new LinkedHashMap<>());
                if (!map.get(nameMarket).containsKey(productname)) {
                    map.get(nameMarket).put(productname, price);
                }
            } else {
                map.get(nameMarket).put(productname, price);
            }
            item = scanner.nextLine();
        }
        for (Map.Entry<String, LinkedHashMap<String, Double>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "->");
            for (Map.Entry<String, Double> innerEntry : map.get(entry.getKey()).entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", innerEntry.getKey(), innerEntry.getValue());
            }
        }
    }
}
