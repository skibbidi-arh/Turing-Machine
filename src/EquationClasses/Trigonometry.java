package EquationClasses;

import EquationClasses.Functions;

public static class Trigonometry {

    static double  PI =3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679;

    Trigonometry() {
    }

    public static double DegreeToRadian(double degree) {
        return degree * PI/ 180;
    }

    public static double RadianToDegrees(double radians) {
        return radians * 180 /  PI;
    }


    public static double power(double base, int exponent) {
        // Handle the case where exponent is 0 (anything to the power of 0 is 1)
        if (exponent == 0) {
            return 1;
        }


        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }

        // Result to store the final answer
        double result = 1;


        for (int i = 0; i < exponent; i++) {
            result *= base;
        }

        return result;
    }


    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static double sin(double x) {

        if(x>360){

            double s= x/360;
            x=x-360*(int)s;


        }

        if (x == 0) {
            return 0;
        } else if (x == 30) {
            return 0.5;
        } else if (x == 60) {
            return Functions.squareRoot(3) / 2;
        } else if (x == 90) {
            return 1.0;
        } else if (x == 180) {
            return 0;
        } else if (x == 270) {
            return -1;
        } else if (x == 360) {
            return 0;
        }
        double d =1;
        if(x>90 && x<180){
            x=180-x;
            d=1;
        }
        else if(x>180 && x<270){
            x=x-180;
            d=-1;
        }
        if(x>270 && x<360){
            x=180-x;
            d=-1;
        }

        x=DegreeToRadian(x);
        double result =0;
        int k=2;
        for (int n=1; n<60;n=n+2)
        {

            result = result + (power(x,n)/factorial(n))*power(-1,k);

            k++;


        }
        return result*d;

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static  double cos(double x) {

        if (x > 360) {
            double s = x / 360;
            x = x - 360 * (int) s;
        }
        double y =x;
        if (y == 0) {
            return 1.0;
        } else if (y == 30) {
            return 0.866;
        } else if (y == 60) {
            return 0.5;
        } else if (y == 90) {
            return 0;
        } else if (y == 180) {
            return -1;
        } else if (y == 270) {
            return 0;
        } else if (y == 360) {
            return 1.0;
        }

        double d = 1;
        if (x > 90 && x < 180) {
            x = 180 - x;
            d = -1;
        } else if (x > 180 && x < 270) {
            x = x - 180;
            d = -1;
        } else if (x > 270 && x < 360) {
            x = 360 - x;
            d = 1;
        }

        x = DegreeToRadian(x);
        double result = 0;
        int k = 2;
        for (int n = 0; n < 60; n = n + 2) {

            result = result + (power(x, n) / factorial(n)) * power(-1, k);

            k++;
        }
        return result * d;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static double tan(double x) throws  TrigonoValueError{
        if (x > 180) {
            double s = x / 180;
            x = x - 180 * (int) s;
        }
        double result ;

        if (x == 0) {
            return 0.0;
        } else if (x == 30) {
            return 0.577;  // tan(30°) = 1/√3 ≈ 0.577
        } else if (x == 45) {
            return 1.0;    // tan(45°) = 1
        } else if (x == 60) {
            return 1.732;  // tan(60°) = √3 ≈ 1.732
        } else if (x == 90) {
            throw new TrigonoValueError("tan(90°) is undefined");  // tan(90°) is undefined
        } else if (x == 180) {
            return 0.0;
        } else if (x == 270) {
            throw new TrigonoValueError("tan(270°) is undefined"); // tan(270°) is undefined
        } else if (x == 360) {
            return 0.0;
        }

        result = sin(x)/cos(x);

        return result;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static double cot(double x) throws  TrigonoValueError{
        if (x == 0) {
            throw new TrigonoValueError("cot(0°) is undefined");    // cot(0°) is undefined
        } else if (x == 30) {
            return 1.732;    // cot(30°) = √3 ≈ 1.732
        } else if (x == 45) {
            return 1.0;      // cot(45°) = 1
        } else if (x == 60) {
            return 0.577;    // cot(60°) = 1/√3 ≈ 0.577
        } else if (x == 90) {
            return 0.0;      // cot(90°) = 0
        } else if (x == 180) {
            throw new TrigonoValueError("cot(180°) is undefined");   // cot(180°) is undefined
        } else if (x == 270) {
            return 0.0;      // cot(270°) = 0
        } else if (x == 360) {
            throw new TrigonoValueError("cot(360°) is undefined");   // cot(360°) is undefined
        }

        return 1/tan(x);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static double cosec(double x) throws  TrigonoValueError{
        if (x == 0) {
            throw new TrigonoValueError("cosec(0°) is undefined");    // cosec(0°) is undefined
        } else if (x == 30) {
            return 2.0;    // cosec(30°) = 2
        } else if (x == 45) {
            return 1.414;  // cosec(45°) = √2 ≈ 1.414
        } else if (x == 60) {
            return 1.154;  // cosec(60°) ≈ 1.1547
        } else if (x == 90) {
            return 1.0;    // cosec(90°) = 1
        } else if (x == 180) {
            throw new TrigonoValueError("cosec(180°) is undefined");  // cosec(180°) is undefined
        } else if (x == 270) {
            return -1.0;   // cosec(270°) = -1
        } else if (x == 360) {
            throw new TrigonoValueError("cosec(360°) is undefined");  // cosec(360°) is undefined
        }

        return 1/sin(x);

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static double sec(double x) throws  TrigonoValueError{
        if (x == 0) {
            return 1.0;     // sec(0°) = 1
        } else if (x == 30) {
            return 1.154;   // sec(30°) ≈ 1.1547
        } else if (x == 45) {
            return 1.414;   // sec(45°) = √2 ≈ 1.414
        } else if (x == 60) {
            return 2.0;     // sec(60°) = 2
        } else if (x == 90) {
            throw new TrigonoValueError("sec(90°) is undefined");    // sec(90°) is undefined
        } else if (x == 180) {
            return -1.0;    // sec(180°) = -1
        } else if (x == 270) {
            throw new TrigonoValueError("sec(270°) is undefined");   // sec(270°) is undefined
        } else if (x == 360) {
            return 1.0;     // sec(360°) = 1
        }

        return 1/cos(x);

    }


    public static Trigonometry createTrigonometry() {
        return new Trigonometry();
    }
}
