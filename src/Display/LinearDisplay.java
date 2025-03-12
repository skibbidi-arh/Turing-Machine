package Display;

import EquationClasses.LinearRegex;

import java.util.Scanner;

public class LinearDisplay {
    public LinearDisplay() {}
    public void linearDisplay() {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many variables do you want to solve: ");
        int n = sc.nextInt();
        char c ;
        System.out.print("The equation structure is: ");
        for(int i = 0; i < n; i++) {
            c = (char)('a'+i);
            if(i<n-1)
            {
                System.out.print(c+ "x" +i+"+");
            }
            else
            {
                System.out.print(c+"x"+i+"=");
            }
        }
        System.out.println("constant");
        LinearRegex lr = new LinearRegex();
        lr.take(n);

    }
}
