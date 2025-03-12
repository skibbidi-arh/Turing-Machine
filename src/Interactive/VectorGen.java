package Interactive;

import EquationClasses.Vector;

import java.util.Random;
import java.util.Scanner;

public class VectorGen {
    static double[] A;
    static Random rand = new Random();
    public Vector genVector() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Coefficients of the Vector: ");
        A[0] = rand.nextInt(10);
        A[1] = rand.nextInt(12);
        A[2] = rand.nextInt(15);
        Vector v = new Vector(A);
        return v;
    }
}
