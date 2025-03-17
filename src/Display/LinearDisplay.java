package Display;

import EquationClasses.*;

import java.util.List;
import java.util.Scanner;

public class LinearDisplay {
    public LinearDisplay() {}
    public void linearDisplay() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What do want to do:- ");
        System.out.println("1. Solve Linear Equation:- ");
        System.out.println("2.Find Particular Solution:- ");
        System.out.println("3. Find Complete Solution:- ");
        System.out.println("4.Get Null space:- ");
        System.out.println("6.Get Column space:- ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("How many variables do you want to solve: ");
                int n = sc.nextInt();
                char c ;
                System.out.print("The equation structure is: ");
                for(int i = 0; i < n; i++) {
                    c = (char)('a'+i);
                    if(i<n-1)
                    {
                        System.out.print(c+ "x" +i+"+");
                    }
                    else
                    {
                        System.out.print(c+"x"+i+"=");
                    }
                }
                System.out.println("constant");
                LinearRegex lr = new LinearRegex();
                lr.take(n);
                break;
            case 2:
                System.out.println("Input number of rows and columns in coefficient matrix:- ");
                int rows= sc.nextInt();
                int columns = sc.nextInt();
                System.out.println("Input Coefficient Matrix: ");
                Matrix m= new Matrix(rows,columns);
                double[] rhs= new double[rows];
                System.out.println("Input the right hand side column matrix of the equation:- ");
                for(int i=0;i<rows;i++)
                {
                    rhs[i]= sc.nextDouble();
                }
                ParticularSolve pr= new ParticularSolve();
                double[] answerp= pr.particularSolution(m.getMatrix(),rhs);

                for (int i = 0; i < rows; i++) {
                    System.out.println(answerp[i]);
                }
                break;
            case 3:
                System.out.println("Input number of rows and columns in coefficient matrix:- ");
                rows= sc.nextInt();
                columns = sc.nextInt();
                System.out.println("Input Coefficient Matrix: ");
                Matrix mm= new Matrix(rows,columns);
                System.out.println("Input the right hand side column matrix of the equation:- ");
                double[] rhsc= new double[rows];
                CompleteSolve cm= new CompleteSolve();
                for(int i=0;i<rows;i++)
                {
                    rhsc[i]= sc.nextDouble();
                }
                List<double[]> answerc= cm.completeSolution(mm.getMatrix(),rhsc);
                cm.printSolutions(answerc);
            case 4:
                System.out.println("Input number of rows and columns in coefficient matrix:- ");
                rows= sc.nextInt();
                columns = sc.nextInt();
                System.out.println("Input Coefficient Matrix: ");
                Matrix mm1= new Matrix(rows,columns);
                NullSpace nls= new NullSpace();
                List<double[]> ans= nls.nullSpace(mm1);
                nls.printNullSpace(ans);
                break;
            case 5:
                System.out.println("Input number of rows and columns in coefficient matrix:- ");
                rows= sc.nextInt();
                columns = sc.nextInt();
                System.out.println("Input Coefficient Matrix: ");
                Matrix mm2= new Matrix(rows,columns);
                ColumnSpace cs= new ColumnSpace();
                List<double[]> ans2= cs.columnSpace(mm2);
                cs.printColumnSpace(ans2);
                break;
        }

    }
}
