package Display;

import java.util.Scanner;

public class MatrixDisplay {
    public MatrixDisplay() {}
    public void display(){
        System.out.println("Solve for Matrix: ");
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to do?");
        System.out.println("1.Addition: ");
        System.out.println("2.Subtraction: ");
        System.out.println("3.Multiplication: ");
        System.out.println("4.Inverse Matrix: ");
        System.out.println("5.LU Decomposition: ");
        System.out.println("6.Elemination Matrix: ");
        System.out.println("Give Input: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:

        }

    }
}
