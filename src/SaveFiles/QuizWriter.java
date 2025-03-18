package SaveFiles;

import java.io.*;

import java.util.Scanner;

public class QuizWriter {

    String q = "Quiz-";

    public  void WriteQuizQuestions(String quizContent, int n) {

        Scanner scanner = new Scanner(System.in);

        File folder = new File("Quizzes");
        if (!folder.exists()) {
            folder.mkdir();
        }
        String fileName = q + n + ".txt";


        File file = new File(folder, fileName);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(quizContent);
           // System.out.println("Quiz content written to file: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file.");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }


    public void readQuiz(int n) {
        File folder = new File("Quizzes");


        String f = "Quiz-"+ n + ".txt";
        File file = new File(folder, f);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }




}
