package EquationClasses;

import java.util.ArrayList;
import java.util.List;

public class CompleteSolve {
    public static List<double[]> completeSolution(double[][] A, double[] b) {
        List<double[]> solutions = new ArrayList<>();
        ParticularSolve ps = new ParticularSolve();
        double[] particular = ps.particularSolution(A, b);
        NullSpace nl = new NullSpace();
        Matrix m= new Matrix(A);
        List<double[]> nullSpace = nl.nullSpace(m);
        solutions.add(particular);
        solutions.addAll(nullSpace);
        return solutions;
    }
}
