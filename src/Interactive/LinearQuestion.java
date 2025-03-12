package Interactive;

import EquationClasses.LUdecompose;
import EquationClasses.Matrix;

import java.util.Random;

public class LinearQuestion {
    Random rand = new Random();
    Matrix_Gen matrix_gen= new Matrix_Gen(rand.nextInt(2,4));
    Matrix m= new Matrix(matrix_gen.getVariable_matrix());
    Matrix mVal= new Matrix(matrix_gen.getValue_matrix());
    Matrix mAns= new Matrix(matrix_gen.getAnswer_matrix());
    LUdecompose lud = new LUdecompose(m);
    public LinearQuestion(){
        matrix_gen.array_initialization();
    }
    public void generateLinearQuestion() {
        int option = rand.nextInt(1);
        int random= rand.nextInt(2,4);
        matrix_gen.setVar_num(random);
        switch (option) {
            case 0:
                System.out.println("Solve the Linear Equation");
                matrix_gen.array_initialization();
                m.setMatrix(matrix_gen.getVariable_matrix());
                mAns.setMatrix(matrix_gen.getAnswer_matrix());
                mVal.setMatrix(matrix_gen.getAnswer_matrix());
                this.printLinearEquation(m,mVal);
            break;
            case 1:
                System.out.println("Solve the Quadratic Equation");
            break;
        }

    }
    public void printLinearEquation(Matrix m,Matrix mVal) {
                    char[]Var = {'x','y','z','w'};
                    int x=0;
            for(int i=0;i<m.getCols();i++) {
                for(int j=0;j<m.getRows();j++) {
                    if(m.getMatrix()[i][j]>0 && j>0){
                        System.out.print("+"+m.getMatrix()[i][j]+""+Var[x]+" ");
                    }
                    else {
                        System.out.print(m.getMatrix()[i][j] + "" + Var[x] + " ");
                    }
                    x++;
                }
                x=0;
                System.out.print("= "+mVal.getMatrix()[i][0]);
                System.out.println();
            }

    }
}
