/*
4. Extract Integers
        Read the file provided, named "input.txt" and extracts all integers that are not a part of a word in a separate file. Avalid integer is surrounded by white spaces.
        Hints
        • Wrap a FileInputStream in a Scanner and use the methods, hasNext(), hasNextInt() andnextInt().
*/


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class P04_ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
        String pathRead = "D:\\Education\\StreamsFilesAndDirectoriesLab\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream inputStream = new FileInputStream(pathRead);
        Scanner scanner = new Scanner(inputStream);

        String pathWrite = "D:\\Education\\StreamsFilesAndDirectoriesLab\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\outptt.txt";
        FileOutputStream outputStream = new FileOutputStream(pathWrite);
        PrintWriter writer = new PrintWriter(outputStream);

        //hasNext -> true: we haven't reached the end of the file -> не сме стигнали до края на файла
        //hasNext -> false: we have reached the end of the file ->сме стигнали до края на файла
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                writer.println(number);
            }
            scanner.next();
        }

        writer.close();
    }
}
