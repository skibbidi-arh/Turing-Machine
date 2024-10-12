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

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public  double arcsin(double x ) throws TrigonoValueError {
       int terms = 50;
        if (x < -1 || x > 1) {
            throw new TrigonoValueError("x must be in the range -1 to 1");
        }
        if (x == 0) {
            return 0.0;              // arcsin(0) = 0
        } else if (x == 0.5) {
            return 30;      // arcsin(0.5) = 30 degrees = π/6 radians
        } else if (x == Math.sqrt(2)/2) {
            return 45;      // arcsin(√2 / 2) = 45 degrees = π/4 radians
        } else if (x == Math.sqrt(3)/2) {
            return 60;      // arcsin(√3 / 2) = 60 degrees = π/3 radians
        } else if (x == 1) {
            return 90;      // arcsin(1) = 90 degrees = π/2 radians
        } else if (x == -0.5) {
            return -30;     // arcsin(-0.5) = -30 degrees = -π/6 radians
        } else if (x == -Math.sqrt(2)/2) {
            return -45;     // arcsin(-√2 / 2) = -45 degrees = -π/4 radians
        } else if (x == -Math.sqrt(3)/2) {
            return -60;     // arcsin(-√3 / 2) = -60 degrees = -π/3 radians
        } else if (x == -1) {
            return -90;     // arcsin(-1) = -90 degrees = -π/2 radians
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



//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public double arccos(double x ) throws TrigonoValueError {
        return 90-arcsin(x);
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public double arctan(double x) throws TrigonoValueError {
        int terms = 50;
        boolean isLarge = false;


        if (x > 1) {
            x = 1 / x;
            isLarge = true;
        } else if (x < -1) {
            x = 1 / x;
            isLarge = true;
        }


        if (x == 0) {
            return 0.0;
        } else if (x == 1) {
            return 45;
        } else if (x == -1) {
            return -45;
        }

        double result = 0;


        for (int n = 0; n < terms; n++) {
            double term = Math.pow(-1, n) * Math.pow(x, 2 * n + 1) / (2 * n + 1);
            result += term;
        }

        result = RadianToDegrees(result);

        // If we handled a large x value, adjust using the identity
        if (isLarge) {
            return 90 - result;  // π/2 radians = 90 degrees
        }

        return result;
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public double arccot(double x ) throws TrigonoValueError {
        return 90- arctan(x);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public double arcsec(double x) throws TrigonoValueError {
        int terms = 50;

        if (Math.abs(x) < 1) {
            throw new TrigonoValueError("arcsec(x) is undefined for |x| < 1");
        }
        if (x == 1) {
            return 0.0;           // arcsec(1) = 0 degrees
        } else if (x == Math.sqrt(2)) {
            return 45;            // arcsec(√2) = 45 degrees = π/4 radians
        } else if (x == 2) {
            return 60;            // arcsec(2) = 60 degrees = π/3 radians
        } else if (x == 3) {
            return 70.528;        // arcsec(3) ≈ 70.528 degrees
        } else if (x == Math.sqrt(2)/2) {
            return 135;           // arcsec(√2/2) = 135 degrees
        } else if (x == -Math.sqrt(2)) {
            return 135;           // arcsec(-√2) = 135 degrees = 3π/4 radians
        } else if (x == -2) {
            return 120;           // arcsec(-2) = 120 degrees = 2π/3 radians
        } else if (x == -3) {
            return 109.472;       // arcsec(-3) ≈ 109.472 degrees
        } else if (x == -1) {
            return 180.0;         // arcsec(-1) = 180 degrees
        }

        if (x == 1) {
            return 0.0;
        } else if (x == -1) {
            return 180.0;
        }

        double inverse = 1 / x;
        double result = 0;

        for (int n = 0; n < terms; n++) {
            double term = (factorial(2 * n) / Math.pow(4, n) / Math.pow(factorial(n), 2) / (2 * n + 1)) * Math.pow(inverse, 2 * n + 1);
            result += term;
        }

        result = RadianToDegrees(result);
        if(x>1) return 90-result;

        return result;
    }


}


