package src.Interactive;

import java.util.Random;

public class Matrix_Gen {
    private double[][] variable_matrix;
    private double[][] value_matrix;
    Difficulty_Controller difficulty_controller;

    public Matrix_Gen(Difficulty_Controller difficulty_controller) {
        this.difficulty_controller = difficulty_controller;
        int var_num = difficulty_controller.variable_number();
        this.variable_matrix = new double[var_num][var_num];
        this.value_matrix = new double[var_num][1];

    }
    public void array_initialization(){
        Random rand = new Random();
        int x,y;
        int variable_number= difficulty_controller.variable_number();
        for(int i=0; i<variable_matrix.length; i++){
            for(int j=0; j<variable_matrix[i].length; j++){
               x = rand.nextInt(difficulty_controller.getDifficulty()*10);
               y=rand.nextInt(difficulty_controller.getDifficulty());
               if(y%2==1)
               {
                   x= x*(-1);
               }
               variable_matrix[i][j] = x;
            }
        }

        for (int i = 0; i < variable_number; i++) {
            x = rand.nextInt(difficulty_controller.getDifficulty()*10);
            y=rand.nextInt(difficulty_controller.getDifficulty());
            if(y%2==1)
            {
                x= x*(-1);
            }
            value_matrix[i][0] = x;
        }
    }

    public double[][] getValue_matrix() {
        return value_matrix;
    }

    public double[][] getVariable_matrix() {
        return variable_matrix;
    }
}
