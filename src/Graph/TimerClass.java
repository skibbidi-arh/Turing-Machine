package Graph;

public class TimerClass extends Thread {

    public void starttimer(int time) throws InterruptedException {
        time-=1;
            while(time>=0){
                System.out.print("\r Timer remaining :"+time);
                time--;
                    Thread.sleep(1000);
            }
        System.out.println("\r Times Up!!!!!!");
    }
}
