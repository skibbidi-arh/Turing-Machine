package Display;

import EquationClasses.*;

import java.util.Scanner;

public class Display {
    public Display() {}

    private void printBox(String message) {
        // Calculate the width of the box based on the message length
        int width = message.length() + 4;

        // Print the top border with ASCII art pattern for a high-tech feel
        System.out.println("╔" + "═".repeat(width - 2) + "╗");

        // Print the message with borders on the sides, making it stand out
        System.out.println("   " + message + " ");

        // Print the bottom border with the same pattern
        System.out.println("╚" + "═".repeat(width - 2) + "╝");
    }

    private void printLargeBox(String message) {
        // For larger boxes, we'll increase the padding
        int width = message.length() + 6;

        // Print the large top border
        System.out.println("╔" + "═".repeat(width - 2) + "╗");

        // Print the message in the center with extra padding
        System.out.println("   " + message + " ");

        // Print the large bottom border
        System.out.println("╚" + "═".repeat(width - 2) + "╝");
    }

    private void printTitle() {
        // Title Banner
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║              WELCOME TO THE TURING MACHINE             ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }

    public void display() throws TrigonoValueError {
        Scanner in = new Scanner(System.in);

        printTitle();

        printBox("What Do You Want To Do?");
        System.out.println("1. Solve Equation:");
        System.out.println("2. Show Graph:");
        System.out.println("3. Take a quiz:");
        System.out.println("4. Get logarithmic/Trigonometric values ");
        System.out.println("5. Exit");
        System.out.print("Give input: ");
       // in.nextLine();
       // Scanner in2 = new Scanner(System.in);
        int choice = in.nextInt();

        if (choice == 5) {
            printBox("The End");
            return;
        }

        if (choice == 1) {
            printBox("Solving Equation...................................");
            printLargeBox("What type of Equation Do you want to Solve?");
            System.out.println("1. Linear Equation: ");
            System.out.println("2. Polynomial Equation: ");
            System.out.println("3. Mixed Equation: ");
            System.out.println("4. Matrix Solution: ");
            System.out.println("5. Vector Solution: ");
            System.out.println("6. Quadratic trigonometric equation: ");
            System.out.println("7. Exit Program");

            System.out.print("Give input: ");
            int choice2 = in.nextInt();

            if (choice2 == 1) {
                LinearDisplay linear = new LinearDisplay();
                linear.linearDisplay();
            } else if (choice2 == 2) {
                PolynomialDisplay polynomial = new PolynomialDisplay();
                polynomial.displayPolynomial();
            } else if (choice2 == 3) {
                printLargeBox("Input your mixed equation in form of f(x)=0");
                printBox("Only input f(x), you must not print = 0 part");
                String s = in.next();
                BrentsMethod br = new BrentsMethod(s);
                br.answerPrint();
            } else if (choice2 == 4) {
                MatrixDisplay matrixdisplay = new MatrixDisplay();
                matrixdisplay.display();
            } else if (choice2 == 5) {
                VectorDIsplay vector = new VectorDIsplay();
                vector.display();
            } else if (choice2 == 6) {
                QuadraticTrigonometricSolver qs = new QuadraticTrigonometricSolver();
                qs.solve();

            }
            display();
        } else if (choice == 2) {
            System.out.println("1:Linear Graph");
            System.out.println("2:Polynomial Graph");
            System.out.println("3:Trigonometric Graph");
            System.out.println("4: Return");
            int option = in.nextInt();
            GraphDisplay gd = new GraphDisplay();
            gd.display(option);
            display();
        } else if (choice == 3) {
            QuizDisplay quiz = new QuizDisplay();
            quiz.display();
            display();
        } else if (choice == 4) {
            SolutionClass sc = new SolutionClass();
            sc.print();
            display();
        }
    }


}
