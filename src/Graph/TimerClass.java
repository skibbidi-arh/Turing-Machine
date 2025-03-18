package Graph;

import java.util.Scanner;

public class TimerClass extends Thread {
    private volatile boolean running = true;
    private int remainingTime;

    public void startTimer(int time) throws InterruptedException {
        remainingTime = time - 1;
        Scanner scanner = new Scanner(System.in);

        Thread inputThread = new Thread(() -> {
            while (true) {
                if (scanner.nextInt() == 1) {
                    stopTimer();
                    break;
                }
            }
        });
        inputThread.start();

        while (remainingTime >= 0 && running) {
            System.out.print("\r Timer remaining :" + remainingTime);
            Thread.sleep(1000);
            remainingTime--;
        }
        if (running) {
            System.out.println("\r Time sesh");
        } else {
            System.out.println("\r Time saved " + remainingTime );
        }
    }

    public void stopTimer() {
        running = false;
    }

    public int getRemainingTime() {
        return remainingTime;
    }
}
