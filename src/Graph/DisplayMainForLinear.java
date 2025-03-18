package Graph;

import java.util.Scanner;

public class DisplayMainForLinear {
    public void graphDisplay() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 1 for one equation or 2 for two equations: ");
        int choice = scanner.nextInt();
        LinearGraph graph = new LinearGraph();

        if (choice == 1 || choice == 2) {
            for (int i = 0; i < choice; i++) {
                System.out.println("Enter coefficients for equation " + (i + 1) + " (y = mx + c):");
                System.out.print("Enter m: ");
                double m = scanner.nextDouble();
                System.out.print("Enter c: ");
                double c = scanner.nextDouble();
                char symbol = (choice == 1 || i == 0) ? '*' : 'o';
                graph.plotEquation(m, c, symbol);
            }
            graph.displayGraph();
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
