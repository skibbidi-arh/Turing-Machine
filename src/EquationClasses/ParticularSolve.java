package EquationClasses;

public class ParticularSolve {
    public ParticularSolve() {}
    public static double[] particularSolution(double[][] A, double[] b) {
        int rows = A.length;
        int cols = A[0].length;
        double[][] augmentedMatrix = new double[rows][cols + 1];


        for (int i = 0; i < rows; i++) {
            System.arraycopy(A[i], 0, augmentedMatrix[i], 0, cols);
            augmentedMatrix[i][cols] = b[i];
        }

        RRef r= new RRef();
        Matrix m = new Matrix(augmentedMatrix);
        Matrix refMatrix = r.rref(m);
        double[][] rrefMatrix = refMatrix.getMatrix();
        double[] solution = new double[cols];


        for (int i = 0; i < rows; i++) {
            if (i < cols) {
                solution[i] = rrefMatrix[i][cols];
            }
        }
        return solution;
    }
}
