package EquationClasses;

import java.util.Scanner;

public class DurandKerner {
    Scanner sc = new Scanner(System.in);

    public EquationClasses.Complex[] durandKerner(double[] coefficients, double tolerance, int maxIterations) {
        int n = coefficients.length - 1;
        EquationClasses.Complex[] roots = new EquationClasses.Complex[n];

        // Improved initial root placement with slight perturbation
        for (int k = 0; k < n; k++) {
            double angle = 2 * Math.PI * k / n;
            roots[k] = new EquationClasses.Complex(Math.cos(angle) * 1.1, Math.sin(angle) * 1.1);
        }

        for (int iteration = 0; iteration < maxIterations; iteration++) {
            boolean converged = true;
            EquationClasses.Complex[] newRoots = new EquationClasses.Complex[n];

            for (int k = 0; k < n; k++) {
                EquationClasses.Complex numerator = evaluatePolynomial(coefficients, roots[k]);
                EquationClasses.Complex denominator = new EquationClasses.Complex(1, 0);

                for (int j = 0; j < n; j++) {
                    if (j != k) {
                        EquationClasses.Complex diff = roots[k].subtract(roots[j]);
                        denominator = denominator.multiply(diff.add(new EquationClasses.Complex(1e-12, 0))); // Prevent division by zero
                    }
                }

                newRoots[k] = roots[k].subtract(numerator.divide(denominator));

                if (roots[k].subtract(newRoots[k]).magnitude() > tolerance) {
                    converged = false;
                }
            }

            if (converged) {
                for (int k = 0; k < n; k++) {
                    if (Math.abs(newRoots[k].imag) < 1e-8) {
                        newRoots[k] = new EquationClasses.Complex(newRoots[k].real, 0);
                    }
                }
                return newRoots;
            }

            System.arraycopy(newRoots, 0, roots, 0, n);
        }

        return roots;
    }

    private static EquationClasses.Complex evaluatePolynomial(double[] coefficients, EquationClasses.Complex x) {
        EquationClasses.Complex result = new EquationClasses.Complex(coefficients[0], 0);
        for (int i = 1; i < coefficients.length; i++) {
            result = result.multiply(x).add(new EquationClasses.Complex(coefficients[i], 0));
        }
        return result;
    }

    public void solve(int n) {
        n = n + 1;
        double[] coefficients = new double[n];
        for (int k = 0; k < n - 1; k++) {
            System.out.println("Enter the coefficient of X^" + (n - k - 1) + ":");
            coefficients[k] = sc.nextDouble();
        }
        System.out.println("Enter the constant:");
        coefficients[n - 1] = sc.nextDouble();

        EquationClasses.Complex[] roots = durandKerner(coefficients, 1e-12, 1000);

        System.out.println("Roots found:");
        for (EquationClasses.Complex root : roots) {
            System.out.println(root);
        }
    }
}
