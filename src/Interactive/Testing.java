package Interactive;
import EquationClasses.InverseMatrix;
import EquationClasses.Matrix;
import EquationClasses.StrassenMultiply;
import java.util.Scanner;

public class Testing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Difficulty_Controller df = new Difficulty_Controller(n);
        Matrix_Gen m= new Matrix_Gen(df);
        m.array_initialization();
        Matrix_Gen a= new Matrix_Gen(df);
        a.array_initialization();
        double[][] zero= a.getVariable_matrix();
        Matrix z= new Matrix(zero);
        z.printMatrix();
        Matrix x= new Matrix(a.getValue_matrix());
        x.printMatrix();
//        double[][] x= a.getValue_matrix();
//        double[][] b= m.getValue_matrix();
//        Matrix xx= new Matrix(x);
//        Matrix xb= new Matrix(b);
//        InverseMatrix inverseX= new InverseMatrix(xx);
//        inverseX.invert();
//        xx=inverseX.getMatrix();
//        StrassenMultiply str= new StrassenMultiply(xx,xb);
//        double[][] Aarr= str.Mul();
//        Matrix A= new Matrix(Aarr);
//        A.printMatrix();






    }
}
