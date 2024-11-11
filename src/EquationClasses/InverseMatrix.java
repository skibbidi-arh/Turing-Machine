package src.EquationClasses;

public class InverseMatrix {
    private Matrix matrix;
    public InverseMatrix(Matrix matrix) {
        this.matrix = matrix;
    }

    public void invert() {
        double[][] A= matrix.getMatrix();
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

        matrix.setMatrix(inverse);
    }

    public Matrix getMatrix() {
        return matrix;
    }
}
