package Display;

import java.util.Scanner;

public class Display {
    public Display() {}

    public void display() {
        Scanner in = new Scanner(System.in);

        System.out.println("What Do You Want To Do?");
        System.out.println("1. Solve Equation:");
        System.out.println("2. Play A Game:");
        System.out.println("3. Take a quiz:");
        System.out.println("4. Exit");
        System.out.println("Give input: ");
        int choice = in.nextInt();
        if(choice == 4) {
            System.out.println("The End");
            return ;
        }
        if (choice == 1) {
            System.out.println("Solving Equation...................................");
            System.out.println("What type of Equation Do you want to Solve? ");
            System.out.println("1.Linear Equation: ");
            System.out.println("2.Polynomial Equation: ");
            System.out.println("3.Mixed Equation: ");
            System.out.println("4.Exit Program");
            System.out.println("Give input: ");
            int choice2 = in.nextInt();
            if(choice2 == 1) {
                LinearDisplay linear = new LinearDisplay();
                linear.linearDisplay();
            }
            else if(choice2 == 2) {
                PolynomialDisplay polynomial = new PolynomialDisplay();
                polynomial.displayPolynomial();
            }
        }
        else if (choice == 2) {
        }
    }
}
