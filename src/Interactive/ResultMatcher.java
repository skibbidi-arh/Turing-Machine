package Interactive;

import EquationClasses.Matrix;
import EquationClasses.Vector1;

import java.util.Scanner;
import java.util.Vector;

public class ResultMatcher {
    Scanner sc = new Scanner(System.in);
    private int[] wronganswers=new int[15];
    private int marks=0;
    private static ResultMatcher rm;
    private ResultMatcher() {

    }
    public void TakeVector(Vector1 res,int question_no){

        double x= sc.nextDouble();
        double y= sc.nextDouble();
        double z= sc.nextDouble();
        double[] A = res.getVector();
        if(A[0]==x && A[1]==y && A[2]==z){
            this.marks+=1;
            return;
        }
        wronganswers[question_no]=1;
        return;
    }
    public static ResultMatcher getMatcher(){
        if(rm==null){
            rm = new ResultMatcher();
        }
        return rm;
    }
    public void TakeInput(double result,int question_no){
        double UserResult=sc.nextDouble();
        if(UserResult==result){
            marks+=1;
            return;
        }
        wronganswers[question_no]=1;
        return;

    }
    public void CheckResultantDegree(double result,double resultAngle,int question_no){
        double res = sc.nextDouble();
        double resultAng = sc.nextDouble();
        if(resultAng==resultAngle &&res==result){
            marks+=1;
            return;
        }
        wronganswers[question_no]=1;
    }
    public void LinearChecker(Matrix ans,int question_no){
        Matrix m = new Matrix(ans.getRows(),ans.getCols());
        for(int i=0;i<ans.getRows();i++){
            m.getMatrix()[i][0]= sc.nextDouble();
        }
        if(m.getMatrix()==ans.getMatrix())
        {
            marks+=1;
            return;
        }
        wronganswers[question_no]=1;
    }

    public int getMarks() {
        return marks;
    }

    public int[] getWronganswers() {
        return wronganswers;
    }
}
