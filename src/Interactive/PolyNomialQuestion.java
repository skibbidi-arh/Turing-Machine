package Interactive;

import EquationClasses.Complex;
import EquationClasses.DurandKerner;

import java.util.Random;

public class PolyNomialQuestion {
    Random rand = new Random();
    Complex[] root;
    double[] values;

    public PolyNomialQuestion() {}

    public void print() {
        PolyNomialGen gen = new PolyNomialGen();
        values= gen.generate();
        System.out.println("Solve Equation");
        for(int i=0;i<values.length-1;i++) {
            System.out.print(values[i]+"x^"+i+"+");
        }
        if(values[values.length-1]>0) {
            System.out.println("+"+values[values.length-1]+"= 0");
        }
        DurandKerner kern = new DurandKerner();
        root= kern.durandKerner(values);
        kern.printRoots(root);
    }

    public static void main(String[] args) {
        PolyNomialQuestion pq = new PolyNomialQuestion();
        pq.print();
    }

}
