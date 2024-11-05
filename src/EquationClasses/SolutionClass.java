package src.EquationClasses;
import java.util.*;

public class SolutionClass {
    Scanner sc = new Scanner(System.in);

    public SolutionClass() throws TrigonoValueError {
        print();

    }
    void print() throws TrigonoValueError {
        System.out.println("1- linear equation");

        System.out.println("2- polynomial function");

        System.out.println("3- Trigonometric values");

        scan();
    }

    void scan() throws TrigonoValueError {
        Scanner sc= new Scanner(System.in);
        int s = sc.nextInt();
        switch(s)
        {
            case 1:
                linear();
                break;
            case 2:
                pol();
                break;
            case 3:
                trigonometry();
                break;



        }

    }

    void linear() throws TrigonoValueError {

        LinearRegex lr = new LinearRegex();
        lr.take();
        System.out.println("1- do linear solve again");
        System.out.println("2 - go back");
        int s = sc.nextInt();
        if(s == 1)linear();
        else if (s == 2) {
            print();
        }
    }


    void trigonometry() throws TrigonoValueError {
        System.out.println("1 - trigonometric values");
        System.out.println("2 - inverse trigonometric values");
        System.out.println("3- back");
        int t = sc.nextInt();
        switch(t)
        {
            case 1:
                tri();
                break;
            case 2:
                invertri();
                break;
            case 3:
                print();

        }
    }


    void tri() throws TrigonoValueError {
        Trigonometry tr = new Trigonometry();
        System.out.println("1 - sin ");
        System.out.println("2 - cos ");
        System.out.println("3 - tan ");
        System.out.println("4 - cot ");
        System.out.println("5 - sec ");
        System.out.println("6 - cosec ");
        System.out.println("0 - go back");
        int n= sc.nextInt();
        System.out.println("Enter angle in degrees :");
        double a = sc.nextDouble();
        switch(n)
        {
            case 1:
                System.out.println(tr.sin(a));
                break;
            case 2:
                System.out.println(tr.cos(a));
                break;
            case 3:
                System.out.println(tr.tan(a));
                break;
            case 4:
                System.out.println(tr.cot(a));
                break;
            case 5:
                System.out.println(tr.sec(a));
                break;
            case 6:
                System.out.println(tr.cosec(a));
                break;

        }

        System.out.println("1- get trigonometric values again");
        System.out.println("2 - go back");
        int s = sc.nextInt();
        if(s == 1)tri();
        else if (s == 2) {
            trigonometry();
        }

    }

    void invertri() throws TrigonoValueError {
        Inverse tr = new Inverse();
        System.out.println("1 - arcsin ");
        System.out.println("2 - arccos ");
        System.out.println("3 - arctan ");
        System.out.println("4 - arccot ");
        System.out.println("5 - arcsec ");
        System.out.println("6 - arccosec ");
        System.out.println("0 - go back");

        int n = sc.nextInt();
        System.out.println("Enter value :");
        double val = sc.nextDouble();

        switch(n) {
            case 1:
                System.out.println(tr.arcsin(val));
                break;
            case 2:
                System.out.println(tr.arccos(val));
                break;
            case 3:
                System.out.println(tr.arctan(val));
                break;
            case 4:
                System.out.println(tr.arccot(val));
                break;
            case 5:
                System.out.println(tr.arcsec(val));
                break;
            case 6:
                System.out.println(tr.arccosec(val));
                break;
            case 0:
                trigonometry();
                return;
            default:
                System.out.println("Invalid option.");
                break;
        }

        System.out.println("1 - get inverse trigonometric values again");
        System.out.println("2 - go back");
        int s = sc.nextInt();
        if (s == 1) invertri();
        else if (s == 2) {
            trigonometry();
        }
    }


    void pol()
    {



    }

}
