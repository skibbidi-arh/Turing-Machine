package EquationClasses;
public class LinearSolver {
    private EquationClasses.Matrix coeff,resultant;

    public LinearSolver(EquationClasses.Matrix matrix1, EquationClasses.Matrix matrix2) {
        this.coeff = matrix1;
        this.resultant = matrix2;
    }

    public double[][] solve() {

        EquationClasses.InverseMatrix inm= new EquationClasses.InverseMatrix(coeff);
        inm.invert();
        EquationClasses.StrassenMultiply str= new EquationClasses.StrassenMultiply(inm.getMatrix(),resultant);
        double[][] C= str.Mul();
        for (int i = 0; i < C[0].length; i++) {
            C[0][i] = Functions.precisionController(C[0][i]);
        }
        return C;
    }

}