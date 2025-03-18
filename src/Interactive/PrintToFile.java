package Interactive;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PrintToFile {
    String Question;
    String Answer;
    public PrintToFile(String Question,String Answer){
           this.Question = Question;
           this.Answer = Answer;
    }
    public PrintToFile() {

    }
    public void printdata(PrintToFile pf) {
        System.out.println(pf.Question);
        System.out.println(pf.Answer);

    }
    public String getData(){
        return Question+"------------"+" \n"+Answer;
    }
    public  void writeStringToFile(String text, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(text);
            System.out.println("String successfully written to " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    public void setQuestion(String question) {
        Question = question;
    }
}

