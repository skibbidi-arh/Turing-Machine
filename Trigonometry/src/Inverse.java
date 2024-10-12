public class Inverse extends Trigonometry {




    //////////////////////////////////////////////////////////
    public  double Arctan(double x) {
        double result ;
        result= x
                - (power(x, 3) / 3)
                + (power(x, 5) / 5)
                - (power(x, 7) / 7)
                + (power(x, 9) / 9)
                - (power(x, 11) / 11)
                + (power(x, 13) / 13)
                - (power(x, 15) / 15)
                + (power(x, 17) / 17)
                - (power(x, 19) / 19);

        return result*180/Math.PI;
    }

    public  double arcsin(double x ) throws TrigonoValueError {
       int terms = 50;
        if (x < -1 || x > 1) {
            throw new TrigonoValueError("x must be in the range -1 to 1");
        }

        double result = 0;

        for (int n = 0; n < terms; n++) {
            long numerator = factorial(2 * n);
            long denominator = (long) (power(4, n) * power(factorial(n), 2) * (2 * n + 1));
            double term = (double) numerator / denominator * Math.pow(x, 2 * n + 1);
            result += term;
        }

        return RadianToDegrees(result);
    }






}


