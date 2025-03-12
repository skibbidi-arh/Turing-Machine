package Interactive;


import EquationClasses.Vector1;

import java.util.Random;
import java.util.Scanner;

public class VectorGen {
    public double[] A;
    public Random rand = new Random();
    public Vector1 genVector() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Coefficients of the Vector: ");
        A[0] = rand.nextInt(10);
        A[1] = rand.nextInt(12);
        A[2] = rand.nextInt(15);
        Vector1 v = new Vector1();
        v.setVector(A);
        return v;
    }
}
