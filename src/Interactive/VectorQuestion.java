package Interactive;

import EquationClasses.TrigonoValueError;
import EquationClasses.Vector1;

import java.util.Random;

public class VectorQuestion {
    public VectorQuestion() {}
        Random rand = new Random();
        Vector1 A;
        Vector1 B;
        VectorGen vg = new VectorGen();
        double result;
        Vector1 resvec;
    public void GenerateOption() throws TrigonoValueError {
                    int option = rand.nextInt(6);
                switch (option){
                    case 1:
                        System.out.println("Perform the Addition of Two Vectors");
                        A = vg.genVector();
                        B= vg.genVector();
                        A.printVector();
                        B.printVector();
                        resvec= A.vecAddition(A.getVector(), B.getVector());
                        break;
                    case 2:
                        System.out.println("Perform the Subtaction of Two Vectors");
                        A = vg.genVector();
                        B= vg.genVector();
                        A.printVector();
                        B.printVector();
                        result= A.DotProduction(A.getVector(),B.getVector());
                        break;
                    case 3:
                        System.out.println("Perform the Value of a Vector");
                        A =vg.genVector();
                        A.printVector();
                        result= A.value();
                        break;
                    case 4:
                        System.out.println("What is the angle between the following vector");
                        A = vg.genVector();
                        B= vg.genVector();
                        A.printVector();
                        B.printVector();
                        result= A.AngleBetweenVectors(A,B);
                        break;
                    case 5:
                        System.out.println("Perform the DotProduct of Two Vectors");
                        A = vg.genVector();
                        B = vg.genVector();
                        A.printVector();
                        B.printVector();
                        result= A.DotProduction(A.getVector(),B.getVector());
                        break;
                    case 6:
                        System.out.println("Perform the Cross of Two Vectors");
                        A = vg.genVector();
                        B = vg.genVector();
                        A.printVector();
                        B.printVector();
                        resvec= A.Cross(A.getVector(),B.getVector());

                        break;
                    case 7:
                        System.out.println("What is the resultant and degree resultant has with Vector1");
                        A = vg.genVector();
                        B = vg.genVector();
                        A.printVector();
                        B.printVector();
                        double result= A.Resultant(A,B);
                        double resultAngle= A.ResultantAngle(A,B);
                        break;
                    default:
                        System.out.println("Invalid Option");
                    break;
                }

        }

}
