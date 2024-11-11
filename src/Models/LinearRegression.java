package src.Models;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;

public class LinearRegression {
    private List<Double> x;
    private List<Double> y;
    private double slope;
    private double intercept;

    public LinearRegression(List<Double> x, List<Double> y) {
        if (x.size() != y.size()) {
            throw new IllegalStateException("Must have equal X and Y data points");
        }
        this.x = x;
        this.y = y;
        calculateCoefficients();
    }

    // Method to calculate slope (m) and intercept (b)
    private void calculateCoefficients() {
        int n = x.size();

        double sumX = x.stream().mapToDouble(Double::doubleValue).sum();
        double sumY = y.stream().mapToDouble(Double::doubleValue).sum();
        double sumXY = IntStream.range(0, n).mapToDouble(i -> x.get(i) * y.get(i)).sum();
        double sumXX = x.stream().mapToDouble(i -> Math.pow(i, 2)).sum();

        slope = (n * sumXY - sumX * sumY) / (n * sumXX - Math.pow(sumX, 2));
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

    // Method to display slope, intercept, and prediction result
    public void prediction(double predictX) {
        System.out.println("Slope (m): " + getSlope());
        System.out.println("Intercept (b): " + getIntercept());
        System.out.println("Predicted value for x = " + predictX + ": " + predict(predictX));
    }


}
