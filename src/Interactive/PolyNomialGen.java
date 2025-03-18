package Interactive;

import EquationClasses.Functions;

import java.util.Random;

public class PolyNomialGen {

    Random rand = new Random();
    double[] roots;
    double[] coefficients;

    public PolyNomialGen() {
    }

    public void generate() {

        double constant = 1;
        int highestPower = rand.nextInt(2, 5);
        coefficients = new double[highestPower + 1];
        roots = new double[highestPower];
        if (highestPower == 2) {
            ifRoot2();
        }
        else if (highestPower == 3) {
            ifRoots3();
        }
        else if (highestPower == 4) {
            ifRoot4();
        }
        Functions.bubbleSort(roots);

    }

    public void ifRoots3() {
        int a = rand.nextInt(20);
        int b = rand.nextInt(20);
        int c = rand.nextInt(20);
        if (a % 2 == 0) {
            a = a * -1;
        }
        if (b % 2 == 0) {
            b = b * -1;
        }
        if (c % 2 == 0) {
            c = c * -1;
        }
        coefficients[0] = 1;
        coefficients[1] = -1 * (a + b + c);
        coefficients[2] = a * b + b * c + c * a;
        coefficients[3] = -1 * (a * b * c);
        roots[0] = a;
        roots[1] = b;
        roots[2] = c;

    }

    public void ifRoot4() {
        int a = rand.nextInt(20);
        int b = rand.nextInt(20);
        int c = rand.nextInt(20);
        int d = rand.nextInt(20);
        if (a % 2 == 0) {
            a = a * -1;
        }
        if (b % 2 == 0) {
            b = b * -1;
        }
        if (c % 2 == 0) {
            c = c * -1;
        }
        if (d % 2 == 0) {
            d = d * -1;
        }
        coefficients[0] = 1;
        coefficients[1] = -1 * (a + b + c + d);
        coefficients[2] = a * b + a * c + a * d + b * c + b * d + c * d;
        coefficients[3] = -1 * (a * b * c + a * c * d + a * b * d + b * c * d);
        coefficients[4] = a * b * c * d;
        roots[0] = a;
        roots[1] = b;
        roots[2] = c;
        roots[3] = d;

    }

    public void ifRoot2() {
        int a = rand.nextInt(20);
        int b = rand.nextInt(20);
        if (a % 2 == 0) {
            a = a * -1;
        }
        if (b % 2 == 0) {
            b = b * -1;
        }
        coefficients[0] = 1;
        coefficients[1] = -1 * (a + b);
        coefficients[2] = a * b;
        roots[0] = a;
        roots[1] = b;
    }

    public void printPolynomial() {
        int size = roots.length;
        for (int i = 0; i < size; i++) {
            if(size-i==1){
                if(coefficients[i]>=0){
                    System.out.print("+"+coefficients[i]+"x");
                }
                else{
                    System.out.print(coefficients[i]+"x");
                }
            }
            else{
                if(coefficients[i]>=0){
                    System.out.print("+"+coefficients[i]+"x^"+(size-i));
                }
                else{
                    System.out.print(coefficients[i]+" x^"+(size-i));
                }
            }
        }
        if(coefficients[coefficients.length-1]>=0){
            System.out.print("+"+coefficients[coefficients.length-1]+" = 0");
        }
        else{
        System.out.print(coefficients[coefficients.length-1]+"= 0");
        }
        System.out.println();
    }
    public double[] getCoefficients() {
        return coefficients;
    }
    public double[] getRoots() {
        return roots;
    }
    public String getEntirePolyNomial(int question){
        String data="Question "+question;
        data+="\n";
        int size = roots.length;
        for (int i = 0; i < size; i++) {
            if(size-i==1){
                if(coefficients[i]>=0){
                    data+="+"+coefficients[i]+"x";
                }
                else{
                    data+=" "+coefficients[i]+"x";
                }
            }
            else{
                if(coefficients[i]>=0){
                   // System.out.print("+"+coefficients[i]+"x^"+(size-i));
                    data+="+"+coefficients[i]+"x^"+(size-i);
                }
                else{
                    //System.out.print(coefficients[i]+" x^"+(size-i));
                    data+=" "+coefficients[i]+" x^"+(size-i);
                }
            }
        }
        if(coefficients[coefficients.length-1]>=0){
           // System.out.print("+"+coefficients[coefficients.length-1]+" = 0");
            data+="+"+coefficients[coefficients.length-1]+" = 0";
        }
        else{
        //    System.out.print(coefficients[coefficients.length-1]+"= 0");
            data+=coefficients[coefficients.length-1]+"= 0";
        }
       // System.out.println();
        data+="\n";

        return data;
    }
    public String rootsToString(){
        String data="roots= ";
        int size = roots.length;
        for (int i = 0; i < size; i++) {
            data+=roots[i]+" ";
        }
        return data;
    }
}