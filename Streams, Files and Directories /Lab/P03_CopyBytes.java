/*
3. Copy Bytes
        Read the file named "input.txt" and write to another file every character's ASCII representation. Write every space or new line as it is, e.g., a space or a new line.
*/


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class P03_CopyBytes {
    public static void main(String[] args) throws IOException {
        String pathIn = "D:\\Education\\StreamsFilesAndDirectoriesLab\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "D:\\Education\\StreamsFilesAndDirectoriesLab\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\outptt.txt";

        FileInputStream in = new FileInputStream(pathIn);
        FileOutputStream out = new FileOutputStream(pathOut);

        int oneByte = in.read();
        while (oneByte >= 0) {
            if (oneByte == 32 || oneByte == 10) { //Check ascci code this is "space" or "new Line"
                out.write(oneByte);
            } else {
                //comvert asccii code to string
                String digits = String.valueOf(oneByte);
                //all charachter write on file
                for (int i = 0; i < digits.length(); i++) {
                    out.write(digits.charAt(i));
                }
            }
            //read next byte
            oneByte = in.read();

        }
    }
}
