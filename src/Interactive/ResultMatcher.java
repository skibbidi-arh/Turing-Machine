package Interactive;

import EquationClasses.Functions;
import EquationClasses.Matrix;
import EquationClasses.Vector1;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class ResultMatcher {
    int Question;
    String Answer;
    Scanner sc = new Scanner(System.in);
    private int[] wronganswers=new int[15];
    private int marks=0;
    private static ResultMatcher rm;
    private ResultMatcher() {

    }
    public void TakeVector(Vector1 res,int question_no){
        this.Question=question_no;
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
        this.Question=question_no;
        double UserResult=sc.nextDouble();
        if(UserResult==result){
            marks+=1;
            return;
        }
        wronganswers[question_no]=1;
        return;

    }
    public void CheckResultantDegree(double result,double resultAngle,int question_no){
        this.Question=question_no;
        double res = sc.nextDouble();
        double resultAng = sc.nextDouble();
        if(resultAng==resultAngle &&res==result){
            this.marks+=1;
            return;
        }
        wronganswers[question_no]=1;
    }
    public void LinearChecker(Matrix ans,int question_no){
        Matrix m = new Matrix(ans.getRows(),ans.getCols());
        int d=0;
        for(int i=0;i<ans.getRows();i++){
            for(int j=0;j<ans.getCols();j++){
                if(ans.getMatrix()[i][j]!=m.getMatrix()[i][j]){
                    d=1;
                    break;
                }
            }
        }
        if(d==0){
            marks+=1;
        }
        else{wronganswers[question_no]=1;}

    }

    public int getMarks() {
        return marks;
    }

    public int[] getWronganswers() {
        return wronganswers;
    }
    public  String makeString(double[][] res){
        String ans="";
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[i].length;j++){
                ans+=res[i][j]+"\t";
            }
        }
        return ans;
    }
    public String ReturnTwoVectorString(double[]res,double[] res2){
            String data="Question : "+Integer.toString(this.Question);
            data+="\n";
            for(int i=0;i<res.length;i++){
                data+=res[i]+"\t";
            }
            data+="\n";
            for(int i=0;i<res2.length;i++){
                data+=res2[i]+"\t";
            }
        return data;
    }
    public String ReturnOneVectorString(double[]res){
        String data="Question "+Integer.toString(this.Question);
        data+="\n";
        for(int i=0;i<res.length;i++){
            data+=res[i]+"\t";
        }
        data+="\n";
        return data;
    }

    public void Polynomialcheker(double[] roots,int question_no){
        double[] answers=new double[roots.length];
        double x;
        for(int i=0;i<roots.length;i++){
            System.out.println("Input root number "+i+" :");
            x= sc.nextDouble();
            answers[i]=x;
        }
        Functions.bubbleSort(answers);
        for (int i=0;i<answers.length;i++){
            if(answers[i]!=roots[i]){
                wronganswers[question_no]=1;
                return;
            }
        }
        marks+=1;
    }


}
