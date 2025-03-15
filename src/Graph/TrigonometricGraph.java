package Graph;

import java.util.Scanner;

public class TrigonometricGraph {
    public  void plotGraph(String equation) {
        int width = 100;
        int height = 20;
        double xStart = -Math.PI * 2;
        double xEnd = Math.PI * 2;

        char[][] graph = new char[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                graph[i][j] = ' ';
            }
        }

        for (int i = 0; i < width; i++) {
            double x = xStart + (xEnd - xStart) * i / (width - 1);
            double y = calculateEquation(equation, x);

            if (Double.isNaN(y)) {
                continue;
            }

            int yPos = (int) ((y + 2) * (height / 4));

            if (yPos >= 0 && yPos < height) {
                graph[height - yPos - 1][i] = '*';
            }
        }

        for (int i = 0; i < height; i++) {
            graph[i][width / 2] = '|';
        }
        for (int i = 0; i < width; i++) {
            graph[height / 2][i] = '-';
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }
    }

    public static double calculateEquation(String equation, double x) {
        switch (equation) {
            case "sin":
                return Math.sin(x);
            case "cos":
                return Math.cos(x);
            case "tan":
                return Math.tan(x);
            case "csc":
                double sinVal = Math.sin(x);
                return (sinVal != 0) ? 1 / sinVal : Double.NaN;
            case "sec":
                double cosVal = Math.cos(x);
                return (cosVal != 0) ? 1 / cosVal : Double.NaN;
            case "cot":
                double tanVal = Math.tan(x);
                return (tanVal != 0) ? 1 / tanVal : Double.NaN;
            default:
                throw new IllegalArgumentException("Invalid equation. Use 'sin', 'cos', 'tan', 'csc', 'sec', or 'cot'.");
        }
    }

    public  void draw() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the trigonometric function (sin, cos, tan, csc, sec, cot) or 0 to exit: ");
            String equation = scanner.nextLine().trim().toLowerCase();
            if (equation.equals("0")) {
                break;
            }
            plotGraph(equation);
        }
        scanner.close();
    }
}

