/*2. Positions Of
        Write a program that reads a matrix of integers from the console, then a number, and prints all the positions at
        which that number appears in the matrix.
        The matrix definition on the console will contain a line with two positive integer numbers R and C – the number of
        rows and columns in the matrix – followed by R lines, each containing C numbers (separated by spaces),
        representing each row of the matrix.
        The number you will need to find the positions will be entered on a single line after the matrix.
        You should print each position on a single line – first print the row, then the column at which the number appears.
        If the number does not appear in the matrix, print "not found".


        Antonia Kirchoff*/

import java.util.Scanner;

public class PositionsOf02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rowsandcolms = scanner.nextLine().split(" ");
        int row = Integer.parseInt(rowsandcolms[0]);
        int colm = Integer.parseInt(rowsandcolms[1]);
        int[][] matrix = new int[row][colm];

        for (int i = 0; i < row; i++) {
            String[] columdate = scanner.nextLine().split(" ");
            for (int j = 0; j < colm; j++) {
                matrix[i][j]=Integer.parseInt(columdate[j]);

            }

        }
        int search = Integer.parseInt(scanner.nextLine());
        boolean find = false;
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j < colm; j++) {
                if(matrix[i][j]==search){
                    System.out.println(i + " " +j);
                    find=true;
                }

            }

        }
        if(find==false){
            System.out.println("not found");
        }
    }
}
