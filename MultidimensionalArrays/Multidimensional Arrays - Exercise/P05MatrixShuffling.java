/*
5.	Matrix Shuffling
        Write a program which reads a string matrix from the console and performs certain operations with its elements. User input is provided similarly to the problems above – first, you read the dimensions and then the data.
        Your program should then receive commands in the format: "swap row1 col1 row2c col2" where row1, row2, col1, col2 are coordinates in the matrix. For a command to be valid, it should start with the "swap" keyword along with four valid coordinates (no more, no less). You should swap the values at the given coordinates (cell [row1, col1] with cell [row2, col2]) and print the matrix at each step (this you'll be able to check if the operation was performed correctly).
        If the command is not valid (doesn't contain the keyword "swap", has fewer or more coordinates entered, or the given coordinates do not exist), print "Invalid input!" and move on to the next command. Your program should finish when the string "END" is entered.
*/


import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dimensionssInput = scanner.nextLine(); // Read firs Line "3 4" .split "3" "4"
        int rows = Integer.parseInt(dimensionssInput.split("\\s+")[0]); //first element "3"
        int cols = Integer.parseInt(dimensionssInput.split("\\s+")[1]); // Second element"4"

        String[][] matrix = new String[rows][cols];
        //1. Fill Matrix whit data on console
        fillMatrix(matrix, scanner);
        String command = scanner.nextLine(); // input comand

        while (!command.equals("END")) { // until introduction command "END" Cheked
            // Validirane na komanda
            if (validationcommand(command, rows, cols)) {
                // when is Valid command change each other
                String[] commandParts = command.split("\\s+");
                int row1 = Integer.parseInt(commandParts[1]);
                int col1 = Integer.parseInt(commandParts[2]);
                int row2 = Integer.parseInt(commandParts[3]);
                int col2 = Integer.parseInt(commandParts[4]);
                String firstElelemnt = matrix[row1][col1];
                String secondElemnt = matrix[row2][col2];

                matrix[row1][col1] = secondElemnt;
                matrix[row2][col2] = firstElelemnt;

                printMatrix(matrix, rows, cols);
            }
            //Not Valid
            else {
                System.out.println("Invalid input!");
            }
            command = scanner.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();//Svali kursora na sledvasht red
        }
    }

    public static void fillMatrix(String[][] matrix, Scanner scaner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scaner.nextLine().split("\\s+");
        }
    }

    public static boolean validationcommand(String command, int rows, int cols) {
        //true -> When Command is Valid
        //false -> when command is not valid
        // true -> valid coordinate
        String[] commandParts = command.split("\\s+");
        // 1. check first command contain swap
        if (!commandParts[0].equals("swap")) {
            return false;
        }
        //2. count commmandt is 5 check
        if (commandParts.length != 5) {
            return false;
        }
        //3. check coordinate is valid
        int row1 = Integer.parseInt(commandParts[1]);
        int col1 = Integer.parseInt(commandParts[2]);
        int row2 = Integer.parseInt(commandParts[3]);
        int col2 = Integer.parseInt(commandParts[4]);

        if (row1 < 0 || row1 >= rows || row2 < 0 || row2 >= rows || col1 < 0 || col1 >= cols || col2 < 0 || col2 >= cols) {
            return false;
        }
        return true;
    }
}
