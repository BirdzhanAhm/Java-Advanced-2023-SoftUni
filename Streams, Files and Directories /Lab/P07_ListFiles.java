/*
7. List Files
        You are provided a folder named "Files-and-Streams". Create a program that lists the names and file sizes (in bytesof all files that are placed directly in it (do not include files in nested folders).
        Hints
        • Use the File class and its method listFiles().

*/

        import java.io.File;

public class P07_ListFiles {
    public static void main(String[] args) {
        File folder = new File("D:\\Education\\StreamsFilesAndDirectoriesLab\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        if (folder.exists()) {
            //съществува такъв файл
            if (folder.isDirectory()) {
                //файлър е папка
                File[] allFiles = folder.listFiles();
                for (File file : allFiles) {
                    if (!file.isDirectory()) {
                        System.out.printf("%s: [%d]%n", file.getName(), file.length());
                    }
                }
            }
        }
    }
}
