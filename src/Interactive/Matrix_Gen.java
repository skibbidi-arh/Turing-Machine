package src.Interactive;

public class Matrix_Gen {
    private int[][] variable_matrix;
    Difficulty_Controller difficulty_controller;

    public Matrix_Gen(Difficulty_Controller difficulty_controller) {
        this.difficulty_controller = difficulty_controller;
        int var_num = difficulty_controller.variable_number();
        this.variable_matrix = new int[var_num][var_num];
    }
}
