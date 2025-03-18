package Interactive;

import EquationClasses.Functions;

import java.util.Random;

public class PolyNomialGen {
    private Random rand = new Random();
    private double[] roots;
    private double[] coefficients;

    public PolyNomialGen() {
    }

    public double[] generate() {
        int highestPower = rand.nextInt(2, 5);
        coefficients = new double[highestPower + 1];
        roots = new double[highestPower];

        for (int i = 0; i < highestPower; i++) {
            roots[i] = rand.nextInt(20) * (rand.nextBoolean() ? 1 : -1);
        }

        Functions.bubbleSort(roots);

        coefficients[0] = 1;
        for (int i = 1; i <= highestPower; i++) {
            coefficients[i] = 0;
        }

        for (double root : roots) {
            for (int i = highestPower; i > 0; i--) {
                coefficients[i] = coefficients[i] - root * coefficients[i - 1];
            }
            coefficients[0] *= -root;
        }

        return coefficients;
    }

    public double[] getRoots() {
        return roots;
    }
}
