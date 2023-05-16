/*
5. Maximum Sum of 2X2 Submatrix
        Write a program that reads a matrix from the console. Then find the biggest sum of a 2x2 submatrix. Print thesubmatrix and its sum.
        On the first line, you will get the matrix dimensions in the format "{rows, columns}". On the next lines, you will
        get the elements for each row separated by a comma.

*/

import java.util.Scanner;

public class MaximumSumOf2x2Submatrix05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] alldata = scanner.nextLine().split(", ");
        int row = Integer.parseInt(alldata[0]);
        int col = Integer.parseInt(alldata[1]);
        int[][] matrix = new int[row][col];
        int sum = 0;
        int ielem = 0;
        int jelem = 0;

        for (int i = 0; i < matrix.length; i++) {
            String[] colums = scanner.nextLine().split(", ");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Integer.parseInt(colums[j]);
            }

        }

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                int temp = matrix[i][j] + matrix[i][j + 1] + matrix[i + 1][j] + matrix[i + 1][j + 1];
                if (temp > sum) {
                    sum = temp;
                    ielem = i;
                    jelem = j;
                }
            }

        }


        for (int i = ielem; i < ielem + 1; i++) {
            for (int j = jelem; j < jelem + 1; j++) {
                System.out.println(matrix[i][j] + " " + matrix[i][j + 1]);
                System.out.println(matrix[i + 1][j] + " " + matrix[i + 1][j + 1]);
            }

        }
        System.out.println(sum);
    }
}
