/*
Problem 5.	Phonebook
        Write a program that receives some info from the console about people and their phone numbers.
        You are free to choose how the data is entered. Each entry should have just one name and one number (both of them strings). If you receive a name that already exists in the phonebook, simply update its number.
        After filling this simple phonebook, upon receiving the command "search", your program should be able to perform a search of contact by name and print her details in the format "{name} -> {number}". In case the contact isn't found, print "Contact {name} does not exist.".
*/


import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P05_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> mapContact = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.contains("search")){
            String[] inputallData = input.split("-");
            String name = inputallData[0];
            String phoneNummber = inputallData[1];
            if (!mapContact.containsKey(name)){
                mapContact.put(name,phoneNummber);
            }else{
                String oldTelNumber = mapContact.get(name);
                System.out.println(oldTelNumber);
            }


            input=scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("stop")){

            if (!mapContact.containsKey(input)){
                System.out.printf("Contact %s does not exist.\n",input);
            }else{
                System.out.println(input+ " -> "+ mapContact.get(input));;
            }
                input=scanner.nextLine();
        }
    }
}
