package src.Interactive;

import src.EquationClasses.LinearSolver;
import src.EquationClasses.Matrix;

import java.util.Scanner;

public class GAMEMAIN {
    public GAMEMAIN() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Difficulty_Controller difficulty_controller = new Difficulty_Controller(n);
        Matrix_Gen matrixGen= new Matrix_Gen(difficulty_controller);
        matrixGen.array_initialization();
        Matrix resultant= new Matrix(matrixGen.getValue_matrix());
        Matrix coeffmatrix= new Matrix(matrixGen.getVariable_matrix());
        LinearSolver ln= new LinearSolver(coeffmatrix,resultant);
        double[][] arr= ln.solve();

        System.out.print("Solve the values for ");
        for(int i=0;i<difficulty_controller.variable_number();i++)
        {
            char x= (char)(97+ i);
            System.out.print(x+" ");
        }




    }
}