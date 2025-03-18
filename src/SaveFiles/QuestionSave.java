package SaveFiles;

public class QuestionSave {

public  void save(String name,int number, String topic,String quizContent){
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
