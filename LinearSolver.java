public class LinearSolver {
    private double[][] linearCoefficients;
    private double[][] linearRHS;

    public LinearSolver(double[][] coefficients, double[][] rhs) {
        this.linearCoefficients = coefficients;
        this.linearRHS = rhs;
    }

        public static double[][] solve(double[][] A, double[][] b) {
        double[][] C = new double[A.length][1];
        C= Matrix.strassenMultiply(Matrix.invert(A),b);
        return C;
        }

}