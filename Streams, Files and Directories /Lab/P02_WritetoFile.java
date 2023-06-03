/*
2. Write to File
        Read the file named "input.txt" that is provided for this exercise and write all its content to a file while skippany punctuation. Skip the following symbols: ",", ".", "!", "?".
        Hints
        • Create a FileInputStream to read the file.
        • Create a FileOutputStream to write to a file.
        • Create a list, containing all characters that you need to skip and check if the current char is contained in it.
*/



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class P02_WritetoFile {
    public static void main(String[] args) throws IOException { //throw IOException nor forgot
        //Path to files on your fileDirectory
        String pathFileInput = "D:\\Education\\StreamsFilesAndDirectoriesLab\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathFileOutput = "D:\\Education\\StreamsFilesAndDirectoriesLab\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\outptt.txt";
        //Open All files
        FileInputStream inpFile = new FileInputStream(pathFileInput);
        FileOutputStream ouFile = new FileOutputStream(pathFileOutput);
        // Read Byte von inputFile
        int readByte = inpFile.read();
        while (readByte != -1) { //chek for END file
            // Convert byte to Char
            char symvol = (char) readByte;
            //Chek symvol is :"." "," "!" "?"
            if (symvol != ',' && symvol != '.' && symvol != '!' && symvol != '?') {
                ouFile.write(readByte);
            }
            readByte = inpFile.read();
        }
        inpFile.close();
        ouFile.close();
    }
}
