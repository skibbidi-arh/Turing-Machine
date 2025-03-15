package Test;



import EquationClasses.LogarithmCalculator;
import Graph.TrigonometricGraph;
import SaveFiles.QuizNumber;
import SaveFiles.QuizWriter;

public class TestUtsho {

    public static void main(String[] args) {

        String quizContent = "Linear Algebra Quiz\n" +
                "____________________\n\n" +
                "Consider the matrix A as shown below.\n\n" +
                "[-3  4  2]\n" +
                "[ 6  3  1]\n" +
                "[ 4 -7 -8]\n\n" +
                "a). Find the inverse of the matrix\n" +
                "b). Determinant of the matrix\n" +
                "c). Determinant of the inverse.";



        QuizNumber quizNumber = new QuizNumber();
        quizNumber.quizNumberUpdate();
        int num = quizNumber.getLatestQuizNumber();
        QuizWriter qr = new QuizWriter();
        qr.WriteQuizQuestions(quizContent,num);
        qr.readQuiz(num);






    }


}

