package Interactive;

import EquationClasses.Matrix;
import EquationClasses.Vector1;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class ResultMatcher {
    String Question;
    String Answer;
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
        //pt.Question=arrayToStringWithIndents(m.getMatrix());
       Question=arrayToStringWithIndents(m.getMatrix());
       Answer = matrixToString(m.getMatrix());
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
    public  String arrayToStringWithIndents(double[][] array) {
        StringBuilder result = new StringBuilder();
        for (double[] row : array) {
            for (int i = 0; i < row.length - 1; i++) { //Exclude the last element for now
                result.append(row[i]).append(" ");
            }
            result.append("= ").append(row[row.length - 1]).append("\n"); // Add equals and the last element
        }
        return result.toString();
    }
    public String returnQuestion(){
            return Question;
    }
    public String returnAnswer(){
        return Answer;
    }
    public static String matrixToString(double[][] matrix) {
        StringBuilder result = new StringBuilder();
        for (double[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                result.append(row[i]);
                if (i < row.length - 1) {
                    result.append(" "); // Add space between elements in a row
                }
            }
            result.append("\n"); // Add newline after each row
        }
        return result.toString();
    }

}
