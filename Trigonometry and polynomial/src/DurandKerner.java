public class DurandKerner {

    public static Complex[] durandKerner(double[] coefficients, double tolerance, int maxIterations) {
        int n = coefficients.length - 1;
        Complex[] roots = new Complex[n];

        // Initial guess: distribute roots around a circle in the complex plane
        for (int k = 0; k < n; k++) {

            double angle = 2 * Math.PI * k / n;
            roots[k] = new Complex(0.4 * Math.cos(angle), 0.4 * Math.sin(angle));

        }



        for (int iteration = 0; iteration < maxIterations; iteration++) {
            boolean converged = true;
            Complex[] newRoots = new Complex[n];

            for (int k = 0; k < n; k++) {
                // Evaluate the polynomial at roots[k]
                Complex numerator = evaluatePolynomial(coefficients, roots[k]);

                // Compute the denominator as the product of (roots[k] - roots[j]) for j ≠ k
                Complex denominator = new Complex(1, 0);
                for (int j = 0; j < n; j++) {
                    if (j != k) {
                        denominator = denominator.multiply(roots[k].subtract(roots[j]));
                    }
                }

                // Update the k-th root
                newRoots[k] = roots[k].subtract(numerator.divide(denominator));

                // Check if the root has converged
                if (roots[k].subtract(newRoots[k]).magnitude() > tolerance) {
                    converged = false;
                }
            }

            // If all roots have converged, exit
            if (converged) {
                return newRoots;
            }

            roots = newRoots;
        }







    }
}