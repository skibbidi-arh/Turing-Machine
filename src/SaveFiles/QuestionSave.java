package SaveFiles;
import java.util.*;

public class QuestionSave {
    Scanner sc = new Scanner(System.in);

public  void save(int number, String topic,String quizContent){
    System.out.println("Enter name");
    String name =sc.nextLine();
    QuizNumber quizNumber = new QuizNumber();
    quizNumber.quizNumberUpdate();
    int num = quizNumber.getLatestQuizNumber();
    QuizWriter qr = new QuizWriter();
    qr.WriteQuizQuestions(quizContent,num);
  //  qr.readQuiz(num);
    StoreData std = new StoreData();
    std.Store(number,topic,name,num);

}




}
