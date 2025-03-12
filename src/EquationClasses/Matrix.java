package EquationClasses;
import java.util.Arrays;
import java.util.Scanner;

public class Matrix {
    private int rows;
    private int cols;
    private double[][] matrix;
    private Scanner sc = new Scanner(System.in);

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = new double[rows][cols];
        matrixInput();
    }

    public Matrix(double[][] matrixx) {
        this.matrix = matrixx;
        this.rows = matrixx.length;
        this.cols = matrixx[0].length;
    }
    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
        this.rows = matrix.length;
        this.cols = matrix[0].length;
    }

    public static double[][] add(double[][] A, double[][] B) {
        int n = A.length;
        double[][] C = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    public static double[][] subtract(double[][] A, double[][] B) {
        int n = A.length;
        double[][] C = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        return C;
    }

    public void printMatrix() {
        for (double[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public void matrixInput() {
        for (int i = 0; i < rows; i++) {
            System.out.println("Enter row number " + (i + 1) + ":");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextDouble();
            }
        }
    }
}
