package src.EquationClasses;
public class LinearSolver {
    private Matrix coeff,resultant;

    public LinearSolver(Matrix matrix1, Matrix matrix2) {
        this.coeff = matrix1;
        this.resultant = matrix2;
    }

        public double[][] solve() {

            InverseMatrix inm= new InverseMatrix(coeff);
            inm.invert();
            StrassenMultiply str= new StrassenMultiply(inm.getMatrix(),resultant);
            double[][] C= str.Mul();
        for (int i = 0; i < C[0].length; i++) {
            C[0][i] = Functions.precisionController(C[0][i]);
        }
        return C;
        }

}