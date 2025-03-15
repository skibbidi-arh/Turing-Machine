package Graph;

import java.util.Scanner;

public class LinearGraph {
    private static final int SIZE = 41; // Defines a 41x41 grid (including axes)
    private char[][] grid;

    public LinearGraph() {
        grid = new char[SIZE][SIZE];
        initializeGrid();
    }

    private void initializeGrid() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = '.'; // Empty space
            }
        }
        drawAxes();
    }

    private void drawAxes() {
        int center = SIZE / 2;
        for (int i = 0; i < SIZE; i++) {
            grid[i][center] = '|'; // Y-axis
            grid[center][i] = '-'; // X-axis
        }
        grid[center][center] = '+'; // Origin
    }

    void plotEquation(double m, double c, char symbol) {
        for (int x = -20; x <= 20; x++) { // Extended range
            double y = m * x + c;
            int roundedY = (int) Math.round(y);

            // Only plot points that fit within graph limits
            if (roundedY >= -20 && roundedY <= 20) {
                int plotX = x + SIZE / 2;
                int plotY = (SIZE / 2) - roundedY;

                if (plotX >= 0 && plotX < SIZE && plotY >= 0 && plotY < SIZE) {
                    grid[plotY][plotX] = symbol; // Marking the point on the graph
                }
            }
        }
    }

    void displayGraph() {
        for (char[] row : grid) {
            for (char cell : row) {
                if(cell == '|'){
                    System.out.print("\033[40m|\033[0m"+" ");
                }
                else if(cell == '-'){
                    System.out.print("\033[40m-\033[0m"+" ");
                }
                else if(cell == '*'){
                    System.out.print("\033[31m*\033[0m"+" ");
                }
                else if(cell == 'o'){
                    System.out.print("\033[33mo\033[0m"+" ");
                }
                else {
                    System.out.print(cell + " ");
                }
            }
            System.out.println();
        }
    }
}
