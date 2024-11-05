package src.EquationClasses;
public class DurandKerner {

    public static Complex[] durandKerner(double[] coefficients, double tolerance, int maxIterations) {
        int n = coefficients.length - 1;
        Complex[] roots = new Complex[n];


        for (int k = 0; k < n; k++) {

            double angle = 2 * Math.PI * k / n;
            roots[k] = new Complex(0.4 * Math.cos(angle), 0.4 * Math.sin(angle));

        }



        for (int iteration = 0; iteration < maxIterations; iteration++) {
            boolean converged = true;
            Complex[] newRoots = new Complex[n];

            for (int k = 0; k < n; k++) {

                Complex numerator = evaluatePolynomial(coefficients, roots[k]);


                Complex denominator = new Complex(1, 0);
                for (int j = 0; j < n; j++) {
                    if (j != k) {

                        denominator = denominator.multiply(roots[k].subtract(roots[j]));
                    }

                }


                newRoots[k] = roots[k].subtract(numerator.divide(denominator));


                if (roots[k].subtract(newRoots[k]).magnitude() > tolerance) {
                    converged = false;
                }

            }


            if (converged) {
                return newRoots;
            }

            roots = newRoots;
        }

        System.out.println("Warning: Max iterations reached without convergence.");
        return roots;
    }

    private static Complex evaluatePolynomial(double[] coefficients, Complex x)
    {
        Complex result = new Complex(coefficients[0], 0);

        for (int i = 1; i < coefficients.length; i++) {
            result = result.multiply(x).add(new Complex(coefficients[i], 0));
        }

        return result;
    }

    public static void main(String[] args) {

        double[] coefficients = {1, 0, 0, -1};


        Complex[] roots = durandKerner(coefficients, 1e-6, 1000);


        System.out.println("Roots found:");

        for (Complex root : roots) {
            System.out.println(root);
        }

    }
}


