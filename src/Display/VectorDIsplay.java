package Display;

import EquationClasses.Divergence;
import EquationClasses.TrigonoValueError;
import EquationClasses.Vector1;

import java.util.Scanner;

public class VectorDIsplay {
    public VectorDIsplay() {}
    public void display() throws TrigonoValueError {
        int dim;
        Vector1 v1, v2,result;
        double angle;
        System.out.println("Solve for Vector: ");
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to do?");
        System.out.println("1.Addition: ");
        System.out.println("2.Subtraction: ");
        System.out.println("3.Angle Between Vectors: ");
        System.out.println("4.Dot Product: ");
        System.out.println("5.Cross Product: ");
        System.out.println("6.Resultant: ");
        System.out.println("7.Divergence: ");;
        System.out.println("Give Input: ");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                System.out.println("Enter Dimention for Vector1: ");
                dim = sc.nextInt();
                v1 = new Vector1(dim);
                System.out.println("Enter Dimention for Vector2: ");
                dim = sc.nextInt();
                v2= new Vector1(dim);
                result= v1.vecAddition(v1.getVector(),v2.getVector());
                result.printVector();
                break;
            case 2:
                System.out.println("Enter Dimention for Vector1: ");
                dim = sc.nextInt();
                v1= new Vector1(dim);
                System.out.println("Enter Dimention for Vector2: ");
                dim = sc.nextInt();
                v2= new Vector1(dim);
                result= v1.vecSubtraction(v1.getVector(),v2.getVector());
                result.printVector();
                break;
            case 3:
                System.out.println("Enter Dimention for Vector1: ");
                dim = sc.nextInt();
                v1= new Vector1(dim);
                System.out.println("Enter Dimention for Vector2: ");
                dim = sc.nextInt();
                v2= new Vector1(dim);
                angle= v1.AngleBetweenVectors(v1,v2);
                System.out.println("Angle: "+angle);
            case 4:
                System.out.println("Enter Dimention for Vector1: ");
                dim = sc.nextInt();
                v1= new Vector1(dim);
                System.out.println("Enter Dimention for Vector2: ");
                dim = sc.nextInt();
                v2= new Vector1(dim);
                double dot= v1.DotProduction(v1.getVector(),v2.getVector());
                System.out.println("Dot Product: "+dot);
                break;
            case 5:
                System.out.println("Enter Dimention for Vector1: ");
                dim = sc.nextInt();
                v1= new Vector1(dim);
                System.out.println("Enter Dimention for Vector2: ");
                dim = sc.nextInt();
                v2= new Vector1(dim);
                result= v1.Cross(v1.getVector(),v2.getVector());
                System.out.print("Cross Product: ");
                result.printVector();
                break;
            case 6:
                System.out.println("Enter Dimention for Vector1: ");
                dim = sc.nextInt();
                v1= new Vector1(dim);
                System.out.println("Enter Dimention for Vector2: ");
                dim = sc.nextInt();
                v2= new Vector1(dim);
                double resultant= v1.Resultant(v1,v2);
                double resultant_angle= v1.ResultantAngle(v1,v2);
                System.out.println("Resultant: "+resultant);
                System.out.println("Resultant Angle: "+resultant_angle);
                break;
            case 7:
                Divergence div = new Divergence();
                div.display();
        }
    }
}
