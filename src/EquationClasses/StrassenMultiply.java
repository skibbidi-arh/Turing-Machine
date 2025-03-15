package EquationClasses;


import static EquationClasses.Matrix.add;
import static EquationClasses.Matrix.subtract;

public class StrassenMultiply {
    Matrix matrix1,matrix2;
    public StrassenMultiply(Matrix A, Matrix B) {
        this.matrix1 = A;
        this.matrix2 = B;
    }
    public double[][] Mul() {
        int rowsA = matrix1.getRows();
        int colsA = matrix1.getCols();
        int rowsB = matrix2.getRows();
        int colsB = matrix2.getCols();
        double[][] A= matrix1.getMatrix();
        double[][] B= matrix2.getMatrix();

        int maxSize =Functions.max(Functions.max(rowsA, colsA),Functions.max(rowsB, colsB));
        int paddedSize = nextPowerOfTwo(maxSize);

        double[][] paddedA = padMatrix(A, paddedSize);
        double[][] paddedB = padMatrix(B, paddedSize);

        double[][] paddedResult = strassen_Multiply(paddedA, paddedB);

        return unpadMatrix(paddedResult, rowsA, colsB);
    }
    public double[][] strassen_Multiply(double[][] A, double[][] B) {
        int n = A.length;
        if (n == 1) {

            double[][] C = new double[1][1];
            C[0][0] = A[0][0] * B[0][0];
            return C;
        } else {
            int newSize = n / 2;
            double[][] A11 = new double[newSize][newSize];
            double[][] A12 = new double[newSize][newSize];
            double[][] A21 = new double[newSize][newSize];
            double[][] A22 = new double[newSize][newSize];
            double[][] B11 = new double[newSize][newSize];
            double[][] B12 = new double[newSize][newSize];
            double[][] B21 = new double[newSize][newSize];
            double[][] B22 = new double[newSize][newSize];


            splitMatrix(A, A11, A12, A21, A22);
            splitMatrix(B, B11, B12, B21, B22);


            double[][] M1 = strassen_Multiply(add(A11, A22), add(B11, B22));
            double[][] M2 = strassen_Multiply(add(A21, A22), B11);
            double[][] M3 = strassen_Multiply(A11, subtract(B12, B22));
            double[][] M4 = strassen_Multiply(A22, subtract(B21, B11));
            double[][] M5 = strassen_Multiply(add(A11, A12), B22);
            double[][] M6 = strassen_Multiply(subtract(A21, A11), add(B11, B12));
            double[][] M7 = strassen_Multiply(subtract(A12, A22), add(B21, B22));


            double[][] C11 = add(subtract(add(M1, M4), M5), M7);
            double[][] C12 = add(M3, M5);
            double[][] C21 = add(M2, M4);
            double[][] C22 = add(subtract(add(M1, M3), M2), M6);


            double[][] C = new double[n][n];
            combineMatrix(C, C11, C12, C21, C22);

            return C;
        }
    }
    private static double[][] padMatrix(double[][] matrix, int newSize) {
        int originalRows = matrix.length;
        int originalCols = matrix[0].length;
        double[][] paddedMatrix = new double[newSize][newSize];

        for (int i = 0; i < originalRows; i++) {
            for (int j = 0; j < originalCols; j++) {
                paddedMatrix[i][j] = matrix[i][j];
            }
        }

        return paddedMatrix;
    }
    private static double[][] unpadMatrix(double[][] matrix, int rows, int cols) {
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j];
            }
        }
        return result;
    }

    public static void splitMatrix(double[][] P, double[][] P11, double[][] P12, double[][] P21, double[][] P22) {
        int newSize = P11.length;
        for (int i = 0; i < newSize; i++) {
            for (int j = 0; j < newSize; j++) {
                P11[i][j] = P[i][j];
                P12[i][j] = P[i][j + newSize];
                P21[i][j] = P[i + newSize][j];
                P22[i][j] = P[i + newSize][j + newSize];
            }
        }
    }

    public static void combineMatrix(double[][] P, double[][] P11, double[][] P12, double[][] P21, double[][] P22) {
        int newSize = P11.length;
        for (int i = 0; i < newSize; i++) {
            for (int j = 0; j < newSize; j++) {
                P[i][j] = P11[i][j];
                P[i][j + newSize] = P12[i][j];
                P[i + newSize][j] = P21[i][j];
                P[i + newSize][j + newSize] = P22[i][j];
            }
        }
    }
    private static int nextPowerOfTwo(int n) {
        int power = 1;
        while (power < n) {
            power *= 2;
        }
        return power;
    }


}
