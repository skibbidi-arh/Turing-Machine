package EquationClasses;
import java.util.Arrays;

public class Matrix {
    private int row, column;
    private double[][] matrix;

    Matrix(int row, int column) {
        matrix = new double[row][column];
    }

    public static double[][] strassenMultiply(double[][] A, double[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int rowsB = B.length;
        int colsB = B[0].length;

        int maxSize = Functions.max(Functions.max(rowsA, colsA), Functions.max(rowsB, colsB));
        int paddedSize = nextPowerOfTwo(maxSize);

        double[][] paddedA = padMatrix(A, paddedSize);
        double[][] paddedB = padMatrix(B, paddedSize);

        double[][] paddedResult = strassen_Multiply(paddedA, paddedB);

        return unpadMatrix(paddedResult, rowsA, colsB);
    }


    public static double[][] strassen_Multiply(double[][] A, double[][] B) {
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

    private static int nextPowerOfTwo(int n) {
        int power = 1;
        while (power < n) {
            power *= 2;
        }
        return power;
    }

    public static double[][] invert(double[][] A) {
        int n = A.length;
        double[][] augmentedMatrix = new double[n][2 * n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                augmentedMatrix[i][j] = A[i][j];
            }
            augmentedMatrix[i][i + n] = 1;
        }

        for (int i = 0; i < n; i++) {
            if (augmentedMatrix[i][i] == 0) {
                for (int j = i + 1; j < n; j++) {
                    if (augmentedMatrix[j][i] != 0) {
                        double[] temp = augmentedMatrix[i];
                        augmentedMatrix[i] = augmentedMatrix[j];
                        augmentedMatrix[j] = temp;
                        break;
                    }
                }
            }

            double diagElement = augmentedMatrix[i][i];
            for (int j = 0; j < 2 * n; j++) {
                augmentedMatrix[i][j] /= diagElement;
            }

            for (int j = 0; j < n; j++) {
                if (i != j) {
                    double factor = augmentedMatrix[j][i];
                    for (int k = 0; k < 2 * n; k++) {
                        augmentedMatrix[j][k] -= factor * augmentedMatrix[i][k];
                    }
                }
            }
        }

        double[][] inverse = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverse[i][j] = augmentedMatrix[i][j + n];
            }
        }

        return inverse;
    }


    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }
}

