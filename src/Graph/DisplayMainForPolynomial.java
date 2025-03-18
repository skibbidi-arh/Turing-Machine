package Graph;

import Graph.Polynomial_Graph;

import java.util.Scanner;
public class DisplayMainForPolynomial {
    public DisplayMainForPolynomial() {}
    public void graphDisplay() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of polynomials to plot (1 or 2): ");
        int numPolynomials = scanner.nextInt();

        while (numPolynomials < 1 || numPolynomials > 2) {
            System.out.println("Invalid choice. Please enter 1 or 2:");
            numPolynomials = scanner.nextInt();
        }

        Polynomial_Graph graph = new Polynomial_Graph(numPolynomials);
        graph.takeInput();
        graph.plotPolynomials();
        graph.displayGraph();
    }
}
