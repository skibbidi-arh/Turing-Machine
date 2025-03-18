package Interactive;

import EquationClasses.Complex;
import EquationClasses.DurandKerner;

import java.util.Random;

public class PolyNomialQuestion {
    int point =0;
        int question;
        Random rand = new Random();
        Complex[] root;
        double[] values;
        ResultMatcher rm;
        public PolyNomialQuestion(int question,PrintToFile pf) {
            rm= ResultMatcher.getMatcher();
            this.question = question;
            this.pf=pf;
        }
        PrintToFile pf;
        public void GeneratePolynomialQuestion() {
            PolyNomialGen gen = new PolyNomialGen();
            gen.generate();
            double[] roots= gen.getRoots();
            System.out.println("Find the roots of the polynomial Equation:");
            gen.printPolynomial();
            pf.Question = gen.getEntirePolyNomial(question);
            pf.Answer = gen.rootsToString();
            rm.Polynomialcheker(roots,question);
            point = point+ rm.getMarks();
        }
       public int getpoints(){
            return point;
        }
}
