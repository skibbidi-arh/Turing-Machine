import java.util.Scanner;

public class Test2 {
    private static final int WIDTH = 70; // Graph width in characters
    private static final int HEIGHT = 20; // Graph height in characters

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select a function to plot:");
        System.out.println("1. Sine (sin)");
        System.out.println("2. Cosine (cos)");
        System.out.println("3. Tangent (tan)");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        System.out.println("Graphing the selected function...");

        plotGraph(choice);
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
            int angle = (x * 360 / WIDTH) - 180; // Map x to -180° to 180°
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
            double angle = Math.toRadians((x * 360.0 / WIDTH) - 180); // Map x to -180° to 180°
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
                    System.out.println("Invalid choice. Exiting.");
                    return;
            }

            int y = (int) (xAxis - value * (HEIGHT / 2)); // Scale and invert y-axis
            if (y >= 0 && y < HEIGHT) {
                graph[y][x] = '*';
            }
        }

        // Print graph
        System.out.println("\nReal-Life ASCII Graph:");
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                System.out.print(graph[y][x]);
            }
            System.out.println();
        }
    }
}
