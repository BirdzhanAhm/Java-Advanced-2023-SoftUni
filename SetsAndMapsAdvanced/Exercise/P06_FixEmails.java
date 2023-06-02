/*
Problem 6.	Fix Emails
        You are given a sequence of strings, each on a new line, until you receive the "stop" command. The first string is a name of a person. On the second line, you receive his email. Your task is to collect their names and emails and remove emails whose domain ends with "us", "uk," or "com" (case insensitive). Print in the following format:
        "{name} – > {email}"
*/

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P06_FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //create Map
        Map<String, String> mapData = new TreeMap<>();
//Read first Line Command Or Name
        String comand = scanner.nextLine();
        while (!comand.equals("stop")) {
            String name = comand;
            String email = scanner.nextLine();
            mapData.put(name, email);

            comand = scanner.nextLine();
        }
//Remove All Value  ended whit "uk" "us" "com"
        mapData.entrySet().removeIf(el ->
                el.getValue().endsWith("uk") ||
                        el.getValue().endsWith("us") ||
                        el.getValue().endsWith("com"));
//PrintMap
        mapData.entrySet().forEach(el -> System.out.println(el.getKey() + " -> " + el.getValue()));
    }
}
