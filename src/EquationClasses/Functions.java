package src.EquationClasses;
public class Functions {

    public static int max(int a, int b) {

        if(a>b) return a;
        else return b;
    }
    public static double absolute(double x)
    {
        if(x<0)
        {
            return x*(-1);
        }
        else
        {
            return x;
        }
    }
    public static double power(double x, int y)
    {
        double ans=1;
        for(int i=1;i<=y;i++)
        {
            ans=ans*x;
        }
        return ans;
    }
    public static double squareRoot(double x)
    {
        if(x<0)
        {
            x= absolute(x);
        }
        double t;
        double sqrtroot=x/2;
        do
        {
            t=sqrtroot;
            sqrtroot=(t+(x/t))/2;
        }
        while((t-sqrtroot)!= 0);
        return sqrtroot;
    }
    static double cuberoot(double number) {
        double z= absolute(number);
        boolean isNegative= false;
        if(number<0)
        {
            isNegative=true;
        }
        if(z!=(int)z)
        {
            return dubcuberoot(number);
        }
        else {
            int left = 1;
            int right = (int) z;
            int ans = 0;
            while (left <= right) {

                int mid = left + (right-left) / 2;
                if (mid * mid * mid == z) {
                    if (isNegative) {
                        return (-1)*mid;
                    } else {
                        return mid;
                    }
                }
                else if (mid * mid * mid < z) {
                    left = mid + 1;
                    ans = mid;
                } else {
                    right = mid - 1;
                }
            }
            if (isNegative) {
                ans= -ans;
            }
            if (power(ans,3)== number) {
                return ans;
            } else {
                return dubcuberoot(number);
            }
        }
    }


    public static double dubcuberoot(double number) {
        double precision= 0.000000001;
        boolean isNegative = false;
        if (number < 0) {
            isNegative = true;
            number = -number;
        }

        double left = 0;
        double right = number;
        double mid = 0;

        if (number < 1) {
            right = 1;
        }

        while ((right - left) > precision) {
            mid = (left + right) / 2;
            double cube = mid * mid * mid;

            if (cube > number) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if(isNegative)
        {
            return -mid;
        }
        else
        {
            return mid;
        }
    }
    public static double ceiling(double number) {
        if(number>(int) number)
        {
            return (int)number+1;
        }
        else
        {
            return number;
        }
    }

    public static double precisionController(double x)
    {
        double controller= ceiling(x)-x;
        if(controller<0.000001)
        {
            return ceiling(x);
        }
        else
        {
            return x;
        }
    }
    public static double PI()
    {
        return 3.14159265358979323846264338327950288419716939937510;
    }

}
