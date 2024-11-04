
public class Main {
    public static void main(String[] args) throws TrigonoValueError {

Inverse i = new Inverse();


    /* Trigonometry t1 = new Trigonometry();
     Scanner sc = new Scanner(System.in);

       System.out.println(t1.sin(628));
        System.out.println(t1.cos(30));
        double x= sc.nextDouble();
        for(int b=0;x!=1234;b++){

            System.out.println(t1.cot(x));
             x=sc.nextDouble();
        } */

Inverse i2 = new Inverse();
        System.out.println( i2.arccosec(3244));

        double[] coefficients = {1,0,-1,0};  // Coefficients for x^3 - 1

        // Find the roots
        Complex[] roots = DurandKerner.durandKerner(coefficients, 1e-6, 1000);


        System.out.println("Roots found:");
        for (Complex root : roots) {
            System.out.println(root);
        }
    }
    }
