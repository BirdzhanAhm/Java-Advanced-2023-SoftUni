/*
5. Printer Queue
        The printer queue is a simple way to control the order of files sent to a printer device. We know that a single printer
        can be shared between multiple devices. So to preserve the order of the files sent, we can use a queue.
        Write a program which takes filenames until the "print" command is received. Then as output, print the filenames
        in the order of printing. Some of the tasks may be canceled. If you receive "cancel" you have to remove the first
        file to be printed. If there is no current file to be printed, print "Printer is on standby".
Hints
• Use an ArrayDeque<>.
• Use offer(), when adding the file.
• Use pollFirst(), when printing the file.

*/

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String filename = scanner.nextLine();
        ArrayDeque<String> printQueue = new ArrayDeque<>(); //Create Queue

        while (!filename.equals("print")) { //do bis print command commen
            if (filename.equals("cancel")) {
                if (!printQueue.isEmpty()) {
                    System.out.println("Canceled " + printQueue.poll());
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                printQueue.offer(filename);
            }
            filename = scanner.nextLine();
        }
       // System.out.println("dnes proba zashto");
        while (!printQueue.isEmpty()) {
            System.out.println(printQueue.poll());
        }
    }
}
