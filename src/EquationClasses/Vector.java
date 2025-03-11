package EquationClasses;

import java.util.Scanner;

public class Vector {
    double[] vector = new double[3];
    int dimension;
    Scanner sc = new Scanner(System.in);
    public Vector(int dimension) {
        if (dimension <= 3 && dimension > 0) {
            this.dimension = dimension;
            inputVector(dimension);
        } else {
            throw new RuntimeException("Invalid dimension");

        }
    }

    public void inputVector(int dimensions){
        double[] temp= new double[3];
            System.out.println("Enter the coeffiencts of the vector");
        for (int i = 0; i < dimensions; i++) {
            temp[i] = sc.nextDouble();
        }
        vector = temp;
    }
    public void printVector() {
        char c= 'i';
        for (int i = 0; i < dimension; i++) {
            if(i==0)
            {
                System.out.print(vector[i]+c);
            }
            else if(vector[i]>0 && i>0)
            {
                System.out.print(" + " +vector[i]+c);
            }
            else
            {
                System.out.print(" - "+vector[i]+c);
            }
        }
    }
    public double[] getVector() {
        return vector;
    }
    public double[] vecAddition(double[] A, double[] B) {
        double[] C = new double[A.length];
        for (int i = 0; i < A.length; i++) {
            C[i] = A[i] + B[i];
        }
        return C;
    }
    public double[] vecSubtraction(double[] A, double[] B) {
        double[] C = new double[A.length];
        for (int i = 0; i < A.length; i++) {
            C[i] = A[i] - B[i];
        }
        return C;
    }
    public double DotProduction(double[] A, double[] B) {
        double C = 0;
        for (int i = 0; i < A.length; i++) {
            C= C+A[i]*B[i];
        }
        return C;
    }
    public void Cross(double[] A, double[] B) {
        double i= A[1]*B[2]-B[1]*A[2];
        double j= (A[0]*B[2]-B[0]*A[2])*(-1);
        double k= A[0]*B[1]-B[0]*A[1];
        if(j>0)
        {
            if(k>0)
            {
                System.out.println(i+"i + "+j+"j + "+k+"k");
            }
            else
            {
                System.out.println(i+"i + "+j+"j - "+k+"k");
            }
        }
        else
        {
            if(k>0)
            {
                System.out.println(i+"i + "+j+"j + "+k+"k");
            }
            else
            {
                System.out.println(i+"i + "+j+"j - "+k+"k");
            }
        }
    }
    public double value()
    {
        return 0.0;
    }
}
