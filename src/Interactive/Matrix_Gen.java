package Interactive;

import EquationClasses.Matrix;
import EquationClasses.StrassenMultiply;

import java.util.Random;

public class Matrix_Gen {
    private double[][] variable_matrix;
    private double[][] value_matrix;
    private double[][] answer_matrix;
    Difficulty_Controller difficulty_controller;
    private int var_num;

    public Matrix_Gen(Difficulty_Controller difficulty_controller) {
        this.difficulty_controller = difficulty_controller;
        this.var_num = difficulty_controller.variable_number();
        this.variable_matrix = new double[var_num][var_num];
        this.value_matrix = new double[var_num][1];
        this.answer_matrix = new double[var_num][1];


    }
    public Matrix_Gen(int var_num) {
        this.var_num = var_num;
        this.variable_matrix = new double[var_num][var_num];
        this.value_matrix = new double[var_num][1];
        this.answer_matrix = new double[var_num][1];
    }
    public void array_initialization(){
        Random rand = new Random();
        int x,y;
        int variable_number=var_num;
        for(int i=0; i<var_num; i++){
            for(int j=0; j<var_num; j++){
                x = rand.nextInt(var_num*10);
                y=rand.nextInt(var_num*10);
                if(y%2==1)
                {
                    x= x*(-1);
                }
                variable_matrix[i][j] = x;
            }
        }

        for (int i = 0; i < var_num; i++) {
            x = rand.nextInt(1,var_num*10);
            y=rand.nextInt(var_num);
            if(y%2==1)
            {
                x= x*(-1);
            }
            answer_matrix[i][0] = x;
        }
        Matrix matrix1 = new Matrix(answer_matrix);
        Matrix matrix2 = new Matrix(variable_matrix);
        StrassenMultiply str= new StrassenMultiply(matrix2, matrix1);
        value_matrix = str.Mul();
    }

    public double[][] getValue_matrix() {
        return value_matrix;
    }

    public double[][] getVariable_matrix() {
        return variable_matrix;
    }
    public double[][] getAnswer_matrix() {
        return answer_matrix;
    }

    public void setVar_num(int var_num) {
        this.var_num = var_num;
    }
}
