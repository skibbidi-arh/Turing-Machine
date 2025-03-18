package EquationClasses;

import java.util.Scanner;
import java.util.Vector;

public class Divergence {
    private double x, y, z;
    private double i = 0, j = 0, k = 0;

    public Divergence() {
    }
    public void OneVariable(char s, int coefficient, int power)
    {
        int[] eqn = new int[4];
        eqn[0] = coefficient;
        if(s=='x'){
            eqn[1] = power;
            eqn = PartialDiff.dX(eqn);
            this.i += Functions.power(x, eqn[1]) * eqn[0];
        }
        else if(s=='y'){
            eqn[2] = power;
            eqn = PartialDiff.dY(eqn);
            this.j += Functions.power(y, eqn[2]) * eqn[0];
        }
        else if(s=='z'){
            eqn[3] = power;
            eqn = PartialDiff.dZ(eqn);
            this.k += Functions.power(z, eqn[3]) * eqn[0];
        }
    }
    public void TwoVariable(String s, int coefficient, int power1,int power2)
    {
        int[] eqn = new int[4];
        int[] eqnX = new int[4];
        int[] eqnY = new int[4];
        int[] eqnZ = new int[4];
        eqn[0] = coefficient;
        if(s.equals("xy"))
        {
            eqn[1]=power1;
            eqn[2]=power2;
            eqnX = PartialDiff.dX(eqn);
            this.i += Functions.power(x, eqnX[1]) * eqnX[0] * Functions.power(y, eqnX[2]);
            double i2= eqnX[0] * Functions.power(z, eqnX[3]) * Functions.power(x, eqnX[1]);
            eqnY = PartialDiff.dY(eqn);
            this.j += eqnY[0] * Functions.power(y, eqnY[2]) * Functions.power(x, eqnY[1]);
            double j2=eqnY[0] * Functions.power(y, eqnY[2]) * Functions.power(x, eqnY[1]);
        }
        else if(s.equals("yz"))
        {
            eqn[2]=power1;
            eqn[3]=power2;
            eqnY = PartialDiff.dY(eqn);
            this.j += Functions.power(y, eqnY[1]) * eqnY[0] * Functions.power(z, eqnY[3]);
            eqnZ = PartialDiff.dZ(eqn);
            this.k += eqnZ[0] * Functions.power(y, eqnZ[2]) * Functions.power(z, eqnZ[3]);
        }
        else if(s.equals("zx"))
        {
            eqn[1]=power2;
            eqn[3]=power1;
            eqnZ = PartialDiff.dZ(eqn);
            double k1= Functions.power(z, eqnZ[3]) * eqnZ[0] * Functions.power(x, eqnZ[1]);
            this.k += Functions.power(z, eqnZ[3]) * eqnZ[0] * Functions.power(x, eqnZ[1]);
            eqnX = PartialDiff.dX(eqn);
            double i1= eqnX[0] * Functions.power(z, eqnX[3]) * Functions.power(x, eqnX[1]);
            this.i += eqnX[0] * Functions.power(z, eqnX[3]) * Functions.power(x, eqnX[1]);

        }
    }

    public void ThreeVariable(int coefficient, int power1,int power2,int power3)
    {
        int[] eqn = new int[4];
        int[] eqnX = new int[4];
        int[] eqnY = new int[4];
        int[] eqnZ = new int[4];
        eqn[0] = coefficient;
        eqn[1] = power1;
        eqn[2] = power2;
        eqn[3] = power3;
        eqnX = PartialDiff.dX(eqn);
        eqnY = PartialDiff.dY(eqn);
        eqnZ = PartialDiff.dZ(eqn);
        this.i += Functions.power(x, eqnX[1]) * eqnX[0] * Functions.power(y, eqnX[2]) * Functions.power(z, eqnX[3]);
        this.j += eqnY[0] * Functions.power(y, eqnY[2]) * Functions.power(x, eqnY[1]) * Functions.power(z, eqnY[3]);
        this.k += eqnZ[0] * Functions.power(y, eqnZ[2]) * Functions.power(z, eqnZ[3]) * Functions.power(x, eqnZ[1]);
    }
    public void display()
    {
        System.out.println("Divergence: ");
        System.out.print("Input points for X, Y, Z: ");
        Scanner sc = new Scanner(System.in);
        this.x = sc.nextDouble();
        this.y = sc.nextDouble();
        this.z = sc.nextDouble();
        int choice=0;
        int power1,power2,power3,coefficient;
        while (choice != 8) {
            System.out.println("Select Equation for Divergence: ");
            System.out.println("1. x^n");
            System.out.println("2. y^n");
            System.out.println("3. z^n");
            System.out.println("4. x^n.y^n");
            System.out.println("5. y^n.z^n");
            System.out.println("6. z^n.x^n");
            System.out.println("7. x^n.y^n.z^n");
            System.out.println("8. End");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Coefficient: ");
                    coefficient = sc.nextInt();
                    System.out.println("Enter Power of X: ");
                    power1 = sc.nextInt();
                    OneVariable('x',coefficient,power1);
                    break;
                case 2:
                    System.out.println("Enter Coefficient: ");
                    coefficient = sc.nextInt();
                    System.out.println("Enter Power of Y: ");
                    power2 = sc.nextInt();
                    OneVariable('y',coefficient,power2);
                    break;
                case 3:
                    System.out.println("Enter Coefficient: ");
                    coefficient = sc.nextInt();
                    System.out.println("Enter Power of Z: ");
                    power3 = sc.nextInt();
                    OneVariable('z',coefficient,power3);
                    break;
                case 4:
                    System.out.println("Enter Coefficient: ");
                    coefficient = sc.nextInt();
                    System.out.println("Enter Power of X: ");
                    power1 = sc.nextInt();
                    System.out.println("Enter Power of Y: ");
                    power2 = sc.nextInt();
                    TwoVariable("xy",coefficient,power1,power2);
                    break;
                case 5:
                    System.out.println("Enter Coefficient: ");
                    coefficient = sc.nextInt();
                    System.out.println("Enter Power of Y: ");
                    power2 = sc.nextInt();
                    System.out.println("Enter Power of Z: ");
                    power3 = sc.nextInt();
                    TwoVariable("yz",coefficient,power2,power3);
                    break;
                case 6:
                    System.out.println("Enter Coefficient: ");
                    coefficient = sc.nextInt();
                    System.out.println("Enter Power of Z: ");
                    power3 = sc.nextInt();
                    System.out.println("Enter Power of X: ");
                    power1 = sc.nextInt();
                    TwoVariable("zx",coefficient,power3,power1);
                    break;
                case 7:
                    System.out.println("Enter Coefficient: ");
                    coefficient = sc.nextInt();
                    System.out.println("Enter Power of X: ");
                    power1 = sc.nextInt();
                    System.out.println("Enter Power of Y: ");
                    power2 = sc.nextInt();
                    System.out.println("Enter Power of Z: ");
                    power3 = sc.nextInt();
                    ThreeVariable(coefficient, power1, power2, power3);
            }
//            System.out.println(this.i);
//            System.out.println(this.j);
//            System.out.println(this.k);
        }
        Vector1 v = this.divergence();
        v.printVector();
    }

    public double getI() {
        return i;
    }
    public double getJ() {
        return j;
    }
    public double getK() {
        return k;
    }
    public Vector1 divergence()
    {
        double[] di= {this.i,this.j,this.k};
        Vector1 vec= new Vector1();
        vec.setVector(di);
        vec.setDimension(3);
        return vec;
    }
}
