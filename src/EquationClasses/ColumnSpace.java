package EquationClasses;

import java.util.ArrayList;
import java.util.List;

public class ColumnSpace {
    public ColumnSpace() {}
    public static List<double[]> columnSpace(Matrix m) {
        RRef r= new RRef();
        double[][] matrix= m.getMatrix();
        Matrix refMatrix = r.rref(m);
        double[][] rrefMatrix= refMatrix.getMatrix();
        List<double[]> colSpaceVectors = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Use original columns that correspond to pivot columns in rref
        for (int j = 0; j < cols; j++) {
            boolean isPivot = false;
            for (int i = 0; i < rows; i++) {
                if (rrefMatrix[i][j] == 1) {
                    isPivot = true;
                    break;
                }
            }
            if (isPivot) {
                double[] column = new double[rows];
                for (int i = 0; i < rows; i++) {
                    column[i] = matrix[i][j];
                }
                colSpaceVectors.add(column);
            }
        }
        return colSpaceVectors;
    }
}
