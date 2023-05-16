import java.util.Scanner;

public class CompareMatrices01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] regs = scanner.nextLine().split("\\s+");
        int row1 = Integer.parseInt(regs[0]);
        int colm1 = Integer.parseInt(regs[1]);
        int[][] firstMatrix = new int[row1][colm1];

        for (int i = 0; i < firstMatrix.length; i++) {
            String[] rowsnum = scanner.nextLine().split(" ");
            for (int j = 0; j < firstMatrix[0].length; j++) {
                firstMatrix[i][j] = Integer.parseInt(rowsnum[j]);

            }
        }// End Read For cycle

/*        for (int i = 0; i < row1; i++) { //Print firstMatrix
            for (int j = 0; j < colm1; j++) {
                System.out.print(firstMatrix[i][j] + " ");
            }
            System.out.println();
        }*/
//Intialization SecondArray
        regs = scanner.nextLine().split("\\s+");
        int secRows = Integer.parseInt(regs[0]);
        int secColms = Integer.parseInt(regs[1]);
        int[][] secondMatrix = new int[secRows][secColms];
//Input Second Array
        for (int i = 0; i < secRows; i++) {
            String[] parts = scanner.nextLine().split("\\s+");
            for (int j = 0; j < secColms; j++) {
                secondMatrix[i][j] = Integer.parseInt(parts[j]);
            }
        }
/*
//Print SecondArray
        for (int i = 0; i < secRows; i++) {
            for (int j = 0; j < secColms; j++) {
                System.out.print(secondMatrix[i][j] + " ");
            }
            System.out.println();
        }
*/


                if (row1!=secRows||colm1!=secColms) {
                    System.out.println("not equal");
                    return;
                }
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < colm1; j++) {
                if (firstMatrix[i][j]!=secondMatrix[i][j]){
                    System.out.println("not equal");
                }
            }

        }
        System.out.println("equal");
    }
}
