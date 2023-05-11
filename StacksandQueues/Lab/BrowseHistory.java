/*
Browser History
        Write a program that takes two types of browser instructions:
        • Normal navigation: a URL is set, given by a string;
        • The string "back" sets the current URL to the last set URL
        After each instruction, the program should print the current URL. If the back instruction can't be executed, print
        "no previous URLs". The input ends with the "Home" command, and then you simply have to stop the program.

Hints
• Use ArrayDeque<>.
• Use String to keep the current page.
• Use push(), when moving to the next page.
• Use pop(), when going back.
*/

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowseHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> historyBrowserStack = new ArrayDeque<>(); //Create Stack
        String navigations = scanner.nextLine(); //Input Firts Comant
        String currentHistory = ""; //

        while (!navigations.equals("Home")) { //bis Enter Home do This
            if (navigations.equals("back")) { //chek input is back ?

                if (!historyBrowserStack.isEmpty()) {  //When is not empty do this
                    currentHistory = historyBrowserStack.pop();

                } else {  //when gibt keine URL in history Stack Print this und Neu comant geben
                    System.out.println("no previous URLs");
                    navigations = scanner.nextLine();
                    continue;
                }
            } else {
                if (!currentHistory.isEmpty()) {
                    historyBrowserStack.push(currentHistory);
                }

                currentHistory = navigations;

            }

            System.out.println(currentHistory);
            navigations = scanner.nextLine();
        }
    }
}
