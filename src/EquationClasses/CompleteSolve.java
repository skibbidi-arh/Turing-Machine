package EquationClasses;

import java.util.ArrayList;
import java.util.List;

public class CompleteSolve {
    public List<double[]> completeSolution(double[][] A, double[] b) {
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
    public void printSolutions(List<double[]> solutions) {
        if (solutions == null || solutions.isEmpty()) {
            System.out.println("No solutions found.");
            return;
        }

        System.out.println("Particular Solution:");
        printArray(solutions.get(0));

        if (solutions.size() > 1) {
            System.out.println("Null Space Solutions:");
            for (int i = 1; i < solutions.size(); i++) {
                printArray(solutions.get(i));
            }
        }
    }

    private static void printArray(double[] array) {
        if (array == null) {
            System.out.println("null");
            return;
        }

        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
