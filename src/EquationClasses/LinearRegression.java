package src.EquationClasses;

public class LinearRegression {
    private double[] x;
    private double[] y;
    private double slope;
    private double intercept;

    public LinearRegression(double[] x, double[] y) {
        this.x = x;
        this.y = y;
        calculateCoefficients();
    }

    // Method to calculate slope (m) and intercept (b)
    private void calculateCoefficients() {
        int n = x.length;

        double sumX = 0.0, sumY = 0.0, sumXY = 0.0, sumXX = 0.0;

        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumXX += x[i] * x[i];
        }

        slope = (n * sumXY - sumX * sumY) / (n * sumXX - sumX * sumX);
        intercept = (sumY - slope * sumX) / n;
    }

    // Method to predict y for a given x value
    public double predict(double x) {
        return slope * x + intercept;
    }

    // Getters for slope and intercept
    public double getSlope() {
        return slope;
    }

    public double getIntercept() {
        return intercept;
    }

}