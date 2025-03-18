package EquationClasses;

public class LUdecompose {
    private double[][] lower;
    private double[][] upper;
    Matrix upperMatrix;
    Matrix lowerMatrix;
    private int size;

    public LUdecompose(Matrix matrix) {
        double[][] original = matrix.getMatrix();
        this.size = matrix.getRows();
        this.lower = new double[size][size];
        this.upper = new double[size][size];
        decompose(original);
        this.upperMatrix = new Matrix(this.upper);
        this.lowerMatrix = new Matrix(this.lower);
    }

    private void decompose(double[][] matrix) {
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                double sum = 0;
                for (int k = 0; k < i; k++) {
                    sum += lower[i][k] * upper[k][j];
                }
                upper[i][j] = matrix[i][j] - sum;
            }

            for (int j = i; j < size; j++) {
                if (i == j) {
                    lower[i][i] = 1;
                } else {
                    double sum = 0;
                    for (int k = 0; k < i; k++) {
                        sum += lower[j][k] * upper[k][i];
                    }
                    lower[j][i] = (matrix[j][i] - sum) / upper[i][i];
                }
            }
        }
    }

    public Matrix getLowerMatrix() {
        return new Matrix(lower);
    }

    public Matrix getUpperMatrix() {
        return new Matrix(upper);
    }

    public void printLower() {
        System.out.println("Lower Matrix:");
        new Matrix(lower).printMatrix();
    }

    public void printUpper() {
        System.out.println("Upper Matrix:");
        new Matrix(upper).printMatrix();
    }

    public double[][] getLower() {
        return lower;
    }
    public double[][] getUpper() {
        return upper;
    }
    public Matrix getupMatrix() {
        return upperMatrix;
    }
    public Matrix getlowMatrix() {
        return lowerMatrix;
    }
}
