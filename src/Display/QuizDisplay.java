package Display;

import EquationClasses.Matrix;
import EquationClasses.TrigonoValueError;
import Interactive.*;
import SaveFiles.QuestionSave;

import java.util.Scanner;

public class QuizDisplay {
    QuestionSave qs=new QuestionSave();

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
                System.out.println("Enter your name");
                sc.nextLine();
                String name = sc.nextLine();
                String TotalData = "";
                String topic = "Linear Algebra";
                for (int i = 0; i < 3; i++) {
                    PrintToFile pf = new PrintToFile();
                    LinearQuestion lq = new LinearQuestion(i + 1, pf);
                    lq.generateLinearQuestion();
                    //pf.printdata(pf);
                    TotalData += pf.getData();
                    TotalData += "\n";
                }
                ResultMatcher rm = ResultMatcher.getMatcher();
                System.out.println(rm.getMarks());
                PrintToFile pf = new PrintToFile();
                qs.save(name,rm.getMarks(),topic,TotalData);

               // pf.writeStringToFile(TotalData, "D:/New folder/Turing-Machine/src/Interactive/Data.txt");
                break;
            case 2:
                String TotalData_3 = "";
                for (int i = 0; i < 3; i++) {
                    PrintToFile pf_3 = new PrintToFile();
                    //LinearQuestion lq = new LinearQuestion(i + 1, pf_3);
                    PolyNomialQuestion pq = new PolyNomialQuestion(i+1, pf_3);
                    pq.GeneratePolynomialQuestion();
                    //pf.printdata(pf);
                    TotalData_3 += pf_3.getData();
                    TotalData_3 += "\n";
                }
                ResultMatcher rm_3 = ResultMatcher.getMatcher();
                System.out.println(rm_3.getMarks());
                PrintToFile pf_3 = new PrintToFile();
                pf_3.writeStringToFile(TotalData_3, "D:/New folder/Turing-Machine/src/Interactive/Data.txt");
                break;
            case 3:
                String TotalData_2 = "";
                for (int i = 0; i < 3; i++) {
                    PrintToFile pf_2 = new PrintToFile();
                    VectorQuestion vq = new VectorQuestion(pf_2, i + 1);
                    vq.GenerateOption();
                    TotalData_2 += pf_2.getData();
                    TotalData_2 += "\n";
                }

                PrintToFile pf_2 = new PrintToFile();
                pf_2.writeStringToFile(TotalData_2, "D:/New folder/Turing-Machine/src/Interactive/Data.txt");
                ResultMatcher rm_2 = ResultMatcher.getMatcher();
                System.out.println("Marks: " + rm_2.getMarks());
                break;
        }

    }

}
