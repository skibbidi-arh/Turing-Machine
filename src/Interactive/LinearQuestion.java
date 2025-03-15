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
    ResultMatcher rm= ResultMatcher.getMatcher();
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
                rm.LinearChecker(mAns,1);

            break;
            case 1:
                System.out.println("Find Lower Matix of the Equation");
                matrix_gen.array_initialization();
                m.setMatrix(matrix_gen.getVariable_matrix());
                mAns.setMatrix(matrix_gen.getAnswer_matrix());
                mVal.setMatrix(matrix_gen.getAnswer_matrix());
                this.printLinearEquation(m,mVal);
                LUdecompose ld = new LUdecompose(m);
                rm.LinearChecker(ld.getupMatrix(),1);
                break;
            case 2:
                System.out.println("Find Upper Matix of the Equation");
                matrix_gen.array_initialization();
                m.setMatrix(matrix_gen.getVariable_matrix());
                mAns.setMatrix(matrix_gen.getAnswer_matrix());
                mVal.setMatrix(matrix_gen.getAnswer_matrix());
                this.printLinearEquation(m,mVal);
                LUdecompose ld2 = new LUdecompose(m);
                rm.LinearChecker(ld2.getupMatrix(),1);
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
