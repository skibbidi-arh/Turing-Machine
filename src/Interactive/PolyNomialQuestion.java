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
            DurandKerner kern = new DurandKerner();
            root= kern.durandKerner(values, 1e-12, 1000);
        }

}
