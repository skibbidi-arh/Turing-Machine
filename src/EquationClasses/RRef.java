package EquationClasses;

//import java.util.Arrays;

public class RRef {
    public RRef(){}
    public Matrix rref(Matrix m) {
        double[][] matrix= m.getMatrix();
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] rrefMatrix = Functions.deepCopy(matrix);
        Matrix ref= new Matrix(rrefMatrix);

        int lead = 0;
        for (int r = 0; r < rows; r++) {
            if (lead >= cols) return ref;
            int i = r;
            while (rrefMatrix[i][lead] == 0) {
                i++;
                if (i == rows) {
                    i = r;
                    lead++;
                    if (lead == cols) return ref;
                }
            }
            double[] temp = rrefMatrix[r];
            rrefMatrix[r] = rrefMatrix[i];
            rrefMatrix[i] = temp;

            double lv = rrefMatrix[r][lead];
            for (int j = 0; j < cols; j++) {
                rrefMatrix[r][j] /= lv;
            }

            for (int k = 0; k < rows; k++) {
                if (k != r) {
                    double factor = rrefMatrix[k][lead];
                    for (int j = 0; j < cols; j++) {
                        rrefMatrix[k][j] -= factor * rrefMatrix[r][j];
                    }
                }
            }
            lead++;
        }
        return ref;
    }

}
