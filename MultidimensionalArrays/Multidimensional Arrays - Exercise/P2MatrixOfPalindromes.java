/*
2. Matrix of Palindromes
        Write a program to generate the following matrix of palindromes of 3 letters with r rows and c columns like the one
        in the examples below.
        • Rows define the first and the last letter: row 0 -> ‘a’, row 1 -> ‘b’, row 2 -> ‘c’, …
        • Columns + rows define the middle letter:
        o column 0, row 0 -> ‘a’, column 1, row 0 -> ‘b’, column 2, row 0 -> ‘c’, …
        o column 0, row 1 -> ‘b’, column 1, row 1 -> ‘c’, column 2, row 1 -> ‘d’, …
        Input
        • The numbers r and c stay in the first line at the input.
        •  r and c are integers in the range [1…26].
        •  r + c ≤ 27
*/

import java.util.Scanner;

public class P2MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] alldata = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(alldata[0]);
        int cols = Integer.parseInt(alldata[1]);

        String[][] polimatrix = new String[rows][cols];


        fillMatrix(polimatrix);
        printPolimatrixx(polimatrix);


    }

    private static void fillMatrix(String[][] polimatrix) {
        for (int i = 0; i < polimatrix.length; i++) {
            for (int j = 0; j < polimatrix[i].length; j++) {
                char outsiteLeter = (char) ('a' + i);
                char ihnenLeter = (char) ('a' + i + j);
                polimatrix[i][j] = "" + outsiteLeter + ihnenLeter + outsiteLeter;

            }

        }
    }

    private static void printPolimatrixx(String[][] polimatrix) {
        for (int i = 0; i < polimatrix.length; i++) {
            for (int j = 0; j < polimatrix[i].length; j++) {
                System.out.print(polimatrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
