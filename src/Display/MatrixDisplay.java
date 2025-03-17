package Display;

import EquationClasses.*;

import java.util.Scanner;

public class MatrixDisplay {
    public MatrixDisplay() {}
    public void display(){
        System.out.println("Solve for Matrix: ");
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to do?");
        System.out.println("1.Addition: ");
        System.out.println("2.Subtraction: ");
        System.out.println("3.Multiplication: ");
        System.out.println("4.Determinant: ");
        System.out.println("5.Inverse Matrix: ");
        System.out.println("6.LU Decomposition: ");
        System.out.println("7.Elemination Matrix: ");
        System.out.println("8. Find RREF form:- ");
        System.out.println("9. Find Echelon form:-");
        System.out.println("Give Input: ");
        int choice = sc.nextInt();
        int I,J;
        double[][] matrix;
        switch (choice) {
            case 1:
                System.out.println("Enter Dimentions for first Matrix: ");
                I = sc.nextInt();
                J = sc.nextInt();
                System.out.println("Enter values for Matrix: ");
                Matrix m = new Matrix(I,J);
                System.out.println("Enter Dimentions for Second Matrix: ");
                I = sc.nextInt();
                J = sc.nextInt();
                System.out.println("Enter values for Matrix: ");
                Matrix m2 = new Matrix(I,J);
                matrix= m.add(m.getMatrix(),m2.getMatrix());
                Matrix m3 = new Matrix(matrix);
                System.out.println("Result: ");
                m3.printMatrix();
                break;
            case 2:
                System.out.println("Enter Dimentions for First Matrix: ");
                I = sc.nextInt();
                J = sc.nextInt();
                System.out.println("Enter values for Matrix: ");
                Matrix mm = new Matrix(I,J);
                System.out.println("Enter Dimentions for Second Matrix: ");
                I = sc.nextInt();
                J = sc.nextInt();
                System.out.println("Enter values for Matrix: ");
                Matrix mm2= new Matrix(I,J);
                matrix= mm.subtract(mm.getMatrix(),mm2.getMatrix());
                Matrix mm3 = new Matrix(matrix);
                System.out.println("Result: ");
                mm3.printMatrix();
                break;
            case 3:
                System.out.println("Enter Dimentions for first Matrix: ");
                I = sc.nextInt();
                J = sc.nextInt();
                System.out.println("Enter values for Matrix: ");
                Matrix mmm = new Matrix(I,J);
                System.out.println("Enter Dimentions for Second Matrix: ");
                I = sc.nextInt();
                J = sc.nextInt();
                System.out.println("Enter values for Matrix: ");
                Matrix mmm2 = new Matrix(I,J);
                StrassenMultiply strassenMultiply = new StrassenMultiply(mmm,mmm2);
                matrix= strassenMultiply.Mul();
                Matrix mmm3 = new Matrix(matrix);
                System.out.println("Result: ");
                mmm3.printMatrix();
                break;
            case 4:
                System.out.println("Enter Dimentions of Matrix: ");
                I = sc.nextInt();
                System.out.println("Enter values for Matrix: ");
                Matrix matrix1 = new Matrix(I,I);
                Determinant determinant = new Determinant(matrix1);
                System.out.println("Result: "+ determinant.getDeterminantValue());
                break;
            case 5:
                System.out.println("Enter Dimentions of Matrix: ");
                I = sc.nextInt();
                System.out.println("Enter values for Matrix: ");
                Matrix matrix11 = new Matrix(I,I);
                InverseMatrix inv= new InverseMatrix(matrix11);
                inv.invert();
                System.out.println("Result: ");
                inv.getMatrix().printMatrix();
                break;
            case 6:
                System.out.println("Enter Dimentions of the Matrix: ");
                I = sc.nextInt();
                System.out.println("Enter values for Matrix: ");
                Matrix matrix2 = new Matrix(I,I);
                LUdecompose ld= new LUdecompose(matrix2);
                ld.printUpper();
                ld.printLower();
                break;
            case 7:
                System.out.println("Enter Dimentions of the Matrix: ");
                I = sc.nextInt();
                System.out.println("Enter values for Matrix: ");
                Matrix matrix3 = new Matrix(I,I);
                EliminationMatrix elm= new EliminationMatrix(matrix3);
                elm.printEliminationMatrices();
        }

    }
}
