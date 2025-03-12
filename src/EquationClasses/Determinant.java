package EquationClasses;

public class Determinant {
    private double determinantValue;

    public Determinant(Matrix matrix) {
        if (matrix.getRows() != matrix.getCols()) {
            throw new IllegalArgumentException("Determinant is only defined for square matrices!");
        }
        this.determinantValue = computeDeterminant(matrix.getMatrix());
    }

    public double getDeterminantValue() {
        return determinantValue;
    }

    private double computeDeterminant(double[][] mat) {
        int n = mat.length;
        if (n == 1) {
            return mat[0][0];
        }
        if (n == 2) {
            return (mat[0][0] * mat[1][1]) - (mat[0][1] * mat[1][0]);
        }

        double det = 0;
        for (int col = 0; col < n; col++) {
            double[][] subMatrix = getSubMatrix(mat, 0, col);
            det += mat[0][col] * computeDeterminant(subMatrix) * ((col % 2 == 0) ? 1 : -1);
        }
        return det;
    }

    private double[][] getSubMatrix(double[][] mat, int excludingRow, int excludingCol) {
        int n = mat.length;
        double[][] subMat = new double[n - 1][n - 1];
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (i == excludingRow) continue;
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (j == excludingCol) continue;
                subMat[r][c] = mat[i][j];
                c++;
            }
            r++;
        }
        return subMat;
    }

    public void printDeterminant() {
        System.out.println("Determinant: " + determinantValue);
    }
}
