package SaveFiles;

import java.io.*;

public class QuizNumber {
    private static final String FILE_NAME = "quiz_number.txt";

    public void quizNumberUpdate() {
        int quizNumber = 0;


        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line = reader.readLine();
                if (line != null) {
                    quizNumber = Integer.parseInt(line.trim());
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        }


        quizNumber++;


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(String.valueOf(quizNumber));
            System.out.println("Quiz number updated to: " + quizNumber);
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }




    public  int getLatestQuizNumber() {
        int quizNumber = 0;
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line = reader.readLine();
                if (line != null) {
                    quizNumber = Integer.parseInt(line.trim());
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        }
        return quizNumber;
    }
}

