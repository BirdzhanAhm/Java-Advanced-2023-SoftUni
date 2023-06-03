/*
Read the file provided, named "input.txt" and sort all lines. Write text to another text file. Use Path and FilClasses.
*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class P06_SortLines {
    public static void main(String[] args) throws IOException {
        Path pathRead = Paths.get("D:\\Education\\StreamsFilesAndDirectoriesLab\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        Path pathWrite = Paths.get("D:\\Education\\StreamsFilesAndDirectoriesLab\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\outptt.txt");
        List<String> allLines = Files.readAllLines(pathRead);
        Collections.sort(allLines);
        Files.write(pathWrite, allLines);
    }
}
