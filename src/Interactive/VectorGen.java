package Interactive;


import EquationClasses.Vector1;

import java.util.Random;
import java.util.Scanner;

public class VectorGen {
    public double[] A = new double[3];
    public Random rand = new Random();

    public Vector1 genVector() {
        Scanner sc = new Scanner(System.in);
        A[0] = rand.nextInt(10);
        A[1] = rand.nextInt(12);
        A[2] = rand.nextInt(15);
        Vector1 v = new Vector1();
        v.setDimension(3);
        v.setVector(A);
        return v;
    }
}
//
//public void printPolynomial() {
//    int size = roots.length;
//    for(int i=size;i>=1;i--) {
//        if(i==1){
//            if(coefficients[i]>=0){System.out.print(coefficients[i]+"x");}
//            else{System.out.print(coefficients[i]+"x");}
//
//        }
//        else{
//            if(coefficients[i]>0){System.out.print("+"+coefficients[i]+"x^"+i+" ");}
//            else{
//                System.out.print(coefficients[i]+"x^"+i);
//            }
//        }
//    }
//    if(coefficients[0]>0){ System.out.print("+"+coefficients[coefficients.length-1]+" = 0");}
//    else{System.out.print(coefficients[coefficients.length-1]+" = 0");}
//}