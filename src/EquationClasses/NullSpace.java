package EquationClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NullSpace {
    public NullSpace() {}
    public static List<double[]> nullSpace(Matrix m) {
        RRef r = new RRef();

        Matrix ref= r.rref(m);
        double[][] rrefMatrix = ref.getMatrix();
        int cols = rrefMatrix[0].length;
        int rows = rrefMatrix.length;
        List<double[]> nullSpaceVectors = new ArrayList<>();

        boolean[] pivotColumns = new boolean[cols];
        Arrays.fill(pivotColumns, false);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rrefMatrix[i][j] == 1) {
                    pivotColumns[j] = true;
                    break;
                }
            }
        }

        for (int freeVar = 0; freeVar < cols; freeVar++) {
            if (!pivotColumns[freeVar]) {
                double[] nullVector = new double[cols];
                nullVector[freeVar] = 1;

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (pivotColumns[j] && rrefMatrix[i][j] == 1) {
                            nullVector[j] = -rrefMatrix[i][freeVar];
                        }
                    }
                }
                nullSpaceVectors.add(nullVector);
            }
        }
        return nullSpaceVectors;
    }
}
