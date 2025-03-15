package EquationClasses;

import java.util.Scanner;

public class Vector1 {
    double[] vector = new double[3];
    int dimension;
    Scanner sc = new Scanner(System.in);
    public Vector1(int dimension) {
        if (dimension <= 3 && dimension > 0) {
            this.dimension = dimension;
            inputVector(dimension);
        } else {
            throw new RuntimeException("Invalid dimension");

        }
    }
    public Vector1() {}

    public void inputVector(int dimensions){
        double[] temp= new double[3];
        System.out.println("Enter the coeffiencts of the vector");
        for (int i = 0; i < dimensions; i++) {
            temp[i] = sc.nextDouble();
        }
        vector = temp;
    }
    public void printVector() {
        char[] components = {'i', 'j', 'k'};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < dimension; i++) {
            if (vector[i] != 0) {
                if (result.length() > 0 && vector[i] > 0) {
                    result.append(" + ");
                } else if (vector[i] < 0) {
                    result.append(" - ");
                }
                result.append(Math.abs(vector[i])).append(components[i]);
            }
        }
        System.out.println(result);
    }

    public double[] getVector() {
        return vector;
    }

    public Vector1 vecAddition(double[] A, double[] B) {
        double[] C = new double[A.length];
        for (int i = 0; i < A.length; i++) {
            C[i] = A[i] + B[i];
        }
        Vector1 result = new Vector1();
        result.setVector(C);
        return result;
    }
    public Vector1 vecSubtraction(double[] A, double[] B) {
        double[] C = new double[A.length];
        for (int i = 0; i < A.length; i++) {
            C[i] = A[i] - B[i];
        }
        Vector1 result = new Vector1();
        result.setVector(C);
        return result;
    }
    public double DotProduction(double[] A, double[] B) {
        double C = 0;
        for (int i = 0; i < A.length; i++) {
            C= C+A[i]*B[i];
        }
        return C;
    }
    public Vector1 Cross(double[] A, double[] B) {
        double i= A[1]*B[2]-B[1]*A[2];
        double j= (A[0]*B[2]-B[0]*A[2])*(-1);
        double k= A[0]*B[1]-B[0]*A[1];
        double[] cross = {i,j,k};
        Vector1 result = new Vector1();
        result.setVector(cross);
        return result;
    }
    public double value()
    {
        return Functions.squareRoot(vector[0]*vector[0]+vector[1]*vector[1]+vector[2]*vector[2]);
    }
    public double AngleBetweenVectors(Vector1 A, Vector1 B) throws TrigonoValueError {
        double c = DotProduction(A.getVector(), B.getVector());
        double C = c/(A.value()*B.value());
        return Inverse.arccos(C);
    }
    public double Resultant(Vector1 A, Vector1 B) throws TrigonoValueError {
        double angle= AngleBetweenVectors(A, B);
        return Functions.squareRoot(Functions.power(A.value(),2)+Functions.power(B.value(),2)+2*A.value()*B.value()*Trigonometry.cos(angle));
    }
    public double ResultantAngle(Vector1 A, Vector1 B) throws TrigonoValueError {
        double alpha= AngleBetweenVectors(A, B);
        double c= B.value()*Trigonometry.sin(alpha)/(A.value()+B.value()*Trigonometry.cos(alpha));
        return Inverse.arctan(c);
    }

    public void setVector(double[] di) {
        this.vector = di;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }
}
