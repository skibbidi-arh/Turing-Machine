package Interactive;

import EquationClasses.LUdecompose;
import EquationClasses.Matrix;

import java.util.Arrays;
import java.util.Random;

public class LinearQuestion {
    int point=0;
    PrintToFile pf;
    Random rand = new Random();
    int question_no;
    public LinearQuestion(int question_no,PrintToFile pf) {
        this.question_no =question_no;
        this.pf = pf;
    }
    public void generateLinearQuestion() {
        int option = rand.nextInt(3);
        int random= rand.nextInt(2,5);
        Matrix_Gen matrix_gen= new Matrix_Gen(random);
        Matrix m= new Matrix(matrix_gen.getVariable_matrix());
        Matrix mVal= new Matrix(matrix_gen.getValue_matrix());
        Matrix mAns= new Matrix(matrix_gen.getAnswer_matrix());
        LUdecompose lud = new LUdecompose(m);
        ResultMatcher rm= ResultMatcher.getMatcher();
        switch (option) {
            case 0:
                System.out.println("Solve the Linear Equation");
                matrix_gen.array_initialization();
                m.setMatrix(matrix_gen.getVariable_matrix());
                mAns.setMatrix(matrix_gen.getAnswer_matrix());
                mVal.setMatrix(matrix_gen.getValue_matrix());
             //   mAns.printMatrix();
             //   printLinearEquation(m,mVal);
                pf.Question=this.GetLinearEquation(m,mVal);
                pf.Answer=rm.makeString(mAns.getMatrix());
                rm.LinearChecker(mAns,this.question_no);


            break;
            case 1:
                System.out.println("Find Lower Matrix of the Equation");
                matrix_gen.array_initialization();
                m.setMatrix(matrix_gen.getVariable_matrix());
                mAns.setMatrix(matrix_gen.getAnswer_matrix());
                mVal.setMatrix(matrix_gen.getValue_matrix());
                this.printLinearEquation(m,mVal);
                LUdecompose ld = new LUdecompose(m);
                pf.Question=this.ConstructString(m.getMatrix());
                pf.Answer=this.ConstructString(ld.getlowMatrix().getMatrix());
                rm.LinearChecker(ld.getupMatrix(),this.question_no);


                break;
            case 2:
                System.out.println("Find Upper Matix of the Equation");
                matrix_gen.array_initialization();
                m.setMatrix(matrix_gen.getVariable_matrix());
                mAns.setMatrix(matrix_gen.getAnswer_matrix());
                mVal.setMatrix(matrix_gen.getValue_matrix());
                this.printLinearEquation(m,mVal);
                LUdecompose ld2 = new LUdecompose(m);
                rm.LinearChecker(ld2.getupMatrix(),this.question_no);
                pf.Question=this.ConstructString(m.getMatrix());
                pf.Answer=this.ConstructString(ld2.getlowMatrix().getMatrix());
                break;
        }
        this.point=rm.getMarks();



    }
    public void printLinearEquation(Matrix m,Matrix mVal) {
                    char[]Var = {'x','y','z','w'};
                    int x=0;
            for(int i=0;i<m.getCols();i++) {
                for(int j=0;j<m.getRows();j++) {
                    if(m.getMatrix()[i][j]>0 && j>0){
                        System.out.print("+"+m.getMatrix()[i][j]+""+Var[x]+" ");
                     //   data+="+"+m.getMatrix()[i][j]+""+Var[x]+" ";
                    }
                    else {
                        System.out.print(m.getMatrix()[i][j] + "" + Var[x] + " ");
                    //    data+=m.getMatrix()[i][j] + "" + Var[x] + " ";
                    }
                    x++;
                }
                x=0;
             //   data+="= "+mVal.getMatrix()[i][0];
                System.out.print("= "+mVal.getMatrix()[i][0]);
             //   data+="\n";
                System.out.println();
            }
           // return data;

    }
    public String ConstructString(double[][] matrix) {
        String data="";
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                data+=matrix[i][j]+" ";
            }
            data+="\n";
        }

        return data;
    }
    public String GetLinearEquation(Matrix m,Matrix mVal){
        String data="";
        char[]Var = {'x','y','z','w'};
        int x=0;
        for(int i=0;i<m.getCols();i++) {
            for(int j=0;j<m.getRows();j++) {
                if(m.getMatrix()[i][j]>0 && j>0){
                    System.out.print("+"+m.getMatrix()[i][j]+""+Var[x]+" ");
                    data+="+"+m.getMatrix()[i][j]+""+Var[x]+" ";
                }
                else {
                    System.out.print(m.getMatrix()[i][j] + "" + Var[x] + " ");
                    data+=m.getMatrix()[i][j] + "" + Var[x] + " ";
                }
                x++;
            }
            x=0;
            data+="= "+mVal.getMatrix()[i][0];
            System.out.print("= "+mVal.getMatrix()[i][0]);
            data+="\n";
            System.out.println();
        }
        return data;
    }

    public int getpoints()
    {
        return point;
    }
}
