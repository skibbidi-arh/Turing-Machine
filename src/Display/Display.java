package Display;

import EquationClasses.BrentsMethod;
import EquationClasses.Matrix;
import EquationClasses.TrigonoValueError;

import java.util.Scanner;

public class Display {
    public Display() {}

    public void display() throws TrigonoValueError {
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
            System.out.println("4.Matrix Solution: ");
            System.out.println("5.Vector Solution: ");
            System.out.println("6.Exit Program");
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
            else if(choice2 == 3) {
                System.out.println("Input equation:");
                System.out.println("Equation should be like in a for f(x)=0 but you dont have to write the part (=0), just input f(x)");
                String s= in.next();
                BrentsMethod br= new BrentsMethod(s);
                br.answerPrint();
            }
            else if(choice2 == 4) {
                MatrixDisplay matrixdisplay = new MatrixDisplay();
                matrixdisplay.display();
            }
            else if(choice2 == 5) {
                VectorDIsplay vector = new VectorDIsplay();
                vector.display();
            }
        }
        else if (choice == 2) {
        }
        else if (choice == 3) {
            QuizDisplay quiz = new QuizDisplay();
            quiz.display();
        }
    }
}
