package Interactive;

import EquationClasses.Vector;

import java.util.Random;

public class VectorQuestion {
    public VectorQuestion() {}
        Random rand = new Random();
        Vector A;
        Vector B;
        VectorGen vg = new VectorGen();
        double result;
        double[] resvec;
    public void GenerateOption(){
                    int option = rand.nextInt(5);
                switch (option){
                    case 1:
                        System.out.println("Perform the Addition of Two Vectors");
                        A = vg.genVector();
                        B= vg.genVector();
                        resvec= A.vecAddition(A.getVector(),B.getVector());

                    break;
                    case 2:
                        System.out.println("Perform the Subtaction of Two Vectors");
                        A = vg.genVector();
                        B= vg.genVector();
                        result= A.DotProduction(A.getVector(),B.getVector());

                    break;
                    case 3:
                        System.out.println("Perform the DotProduct of Two Vectors");
                        A = vg.genVector();
                        B = vg.genVector();
                        result= A.DotProduction(A.getVector(),B.getVector());
                    break;
                    case 4:
                        System.out.println("Perform the Cross of Two Vectors");
                        A = vg.genVector();
                        B = vg.genVector();
                        result= A.DotProduction(A.getVector(),B.getVector());
                    break;
                    case 5:
                        System.out.println("Perform the Value of a Vector");
                        A =vg.genVector();
                        result= A.value();
                    break;
                    default:
                        System.out.println("Invalid Option");
                    break;
                }

        }

}
