package Lab02_exer7;

import java.util.Scanner;
import java.util.Arrays;

public class Matrices {
    private int[][] Mat1;
    private int[][] Mat2;

    public Matrices(int[][] Mat1, int [][] Mat2) {
        this.Mat1 = Arrays.stream(Mat1).map(int[]::clone).toArray(int[][]::new);
        this.Mat2 = Arrays.stream(Mat2).map(int[]::clone).toArray(int[][]::new);
    }

    public int[][] sumMat(int row, int col) {
        int[][] result = new int[row][col];
        for(int i=0; i<this.Mat1.length; i++){
            for(int j=0; j<this.Mat1[i].length; j++) result[i][j] = this.Mat1[i][j]+this.Mat2[i][j];
        }

        return result;
    }

    public static void printMatrix(int[][] matrix) {
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++)
                System.out.print(matrix[i][j]+" ");
            System.out.print("\n");
        }
    }

    public static void main(String[] args){
        System.out.println("******* MATRICES SUM ********");
        Scanner scan = new Scanner(System.in);
        int row, col;
        System.out.println("Enter number of rows of 2 matrices: ");
        row = scan.nextInt();
        System.out.println("Enter number of columns 2 matrices: ");
        col = scan.nextInt();

        int[][] Mat1 = new int[row][col];
        int[][] Mat2 = new int[row][col];

        System.out.println("First matrix");
        for(int i=0; i<row; i++){
            System.out.println("Enter row "+(i+1)+" elements: ");
            for(int j=0; j<col; j++) Mat1[i][j] = scan.nextInt();
        }
        printMatrix(Mat1);

        System.out.println("Second matrix");
        for(int i=0; i<row; i++){
            System.out.println("Enter row "+(i+1)+" elements: ");
            for(int j=0; j<col; j++) Mat2[i][j] = scan.nextInt();
        }
        printMatrix(Mat2);

        Matrices sum = new Matrices(Mat1, Mat2);
        System.out.println("Result matrix: ");
        printMatrix(sum.sumMat(row, col));

        System.exit(1);
    }
}