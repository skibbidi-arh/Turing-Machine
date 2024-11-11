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

    public static void main(String[] args) {
        // Sample data
        double[] x = {2, 3, 5, 7, 9, 11, 14};
        double[] y = {4, 5, 7, 10, 15, 20, 40};

        LinearRegression model = new LinearRegression(x, y);

        System.out.println("Slope (m): " + model.getSlope());
        System.out.println("Intercept (b): " + model.getIntercept());

        // Example prediction
        double predictX = 13;
        System.out.println("Predicted y for x = " + predictX + ": " + model.predict(predictX));
    }

}