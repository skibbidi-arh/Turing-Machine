import java.util.Scanner;

public class tst3 {
    private static final int WIDTH = 140; // Graph width in characters for smoother curves
    private static final int HEIGHT = 20; // Graph height in characters

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a function to plot:");
        System.out.println("1. Sine Function");
        System.out.println("2. Cosine Function");
        System.out.println("3. Tangent Function");
        System.out.print("Enter your choice (1/2/3): ");

        int choice = scanner.nextInt();

        if (choice < 1 || choice > 3) {
            System.out.println("Invalid choice. Please run the program again and select a valid option.");
        } else {
            plotGraph(choice);
        }

        scanner.close();
    }

    private static void plotGraph(int choice) {
        char[][] graph = new char[HEIGHT][WIDTH];

        // Initialize the graph
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                graph[i][j] = ' ';
            }
        }

        // Plot axes
        int xAxis = HEIGHT / 2; // Middle of the graph vertically
        int yAxis = WIDTH / 2; // Middle of the graph horizontally

        for (int x = 0; x < WIDTH; x++) {
            graph[xAxis][x] = '-';
        }

        for (int y = 0; y < HEIGHT; y++) {
            graph[y][yAxis] = '|';
        }

        graph[xAxis][yAxis] = '+'; // Origin point

        // Label axes
        for (int x = 0; x < WIDTH; x += WIDTH / 8) {
            int angle = -180 + (x * 360 / WIDTH); // Map x to -180 to 180 degrees
            String label = String.valueOf(angle);
            for (int i = 0; i < label.length(); i++) {
                if (x + i < WIDTH) {
                    graph[xAxis + 1][x + i] = label.charAt(i);
                }
            }
        }

        for (int y = 0; y < HEIGHT; y += HEIGHT / 4) {
            double value = (xAxis - y) * 2.0 / HEIGHT;
            String label = String.format("%.1f", value);
            for (int i = 0; i < label.length(); i++) {
                if (yAxis - label.length() - 1 + i >= 0) {
                    graph[y][yAxis - label.length() - 1 + i] = label.charAt(i);
                }
            }
        }

        // Plot function
        for (int x = 0; x < WIDTH; x++) {
            double angle = Math.toRadians(-180 + (x * 360 / WIDTH)); // Map x to -180 to 180 degrees
            double value = 0;

            switch (choice) {
                case 1: // Sine
                    value = Math.sin(angle);
                    break;
                case 2: // Cosine
                    value = Math.cos(angle);
                    break;
                case 3: // Tangent
                    value = Math.tan(angle);
                    if (Math.abs(value) > 1) continue; // Skip large tangent values for visibility
                    break;
                default:
                    return;
            }

            int y = (int) (xAxis - value * (HEIGHT / 2)); // Scale and invert y-axis
            if (y >= 0 && y < HEIGHT) {
                graph[y][x] = '█'; // Use a block character for smoother curves
            }
        }

        // Print graph
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                System.out.print(graph[y][x]);
            }
            System.out.println();
        }
    }
}
