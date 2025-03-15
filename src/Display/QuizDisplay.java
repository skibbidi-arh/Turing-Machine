package Display;

import EquationClasses.Matrix;
import EquationClasses.TrigonoValueError;
import Interactive.LinearQuestion;
import Interactive.ResultMatcher;
import Interactive.VectorQuestion;

import java.util.Scanner;

public class QuizDisplay {

    public QuizDisplay() {
    }
    public void display() throws TrigonoValueError {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a Topic: ");
        System.out.println("1.Linear Equation: ");
        System.out.println("2.Polynomial Equation: ");
        System.out.println("3.Vector: ");
        int choice= sc.nextInt();

        switch(choice) {
            case 1:

                for(int i=0;i<3;i++)
                {
                    LinearQuestion lq = new LinearQuestion();
                    lq.generateLinearQuestion();
                }
                break;
            case 2:
                break;
            case 3:

                for(int i=0;i<3;i++)
                {
                    VectorQuestion vq = new VectorQuestion();
                    vq.GenerateOption();
                }

        }
        ResultMatcher rm= ResultMatcher.getMatcher();
        System.out.println("Marks: "+ rm.getMarks());
    }

}
