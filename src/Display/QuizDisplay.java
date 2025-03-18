
package Display;

import EquationClasses.Matrix;
import EquationClasses.TrigonoValueError;
import Interactive.*;
import SaveFiles.*;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizDisplay {
    Scanner sc = new Scanner(System.in);
    QuestionSave qs=new QuestionSave();

    private static boolean timeUp = false;
    private static int remainingTime = 20 * 60; // 20 minutes in seconds

    public QuizDisplay() {
    }

    public void display() throws TrigonoValueError {

        System.out.println("Choose a Topic: ");
        System.out.println("1. Linear Equation");
        System.out.println("2. Polynomial Equation");
        System.out.println("3. Vector");
        System.out.println("4. Show history");
        System.out.println("5. Show leaderboard");
        System.out.println("6. return");
        int choice = sc.nextInt();

        // Start 20-minute timer
        startTimer();

        switch (choice) {
            case 1:
                runLinearQuiz();
                break;
            case 2:
                runPolynomialQuiz();
                break;
            case 3:
                runVectorQuiz();
                break;
                case 4:
                    showhistory();
                    break;
                    case 5:
                        showLeaderboard();
                        break;

            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }
        display();
    }

    private void startTimer() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (remainingTime <= 0) {
                    timeUp = true;
                    System.out.println("\nTime's up! The quiz has ended.");
                    System.exit(0); // End the program when time is up
                } else {
                    remainingTime--;
                }
            }
        }, 0, 1000); // Update every second
    }

    private void runLinearQuiz() {
        int point=0;
        StringBuilder totalData = new StringBuilder();
        for (int i = 0; i < 3 && !timeUp; i++) {
            PrintToFile pf = new PrintToFile();
            LinearQuestion lq = new LinearQuestion(i + 1, pf);
            lq.generateLinearQuestion();
            System.out.println("Remaining Time: " + (remainingTime / 60) + " min " + (remainingTime % 60) + " sec");
            totalData.append(pf.getData()).append("\n");
            point=point+lq.getpoints();
        }
        //saveResults(totalData.toString());
        qs.save(point,"Linear",totalData.toString());

    }

    private void runPolynomialQuiz() {
        int point=0;
        StringBuilder totalData = new StringBuilder();
        for (int i = 0; i < 3 && !timeUp; i++) {
            PrintToFile pf = new PrintToFile();
            PolyNomialQuestion pq = new PolyNomialQuestion(i + 1, pf);
            pq.GeneratePolynomialQuestion();
            System.out.println("Remaining Time: " + (remainingTime / 60) + " min " + (remainingTime % 60) + " sec");
            totalData.append(pf.getData()).append("\n");
            point=point+pq.getpoints();

        }
        qs.save(point,"Polynomial",totalData.toString());

    }

    private void runVectorQuiz() throws TrigonoValueError {
        StringBuilder totalData = new StringBuilder();
        for (int i = 0; i < 3 && !timeUp; i++) {
            PrintToFile pf = new PrintToFile();
            VectorQuestion vq = new VectorQuestion(pf, i + 1);
            vq.GenerateOption();
            System.out.println("Remaining Time: " + (remainingTime / 60) + " min " + (remainingTime % 60) + " sec");
            totalData.append(pf.getData()).append("\n");
        }
        saveResults(totalData.toString());
    }

    private void saveResults(String data) {
        PrintToFile pf = new PrintToFile();
        pf.writeStringToFile(data, "D:/New folder/Turing-Machine/src/Interactive/Data.txt");
        ResultMatcher rm = ResultMatcher.getMatcher();
        System.out.println("Marks: " + rm.getMarks());
    }


    void  showLeaderboard(){
        sc.nextLine();
        StoreData std=new StoreData();
        System.out.println("Enter topic");
        String topic = sc.nextLine();
        std.showLeaderboard(topic);
    }

    void showhistory(){
        sc.nextLine();
        StoreData std=new StoreData();
        System.out.println("Enter name");
        String name = sc.nextLine();
        std.searchRecords(name);
    }
}