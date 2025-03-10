import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinearGraph graphCreator = new LinearGraph(sc.nextInt(), sc.nextInt(), sc.nextInt());
        graphCreator.Display_graph();
            PolynomialGraph pg = new PolynomialGraph();
            pg.takeInput();

    }
}