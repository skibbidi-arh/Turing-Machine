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

    public static void main(String[] args) throws InterruptedException {
        TimerClass timer = new TimerClass();
        timer.starttimer(10);
    }
}
