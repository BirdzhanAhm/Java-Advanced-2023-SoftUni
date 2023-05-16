/*
4. Sum Matrix Elements
        Write a program that reads a matrix from the console and prints:
        • The count of rows
        • The count of columns
        • The sum of all matrix's elements
        On the first line, you will get the matrix dimensions in the format "{rows, columns}". On the next lines, you will
        get the elements for each row separated by a comma.
*/

import java.util.Scanner;

public class SumMatrixElements04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rowsandcolms = scanner.nextLine().split(", ");
        int r = Integer.parseInt(rowsandcolms[0]);
        int c = Integer.parseInt(rowsandcolms[1]);
        int[][] data = new int[r][c];
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            String[] columData = scanner.nextLine().split(", ");
            for (int j = 0; j <data[i].length; j++) {
                data[i][j] = Integer.parseInt(columData[j]);
                sum+=data[i][j];
            }

        }

/*        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sum += data[i][j];
            }
        }*/
        System.out.println(r);
        System.out.println(c);
        System.out.println(sum);
    }

}

