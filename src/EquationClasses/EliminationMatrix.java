package EquationClasses;

public class EliminationMatrix {
    private Matrix[] eliminationMatrices;
    private int size;

    public EliminationMatrix(Matrix matrix) {
        double[][] original = matrix.getMatrix();
        this.size = matrix.getRows();
        this.eliminationMatrices = new Matrix[size - 1];
        performElimination(original);
    }

    private void performElimination(double[][] matrix) {
        double[][] workingMatrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                workingMatrix[i][j] = matrix[i][j];
            }
        }

        for (int k = 0; k < size - 1; k++) {
            double[][] identity = createIdentityMatrix(size);

            for (int i = k + 1; i < size; i++) {
                if (workingMatrix[k][k] == 0) {
                    throw new IllegalArgumentException("Pivot element cannot be zero.");
                }
                double factor = workingMatrix[i][k] / workingMatrix[k][k];
                identity[i][k] = -factor;
                for (int j = 0; j < size; j++) {
                    workingMatrix[i][j] -= factor * workingMatrix[k][j];
                }
            }
            eliminationMatrices[k] = new Matrix(identity);
        }
    }

    private double[][] createIdentityMatrix(int n) {
        double[][] identity = new double[n][n];
        for (int i = 0; i < n; i++) {
            identity[i][i] = 1;
        }
        return identity;
    }

    public Matrix[] getEliminationMatrices() {
        return eliminationMatrices;
    }

    public void printEliminationMatrices() {
        for (int i = 0; i < eliminationMatrices.length; i++) {
            System.out.println("Elimination Matrix " + (i + 1) + ":");
            eliminationMatrices[i].printMatrix();
        }
    }
}
