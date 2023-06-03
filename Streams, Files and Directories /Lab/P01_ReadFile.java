/*
1. Read File
        You are given a file named "input.txt". Read and print all of its contents as a sequence of bytes (the binary
        representation of the ASCII code for each character) separated by a single comma.
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class P01_ReadFile {
    public static void main(String[] args) throws IOException { //! IOException immer mus geben wenn try catch ist not in code
        //Variably Paths whit file paths on your file sistems
        String path = "D:\\Education\\StreamsFilesAndDirectoriesLab\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pahtOutput = "D:\\Education\\StreamsFilesAndDirectoriesLab\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\outptt.txt";
        //Open All Filles to Read and Write

        FileInputStream filestream = new FileInputStream(path);
        FileOutputStream outputfile = new FileOutputStream(pahtOutput);

        int onByte = filestream.read(); //// variably to contain ascii code von  char symbol
        while (onByte != -1) {
            System.out.print(Integer.toBinaryString(onByte) + " "); //convert intg to Binarry
            outputfile.write(onByte); //write file

            onByte = filestream.read();
        }
        //close file
        filestream.close();
        outputfile.close();
    }
}
