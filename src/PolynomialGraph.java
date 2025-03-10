import java.util.Scanner;

public class PolynomialGraph {
             int degree;
             char[][] graph;
             int centerX;
             int centerY;
             public static final int size = 100;
             double[] coefficients;
             int graphcoordinator[][];
             public PolynomialGraph() {
                 this.graphcoordinator = new int[size][size];
                 for(int i = 0; i < size; i++){
                     for(int j = 0; j < size; j++){
                         this.graphcoordinator[i][j] = 0;
                     }
                 }
             }
    //  Scanner scanner = new Scanner(System.in);

        // Taking necessary inputs for a polynomial equation
    public void takeInput() {
        System.out.println("Enter the degree of the polynomial (2 to 4): ");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        this.degree = input;

        if (degree < 2 || degree > 4) {
            System.out.println("Invalid degree. Only 2 to 4 allowed.");
            return;
        }
        this.takecoefficients(input);
    }
        public void takecoefficients(int input) {
            this.coefficients = new double[degree + 1];
            System.out.println("Enter the coefficients from highest to lowest degree:");
            for (int i = 0; i <= degree; i++) {
                Scanner scanner = new Scanner(System.in);
                coefficients[i] = scanner.nextDouble();
            }
            this.createEmptyGraph();
        }
        public void createEmptyGraph() {
            // Create a 2D character array
           // Fixed size for plotting
            this.graph = new char[size][size];
            this.centerX = size / 2;
            this.centerY = size / 2;

            // Initialize graph with spaces
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    graph[i][j] = ' ';
                }
            }
            this.CreateAxis();
        }
        // Plot axes
        public void CreateAxis() {
            for (int i = 0; i < size; i++) {
                graph[i][centerX] = '.'; // Vertical axis
                graph[centerY][i] = '.'; // Horizontal axis
            }
            this.CreatePolynomial();
        }
        // Plot the polynomial
        public void CreatePolynomial() {
            for (int y = -5; y <= 5; y++) {
                double x = evaluatePolynomial(coefficients, y);
                int plotX = centerX + (int) Math.round(x);
                int plotY = centerY - y;

                if (plotX < 0) plotX = 0;
                if (plotX >= size) plotX = size - 1;
                if (plotY < 0) plotY = 0;
                if (plotY >= size) plotY = size - 1;
                System.out.println("PlotX "+plotX + " PlotY" + plotY);
                int d=0;
                for(int i=0;i<size;i++){
                    if(graph[i][plotX] == '*'){
                        d=1;
                    }
                }
                if(d==0) {
                    graph[plotY][plotX] = '*';
                }
            }
            this.printgraph();
        }

        // Print the graph
        public void printgraph() {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print(graph[i][j] + " ");
                }
                System.out.println();
            }
        }


    private static double evaluatePolynomial(double[] coefficients, double y) {
        double x = 0;
        for (int i = 0; i < coefficients.length; i++) {
            x += coefficients[i] * Math.pow(y, coefficients.length - 1 - i);
        }
        return x;
    }
}
