package src.EquationClasses;

import java.util.Scanner;

public class TrigoGraph {

    private static final double PI = 3.14159265;

    public void headline() {
        System.out.println("\t\t\t\t********************************");
        System.out.println("\t\t\t\tGraphs of Trigonometric equations");
        System.out.println("\t\t\t\t********************************");
    }

    public void draw(int choice) {
        final int width = 80;  // Width of the terminal graph
        final int height = 20; // Height of the terminal graph
        final double scaleX = 2 * PI / width; // Horizontal scaling for radians
        final double scaleY = 10;             // Vertical scaling factor

        char[][] grid = new char[height][width];

        // Initialize grid with spaces
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = ' ';
            }
        }

        axis(grid);

        for (int i = 0; i < width; i++) {
            double x = (i - width / 2) * scaleX; // Map column to x value
            double y;

            switch (choice) {
                case 1:
                    y = sine(x);
                    break;
                case 2:
                    y = cosine(x);
                    break;
                case 3:
                    y = tangent(x);
                    break;
                case 4:
                    y = reciprocal(sine(x));
                    break;
                case 5:
                    y = reciprocal(cosine(x));
                    break;
                case 6:
                    y = reciprocal(tangent(x));
                    break;
                default:
                    return;
            }

            // Map y to grid coordinates
            int row = height / 2 - (int) (y * scaleY);
            if (row >= 0 && row < height) {
                grid[row][i] = '*';
            }
        }

        displayGrid(grid);
    }

    public void axis(char[][] grid) {
        int width = 80;
        int height = 20;

        // Draw horizontal axis
        for (int i = 0; i < width; i++) {
            grid[height / 2][i] = '-';
        }

        // Draw vertical axis
        for (int i = 0; i < height; i++) {
            grid[i][width / 2] = '|';
        }

        // Draw origin
        grid[height / 2][width / 2] = '+';
    }

    public void displayGrid(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    private double sine(double x) {
        double term = x, sum = x;
        for (int i = 1; i <= 10; i++) {
            term *= -x * x / ((2 * i) * (2 * i + 1));
            sum += term;
        }
        return sum;
    }

    private double cosine(double x) {
        double term = 1, sum = 1;
        for (int i = 1; i <= 10; i++) {
            term *= -x * x / ((2 * i - 1) * (2 * i));
            sum += term;
        }
        return sum;
    }

    private double tangent(double x) {
        return sine(x) / cosine(x);
    }

    private double reciprocal(double value) {
        if (value == 0) return 0; // Avoid division by zero
        return 1 / value;
    }

    public static void main(String[] args) {
        TrigoGraph fn = new TrigoGraph();
        Scanner scanner = new Scanner(System.in);

        fn.headline();

        System.out.println("********** All in One **********");
        System.out.println("  1. Sine");
        System.out.println("  2. Cosine");
        System.out.println("  3. Tangent");
        System.out.println("  4. Cosecant");
        System.out.println("  5. Secant");
        System.out.println("  6. Cotangent");
        System.out.println("  7. Clear");
        System.out.println("  8. Exit");
        System.out.println("********************************\n");

        int choice = 0;
        while (choice != 8) {
            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    fn.draw(choice);
                    break;
                case 7:
                    System.out.print("\033[H\033[2J"); // Clear terminal screen
                    System.out.flush();
                    fn.headline();
                    break;
                case 8:
                    System.out.println("\nYou are logged out Successfully!!");
                    break;
                default:
                    System.out.println("\nError!! Invalid choice.");
            }
        }
        scanner.close();
    }
}

