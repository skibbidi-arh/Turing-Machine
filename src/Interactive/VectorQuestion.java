package Interactive;

import EquationClasses.TrigonoValueError;
import EquationClasses.Vector1;

import java.util.Random;

public class VectorQuestion {
    public VectorQuestion() {}
        Random rand = new Random();
        ResultMatcher rm= ResultMatcher.getMatcher();
        Vector1 A;
        Vector1 B;
        VectorGen vg = new VectorGen();
        double result;
        Vector1 resvec;
    public void GenerateOption() throws TrigonoValueError {
                    int option = rand.nextInt(6);
                    int i=0;
                switch (option){
                    case 0:
                        System.out.println("Perform the Addition of Two Vectors");
                        A = vg.genVector();
                        vg= new VectorGen();
                        B= vg.genVector();
                        A.printVector();
                        B.printVector();
                        resvec= A.vecAddition(A.getVector(), B.getVector());
                        rm.TakeVector(resvec,i);

                        break;
                    case 1:
                        System.out.println("Perform the Subtraction of Two Vectors");
                        A = vg.genVector();
                        vg= new VectorGen();
                        B= vg.genVector();
                        A.printVector();
                        B.printVector();
                        result= A.DotProduction(A.getVector(),B.getVector());
                        rm.TakeInput(result,i);
                        break;
                    case 2:
                        System.out.println("Perform the Value of a Vector");
                        A =vg.genVector();
                        A.printVector();
                        result= A.value();
                        rm.TakeInput(result,i);
                        break;
                    case 3:
                        System.out.println("What is the angle between the following vector");
                        A = vg.genVector();
                        vg= new VectorGen();
                        B= vg.genVector();
                        A.printVector();
                        B.printVector();
                        result= A.AngleBetweenVectors(A,B);
                        rm.TakeInput(result,i);
                        break;
                    case 4:
                        System.out.println("Perform the DotProduct of Two Vectors");
                        A = vg.genVector();
                        vg= new VectorGen();
                        B = vg.genVector();
                        A.printVector();
                        B.printVector();
                        result= A.DotProduction(A.getVector(),B.getVector());
                        rm.TakeInput(result,i);
                        break;
                    case 5:
                        System.out.println("Perform the Cross of Two Vectors");
                        A = vg.genVector();
                        vg= new VectorGen();
                        B = vg.genVector();
                        A.printVector();
                        B.printVector();
                        resvec= A.Cross(A.getVector(),B.getVector());
                        rm.TakeVector(resvec,i);
                        break;
                    case 6:
                        System.out.println("What is the resultant and degree resultant has with Vector1");
                        A = vg.genVector();
                        vg= new VectorGen();
                        B = vg.genVector();
                        A.printVector();
                        B.printVector();
                        double result= A.Resultant(A,B);
                        double resultAngle= A.ResultantAngle(A,B);
                        rm.CheckResultantDegree(result,resultAngle,i);
                        break;
                    default:
                        System.out.println("Invalid Option");
                    break;
                }

        }

}
