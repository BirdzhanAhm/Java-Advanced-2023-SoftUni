/*
1. Fill the Matrix
        Filling a matrix regularly (top to bottom and left to right) is boring. Write two methods that fill a size N x N matrix in
        two different patterns. Both patterns are described below:
*/

import java.util.Scanner;

public class P1FilltheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] menu = scanner.nextLine().split(", ");
        int size = Integer.parseInt(menu[0]);
        String choise = menu[1];
        int[][] matrix = new int[size][size];

        if (choise.equals("A")) {
            //create ert Matrix
            createMatrixa(matrix);

        } else if (choise.equals("B")) {
            // create second type matrix
            creatematrixB(matrix);

        }
        printmatrix(matrix);

    }

    private static void printmatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();
        }
    }

    private static void creatematrixB(int[][] matrix) {
        int count = 1;
        for (int col = 0; col < matrix.length; col++) {
            if ((col + 1) % 2 != 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = count++;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = count++;
                }
            }

        }

    }


    private static void createMatrixa(int[][] matrix) {
        int count = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][i] = count++;
            }

        }
    }

}
