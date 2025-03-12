package EquationClasses;

public class PartialDiff {
    public PartialDiff() {}

    public static int[] dX(int[] x)
    {
        int[] dX = new int[x.length];
        dX[0]= x[0]*x[1]; // changing coeffiecnts
        dX[1]= x[1]-1;
        return dX;
    }
    public static int[] dY(int[] y)
    {
        int[] dY = new int[y.length];
        dY[0]= y[0]*y[2];
        dY[2]= y[2]-1;
        return dY;
    }
    public static int[] dZ(int[] z)
    {
        int[] dZ = new int[z.length];
        dZ[0]= z[0]*z[3];
        dZ[3]= z[3]-1;
        return dZ;
    }
}
