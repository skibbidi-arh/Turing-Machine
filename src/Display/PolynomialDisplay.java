package Display;

import EquationClasses.DurandKerner;

import java.util.Scanner;

public class PolynomialDisplay {
    public PolynomialDisplay() {}
    public void displayPolynomial() {
        Scanner input = new Scanner(System.in);
        char c;
        System.out.println("Enter the Highest Power: ");
        int highestPower = input.nextInt();
        System.out.print("The equation structure will be: ");
        for (int i = 0; i < highestPower; i++) {
            c= (char)('a'+i);
            if(i<highestPower-1)
            {
                System.out.print(c+"x^"+(highestPower - i)+"+");
            }
            else
            {
                System.out.println(c+"x"+"= constant");
            }
        }
        DurandKerner durandKerner = new DurandKerner();
        durandKerner.solve(highestPower);
    }
}
