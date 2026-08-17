/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.Scanner;

// Custom exception for dimension mismatch
class MatrixMismatchException extends Exception {
    public MatrixMismatchException(String message) {
        super(message);
    }
}

public class Main{

  
    public static int[][] multiplyMatrices(int[][] a, int[][] b) throws MatrixMismatchException {
        int rowsA = a.length;
        int colsA = a[0].length;
        int rowsB = b.length;
        int colsB = b[0].length;

        if (colsA != rowsB) {
            throw new MatrixMismatchException("Error: Columns of Matrix A (" + colsA + 
                ") do not match Rows of Matrix B (" + rowsB + ").");
        }

        
        int[][] result = new int[rowsA][colsB];

       
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }

    
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
           
            System.out.print("Enter rows and columns of Matrix A: ");
            int rowsA = sc.nextInt();
            int colsA = sc.nextInt();
            int[][] a = new int[rowsA][colsA];

            System.out.println("Enter elements of Matrix A:");
            for (int i = 0; i < rowsA; i++) {
                for (int j = 0; j < colsA; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            System.out.print("Enter rows and columns of Matrix B: ");
            int rowsB = sc.nextInt();
            int colsB = sc.nextInt();
            int[][] b = new int[rowsB][colsB];

            System.out.println("Enter elements of Matrix B:");
            for (int i = 0; i < rowsB; i++) {
                for (int j = 0; j < colsB; j++) {
                    b[i][j] = sc.nextInt();
                }
            }

         
            int[][] result = multiplyMatrices(a, b);

            System.out.println("Resultant Matrix:");
            printMatrix(result);

        } catch (MatrixMismatchException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input format.");
        } finally {
            sc.close();
        }
    }
}
