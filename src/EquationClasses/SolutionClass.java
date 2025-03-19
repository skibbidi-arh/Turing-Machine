package EquationClasses;
import java.util.Scanner;

public class SolutionClass {
    Scanner sc = new Scanner(System.in);

    public SolutionClass() throws TrigonoValueError {
       // print();
    }

   public void print() throws TrigonoValueError {
        System.out.println("1 - Trigonometric values");
        System.out.println("2 - Logarithmic values");
        System.out.println("0 - Exit");
        scan();
    }

    void scan() throws TrigonoValueError {
        int s = sc.nextInt();
        switch (s) {
            case 1:
                trigonometry();
                break;
            case 2:
                logarithm();
                break;
            case 0:
                System.out.println("Exiting...");
                return;
            default:
                System.out.println("Invalid option. Try again.");
                print();
        }
    }

    void trigonometry() throws TrigonoValueError {
        Trigonometry tr = new Trigonometry();
        System.out.println("1 - sin");
        System.out.println("2 - cos");
        System.out.println("3 - tan");
        System.out.println("4 - cot");
        System.out.println("5 - sec");
        System.out.println("6 - cosec");
        System.out.println("0 - Go back");
        int n = sc.nextInt();

        if (n == 0) {
            print();
            return;
        }

        System.out.println("Enter angle in degrees:");
        double a = sc.nextDouble();

        switch (n) {
            case 1: System.out.println(tr.sin(a)); break;
            case 2: System.out.println(tr.cos(a)); break;
            case 3: System.out.println(tr.tan(a)); break;
            case 4: System.out.println(tr.cot(a)); break;
            case 5: System.out.println(tr.sec(a)); break;
            case 6: System.out.println(tr.cosec(a)); break;
            default: System.out.println("Invalid option");
        }
        trigonometry();
    }

    void logarithm() throws TrigonoValueError {
        System.out.println("1 - Natural Log (ln)");
        System.out.println("2 - Log Base 10 (log10)");
        System.out.println("3 - Log with Custom Base");
        System.out.println("0 - Go back");
        int n = sc.nextInt();

        if (n == 0) {
            print();
            return;
        }

        System.out.println("Enter value:");
        double x = sc.nextDouble();
        double result = 0;

        try {
            switch (n) {
                case 1:
                    result = LogarithmCalculator.ln(x);
                    break;
                case 2:
                    result = LogarithmCalculator.log10(x);
                    break;
                case 3:
                    System.out.println("Enter base:");
                    double base = sc.nextDouble();
                    result = LogarithmCalculator.logBase(x, base);
                    break;
                default:
                    System.out.println("Invalid option");
                    logarithm();
                    return;
            }
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        logarithm();
    }
}
