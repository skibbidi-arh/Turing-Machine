public class Inverse {

    public  double power(double base, int exponent) {
        // Handle the case where exponent is 0 (anything to the power of 0 is 1)
        if (exponent == 0) {
            return 1;
        }

        // Handle negative exponents by taking the reciprocal
        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }

        // Result to store the final answer
        double result = 1;

        // Multiply the base 'exponent' times
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }

        return result;
    }


    //////////////////////////////////////////////////////////
    public  double Arctan(double x) {
        return x
                - (power(x, 3) / 3)
                + (power(x, 5) / 5)
                - (power(x, 7) / 7)
                + (power(x, 9) / 9)
                - (power(x, 11) / 11)
                + (power(x, 13) / 13)
                - (power(x, 15) / 15)
                + (power(x, 17) / 17)
                - (power(x, 19) / 19);
    }

}
