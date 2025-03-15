package EquationClasses;

import java.util.Scanner;

public class QuadraticTrigonometricSolver {

    public  void solve() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter coefficients a, b, c, d, e  for the format aSin^2(x) + bCos^2(x) + cSin(x) + dCos(x) + e = 0");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double d = scanner.nextDouble();
        double e = scanner.nextDouble();

        solveQuadraticTrig(a, b, c, d, e);

        scanner.close();
    }

    public static void solveQuadraticTrig(double a, double b, double c, double d, double e) {
        // Convert to quadratic form using sin^2(x) + cos^2(x) = 1
        // Express everything in terms of sin(x) or cos(x)

        double A = a - b;  // Coefficient of sin^2(x) (since cos^2(x) = 1 - sin^2(x))
        double B = c;       // Coefficient of sin(x)
        double C = e - b;   // Constant term after substitution

        System.out.println("Solving in terms of sin(x)...");
        solveQuadraticTrigEquation(A, B, C, "sin");

        // Convert the equation to cos(x) form
        A = b - a;  // Coefficient of cos^2(x)
        B = d;      // Coefficient of cos(x)
        C = e - a;  // Constant term after substitution

        System.out.println("Solving in terms of cos(x)...");
        solveQuadraticTrigEquation(A, B, C, "cos");
    }

    public static void solveQuadraticTrigEquation(double a, double b, double c, String func) {
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            System.out.println("No real solutions");
            return;
        }

        double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);

        System.out.println("Possible values of " + func + "(x): " + root1 + ", " + root2);

        findAngles(root1, func);
        findAngles(root2, func);
    }

    public static void findAngles(double value, String func) {
        if (value < -1 || value > 1) {
            System.out.println("No valid angle for " + func + "(x) = " + value);
            return;
        }

        double angle = Math.toDegrees(Math.asin(value));
        if (func.equals("cos")) {
            angle = Math.toDegrees(Math.acos(value));
        }

        System.out.println("General solutions for " + func + "(x) = " + value + ":");
        System.out.println("x = " + angle + " + 360k, or x = " + (180 - angle) + " + 360k (for sin)");
        if (func.equals("cos")) {
            System.out.println("x = ±" + angle + " + 360k");
        }
    }
}
