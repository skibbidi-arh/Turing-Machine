package Display;

import java.util.Scanner;

public class VectorDIsplay {
    public VectorDIsplay() {}
    public void display()
    {
        System.out.println("Solve for Vector: ");
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to do?");
        System.out.println("1.Addition: ");
        System.out.println("2.Subtraction: ");
        System.out.println("3.Dot Product: ");
        System.out.println("4.Cross Product: ");
        System.out.println("5.Resultant: ");
        System.out.println("6.Divergence: ");;
        System.out.println("Give Input: ");
        int choice = sc.nextInt();
    }
}
