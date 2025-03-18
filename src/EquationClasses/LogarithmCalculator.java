package EquationClasses;

public class LogarithmCalculator {


    public static double ln(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("x must be positive");
        }


        int n = 0;
        while (x > 2) {
            x /= 2;
            n++;
        }

        double y = (x - 1) / (x + 1);
        double result = 0.0;
        double term = y;
        double ySquared = y * y;
        int i = 1;

        while (Math.abs(term) > 1e-10) {
            result += term / i;
            term *= ySquared;
            i += 2;
        }

        return 2 * result + n * 0.69314718056; // Approximation for ln(2)
    }


    public static double log10(double x) {
        return ln(x) / ln(10);
    }


    public static double logBase(double x, double base) {
        if (x <= 0 || base <= 0 || base == 1) {
            throw new IllegalArgumentException("x and base must be positive and base cannot be 1");
        }
        return ln(x) / ln(base);
    }


}

