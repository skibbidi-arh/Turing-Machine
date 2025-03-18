package EquationClasses;

import java.util.ArrayList;
import java.util.List;

public class BrentsMethod {

    private double tol= 1e-7;
    private double interval= 0.1;
    private double min= -10;
    private double max= 10;
    private FunctionTaker f;

    public BrentsMethod(String eqn) {
        f=new FunctionTaker();
        f.setFunction(eqn);
    }
    private double brent(double a, double b)
    {
        double fa= f.f(a);
        double fb= f.f(b);
        if(fa*fb>=0)
        {
            throw  new IllegalArgumentException("Interval function is not working");
        }

        double c= a;
        double fc= fa;
        boolean flag= true;
        double d=0, s=0, fs;
        while(Functions.absolute(b-a)>tol)
        {
            double Sn= s;
            if(fa!= fc & fb!= fc)
            {
                s = a * fb * fc / ((fa - fb) * (fa - fc)) + b * fa * fc / ((fb - fa) * (fb - fc)) + c * fa * fb / ((fc - fa) * (fc - fb));
            }
            else
            {
                s= b-fb*(b-a)/(fb-fa);
            }

            boolean con1 = (s < (3 * a + b) / 4 || s > b);
            boolean con2 = flag && Functions.absolute(s - b) >= Functions.absolute(b - c) / 2;
            boolean con3 = !flag && Functions.absolute(s - b) >= Functions.absolute(c - d) / 2;
            boolean con4 = flag && Functions.absolute(b - c) < tol;
            boolean con5 = !flag && Functions.absolute(c - d) < tol;

            if(con1 || con2 || con3 || con4 || con5)
            {
                s=(a+b)/2;
                flag= true;
            }
            else
            {
                flag= false;
            }

            fs= f.f(s);
            d=c;
            c=b;
            fc=fb;
            if(fa*fs<0)
            {
                b=s;
                fb=fs;
            }
            else
            {
                a=s;
                fa=fs;
            }
            if(Functions.absolute(fa)<Functions.absolute(fb))
            {
                double temp= a;
                a=b;
                b=temp;
                temp= fa;
                fa=fb;
                fb= temp;
            }

        }
        return b;
    }
    public List<Double[]> intervals()
    {
        List<Double[]> list= new ArrayList<Double[]>();
        double a=min;
        double fa= f.f(a);
        for(double b= a+interval; b<=max; b+=interval)
        {
            double fb= f.f(b);
            if(fb*fa<0)
            {
                list.add(new Double[] {a,b});
            }
            a=b;
            fa=fb;
        }
        return list;
    }

    public double[] answers()
    {
        List<Double[]> list= intervals();
        double[] ans= new double[list.size()];
        int i=0;
        for(Double[] interval: list)
        {
            double root= brent(interval[0], interval[1]);
            ans[i]= root;
            i++;
        }
        return ans;
    }

    public void answerPrint()
    {
        double[] ans= answers();
        for (int i=0; i<ans.length; i++)
        {
            System.out.println("Root: "+ans[i]);
        }
    }

}
