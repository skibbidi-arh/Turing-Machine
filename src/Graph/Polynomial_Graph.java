package Graph;

import java.util.Scanner;

public class Polynomial_Graph {
    private static final int SIZE = 61; // Defines a 41x41 grid (including axes)
    private char[][] graph;
    private int numberOfEquations;
    private double[][] coefficients;

    public Polynomial_Graph(int numberOfEquations) {
        this.numberOfEquations = numberOfEquations;
        this.coefficients = new double[numberOfEquations][];
        this.graph = new char[SIZE][SIZE];
        initializeGraph();
    }

    private void initializeGraph() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                graph[i][j] = '.'; // Empty space
            }
        }
        drawAxes();
    }

    private void drawAxes() {
        int center = SIZE / 2;
        for (int i = 0; i < SIZE; i++) {
            graph[i][center] = '|'; // Y-axis
            graph[center][i] = '-'; // X-axis
        }
        graph[center][center] = '+'; // Origin
    }

    public void takeInput() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < numberOfEquations; i++) {
            System.out.println("Enter the degree of polynomial " + (i + 1) + " (2 to 4): ");
            int degree = scanner.nextInt();
            while (degree < 2 || degree > 4) {
                System.out.println("Invalid degree. Only 2 to 4 allowed. Try again:");
                degree = scanner.nextInt();
            }

            coefficients[i] = new double[degree + 1];
            System.out.println("Enter the coefficients from highest to lowest degree:");
            for (int j = 0; j <= degree; j++) {
                coefficients[i][j] = scanner.nextDouble();
            }
        }
    }

    public void plotPolynomials() {
        char[] symbols = {'*', 'o', '$', '@'}; // Different symbols for different equations
        for (int eq = 0; eq < numberOfEquations; eq++) {
            for (int x = -20; x <= 20; x+=1) { // Extended range
                double y = evaluatePolynomial(coefficients[eq], x);
                int roundedY = (int) Math.round(y);

                // Only plot points that fit within graph limits
                if (roundedY >= -20 && roundedY <= 20) {
                    int plotX = (int)x + SIZE / 2;
                    int plotY = (SIZE / 2) - roundedY;

                    if (plotX >= 0 && plotX < SIZE && plotY >= 0 && plotY < SIZE) {
                        graph[plotY][plotX] = symbols[eq % symbols.length]; // Assign symbol
                    }
                }
            }
        }
    }

    public void displayGraph() {
        for (char[] row : graph) {
            for (char cell : row) {
                if(cell == '|'){
                    System.out.print("\033[40m|\033[0m"+" ");
                }
                else if(cell == '-'){
                    System.out.print("\033[40m-\033[0m"+" ");
                }
                else if(cell == '*'){
                    System.out.print("\033[31m*\033[0m"+" ");
                }
                else if(cell == 'o'){
                    System.out.print("\033[33mo\033[0m"+" ");
                }
                else {
                    System.out.print(cell + " ");
                }
            }
            System.out.println();

        }
    }

    private static double evaluatePolynomial(double[] coefficients, double x) {
        double result = 0;
        for (int i = 0; i < coefficients.length; i++) {
            result += coefficients[i] * Math.pow(x, coefficients.length - 1 - i);
        }
        return result;
    }
}
