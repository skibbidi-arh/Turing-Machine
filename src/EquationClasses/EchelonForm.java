package EquationClasses;

//import java.util.Arrays;

public class EchelonForm {
    public EchelonForm() {}
    public Matrix echelonForm(Matrix m) {
        double[][] matrix = m.getMatrix();
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] echelonMatrix = Functions.deepCopy(matrix);

        Matrix result = new Matrix(echelonMatrix);

        int lead = 0;
        for (int r = 0; r < rows; r++) {
            if (lead >= cols) return result;
            int i = r;
            while (echelonMatrix[i][lead] == 0) {
                i++;
                if (i == rows) {
                    i = r;
                    lead++;
                    if (lead == cols) return result;
                }
            }
            double[] temp = echelonMatrix[r];
            echelonMatrix[r] = echelonMatrix[i];
            echelonMatrix[i] = temp;

            double lv = echelonMatrix[r][lead];
            for (int j = 0; j < cols; j++) {
                echelonMatrix[r][j] /= lv;
            }

            for (int k = r + 1; k < rows; k++) {
                double factor = echelonMatrix[k][lead];
                for (int j = 0; j < cols; j++) {
                    echelonMatrix[k][j] -= factor * echelonMatrix[r][j];
                }
            }
            lead++;
        }
        return result;
    }
}
