public class ArcsinCalculator {

    // Method to calculate factorial
    public ArcsinCalculator() {

    }
    public  long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    // Method to calculate arcsin using Taylor series
    public double arcsin(double x, int terms) {
        if (x < -1 || x > 1) {
            throw new IllegalArgumentException("x must be in the range -1 to 1");
        }

        double result = 0;
        for (int n = 0; n < terms; n++) {
            long numerator = factorial(2 * n);
            long denominator = (long) (Math.pow(4, n) * Math.pow(factorial(n), 2) * (2 * n + 1));
            double term = (double) numerator / denominator * Math.pow(x, 2 * n + 1);
            result += term;
        }
        return result;
    }


}
