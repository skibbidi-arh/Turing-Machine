package EquationClasses;

import Graph.TrigonometricGraph;

public class TestUtsho {

    public static void main(String[] args) {


        System.out.println("ln(2): " + EquationClasses.LogarithmCalculator.ln(2));
        System.out.println("log10(100): " + LogarithmCalculator.ln(100));
        System.out.println("logBase(5, 2.5): " + LogarithmCalculator.logBase(5, 2.4));
        TrigonometricGraph graph = new TrigonometricGraph();
        graph.draw();








    }


}
