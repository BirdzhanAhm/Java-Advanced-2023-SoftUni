/*
3. Diagonal Difference
        Write a program that finds the difference between the sums
        of the square matrix diagonals (absolute value).
        Input
        • The first line holds a number n – the size of matrix.
        • The next n lines hold the values for every row – n numbers separated by a space.
        Hints
        • Use a single loop i = [1 … n] to sum the diagonals.
        • The primary diagonal holds all cells {row, col} where row == col == i.
        • The secondary diagonal holds all cells {row, col} where row == i and col == n-1-i.
*/

import java.util.Scanner;

public class P3DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] alldata = scanner.nextLine().split(" ");
        int size = Integer.parseInt(alldata[0]);
        int[][] matrix = new int[size][size];
        int sumfirstdiagonal = 0;
        int suseconddiagonal = 0;

        for (int i = 0; i < matrix.length; i++) {
            String[] data = scanner.nextLine().split(" ");
            for (int col = 0; col < matrix.length; col++) {
                matrix[i][col] = Integer.parseInt(data[col]);
                if (i == col) {
                    sumfirstdiagonal += matrix[i][col];
                }
            }

        }
        for (int row = matrix.length - 1; row >= 0; row--) {

            suseconddiagonal += matrix[row][matrix.length - 1 - row];


        }

        System.out.println(Math.abs(sumfirstdiagonal - suseconddiagonal));
    }


}
