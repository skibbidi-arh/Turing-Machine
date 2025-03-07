import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TrigonometricGraph gc = new TrigonometricGraph();
        gc.EmptyGraphCreator();
        Scanner sc = new Scanner(System.in);
        Scanner number = new Scanner(System.in);
        String verdict;
        verdict = "YES";
//        while(verdict.equals("YES")) {
//            System.out.println("Enter the coefficient of the graph and constant");
//            int x_num = number.nextInt();
//            int y_num = number.nextInt();
//            int constant = number.nextInt();
//            char symbol = sc.nextLine().charAt(0);
//            Graph_Creator.plotdata(x_num, y_num , constant,symbol);
//            Graph_Creator.showgraph();
//            System.out.println("Do you want to plot data? (Y/N)");
//            verdict = sc.nextLine();
//        }
        while(verdict.equals("YES")) {
            System.out.println("Enter the coefficient of the graph and constant");
            int x_num = number.nextInt();
            int y_num = number.nextInt();
            int constant = number.nextInt();
            char symbol = sc.nextLine().charAt(0);
            TrigonometricGraph.plotdata(x_num, y_num , constant,symbol);
            TrigonometricGraph.showgraph();
            System.out.println("Do you want to plot data? (Y/N)");
            verdict = sc.nextLine();
        }

        System.out.println("This is has worked perfectly");

    }
}