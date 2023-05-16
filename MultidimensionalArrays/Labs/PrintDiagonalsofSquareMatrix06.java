/*
6. Print Diagonals of Square Matrix
        Write a program that reads a matrix from the console. Then print the diagonals. The matrix will always be square. On
        the first line, you read a single integer N the matrix size. Then on each line N elements. The first diagonal should always
        start with the element at the first row and col. The second diagonal should start with the element at the last row and
        first col.
*/

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsofSquareMatrix06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][];

        for (int i = 0; i < size; i++) {
            int[] curentrow = new int[size];
            String[] columdata = scanner.nextLine().split(" ");

            int[] curentRow = Arrays.stream(columdata).mapToInt(elem -> Integer.parseInt(elem)).toArray();
            matrix[i] = curentRow;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j)
                    System.out.print(matrix[i][j] + " ");

            }

        }
        System.out.println();
        for (int row = size - 1, col = 0; col < size; row--, col++) {
            System.out.print(matrix[row][col] + " ");

        }
    }
}
