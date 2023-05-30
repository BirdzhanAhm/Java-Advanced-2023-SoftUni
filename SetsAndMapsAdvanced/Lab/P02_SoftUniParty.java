/*
2. SoftUni Party
        There is a party in SoftUni. Many guests are invited, and they are two types: VIP and regular.
        When a guest comes, you have to check if he/she exists on any of the two reservation lists. All reservation numbers
        will be with 8 chars. All VIP numbers start with a digit.
        There will be 2 command lines:
        • First is "PARTY" - the party is on, and guests are coming.
        • The second is "END" - then the party is over, and no more guests will come.
        The output shows all guests who didn't come to the party (VIP must be first).
*/

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();
        Set<String> gastUniqueCode = new TreeSet<>();

        while (!code.equals("PARTY")) {
            gastUniqueCode.add(code);
            code = scanner.nextLine();
        }
        code = scanner.nextLine();
        while (!code.equals("END")) {
            gastUniqueCode.remove(code);
            code = scanner.nextLine();
        }

        System.out.println(gastUniqueCode.size());
        gastUniqueCode.forEach(gastt -> System.out.println(gastt));
    }
}
