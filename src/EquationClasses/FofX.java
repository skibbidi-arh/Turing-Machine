package EquationClasses;

public class
FofX {
    private int[][] a= new int[38][75];
    public FofX() {
    }
    public double fofX1(int[] a, double x) throws TrigonoValueError {
        double x3 = Functions.power(x, 3);
        double x2 = Functions.power(x, 2);

        double inverseTriX3 = a[30] * Inverse.arcsin(x3) + a[31] * Inverse.arccos(x3) + a[32] * Inverse.arctan(x3) + a[33] * Inverse.arcsec(x3) + a[34] * Inverse.arccosec(x3) + a[35] * Inverse.arccot(x3);
        double inverseTriX2 = a[36] * Inverse.arcsin(x2) + a[37] * Inverse.arccos(x2) + a[38] * Inverse.arctan(x2) + a[39] * Inverse.arcsec(x2) + a[40] * Inverse.arccosec(x2) + a[41] * Inverse.arccot(x2);
        double inverseTriX = a[42] * Inverse.arcsin(x) + a[43] * Inverse.arccos(x) + a[44] * Inverse.arctan(x) + a[45] * Inverse.arcsec(x) + a[46] * Inverse.arccosec(x) + a[47] * Inverse.arccot(x);

        double logX = Math.log(x) * (3 * a[21] + 2 * a[22] + a[23] + 2.302585093 * (3 * a[24] + 2 * a[25]) + a[26]) + a[27] * Math.exp(x3) + a[28] * Math.exp(x3) + a[29] * Math.exp(x);

        double trigonometryX = a[15] * Trigonometry.sin(x) + a[16]* Trigonometry.cos(x) + a[17] * Trigonometry.tan(x) + a[18] * Trigonometry.sec(x) + a[19] * Trigonometry.cosec(x) + a[20] * Trigonometry.cot(x);

        double triogonometryX2 = a[9] * Trigonometry.sin(x2) + a[10] * Trigonometry.cos(x2) + a[11] * Trigonometry.tan(x2) + a[12] * Trigonometry.sec(x2) + a[13] * Trigonometry.cosec(x2) + a[14] * Trigonometry.cot(x2);

        double triogonometryX3 = a[3] * Trigonometry.sin(x3) + a[4] * Trigonometry.cos(x3) + a[5] * Trigonometry.tan(x3) + a[6] * Trigonometry.sec(x3) + a[7]* Trigonometry.cosec(x3) + a[8] * Trigonometry.cot(x3);

        double answer1= a[48]*x3*triogonometryX3 +a[49]* x3*triogonometryX2 +a[50]* x3*trigonometryX +a[51]*x3*logX +a[52]* x3*inverseTriX3+a[53]* x3*inverseTriX2+a[54]*x3*inverseTriX;

        double answer2= a[55]*x2*triogonometryX3 +a[56]* x3*triogonometryX2 +a[57]* x2*trigonometryX +a[58]*x2*logX +a[59]* x2*inverseTriX3+a[60]* x2*inverseTriX2+a[61]*x2*inverseTriX;

        double answer3= a[62]*x*triogonometryX3 +a[63]* x*triogonometryX2 +a[64]* x*trigonometryX +a[65]*x*logX +a[66]* x*inverseTriX3+a[67]* x*inverseTriX2+a[68]*x*inverseTriX;

        return a[0]*x3+a[1]*x2+a[2]*x+ a[69]*trigonometryX+ a[70]*triogonometryX2+ a[71]*triogonometryX3+a[72]*logX+ a[73]*inverseTriX+a[74]*inverseTriX2+a[75]*inverseTriX3+ answer1+answer2+answer3;
    }
    public double fofX2(int[][] a, double x) throws TrigonoValueError {
        double x3 = Functions.power(x, 3);
        double x2 = Functions.power(x, 2);
        double triogonometryX3 = a[0][3] * Trigonometry.sin(fofX1(a[1], x)) + a[0][4] * Trigonometry.cos(fofX1(a[2], x)) + a[0][5] * Trigonometry.tan(fofX1(a[3], x)) + a[0][6] * x3 * Trigonometry.sec(fofX1(a[4], x)) + a[0][7] * Trigonometry.cosec(fofX1(a[5], x)) + a[0][8] * Trigonometry.cot(fofX1(a[6], x));

        double trigonometryX2= a[0][9] * Trigonometry.sin(fofX1(a[7], x)) + a[0][10] * Trigonometry.cos(fofX1(a[8], x)) + a[0][11] * Trigonometry.tan(fofX1(a[9], x)) + a[0][12] * Trigonometry.sec(fofX1(a[10], x)) + a[0][13] * Trigonometry.cosec(fofX1(a[11], x)) + a[0][14] * Trigonometry.cot(fofX1(a[12], x));

        double trigonometryX= a[0][15] * Trigonometry.sin(fofX1(a[13], x)) + a[0][16]* Trigonometry.cos(fofX1(a[14], x)) + a[0][17] * Trigonometry.tan(fofX1(a[15], x)) + a[0][18] * Trigonometry.sec(fofX1(a[16], x)) + a[0][19] * Trigonometry.cosec(fofX1(a[17], x)) + a[0][20] * Trigonometry.cot(fofX1(a[18], x));

        double logX = Math.log(fofX1(a[19], x)) * (3 * a[0][21] + 2 * a[0][22] + a[0][23] + 2.302585093 * (3 * a[0][24] + 2 * a[0][25]) + a[0][26]) + a[0][27] * Math.exp(fofX1(a[20], x)) + a[0][29] * Math.exp(fofX1(a[21], x));

        double inverseTriX3 = a[0][30] * Inverse.arcsin(fofX1(a[21], x)) + a[0][31] * Inverse.arccos(fofX1(a[22], x)) + a[0][32] * Inverse.arctan(fofX1(a[23], x)) + a[0][33] * Inverse.arcsec(fofX1(a[24], x)) + a[0][34] * Inverse.arccosec(fofX1(a[25], x)) + a[0][35] * Inverse.arccot(fofX1(a[26], x));

        double inverseTriX2 = a[0][36] * Inverse.arcsin(fofX1(a[27], x)) + a[0][37] * Inverse.arccos(fofX1(a[28], x)) + a[0][38] * Inverse.arctan(fofX1(a[29], x)) + a[0][39] * Inverse.arcsec(fofX1(a[30], x)) + a[0][40] * Inverse.arccosec(fofX1(a[31], x)) + a[0][41] * Inverse.arccot(fofX1(a[32], x));

        double inverseTriX = a[0][42] * Inverse.arcsin(fofX1(a[33], x)) + a[0][43] * Inverse.arccos(fofX1(a[34], x)) + a[0][44] * Inverse.arctan(fofX1(a[35], x)) + a[0][45] * Inverse.arcsec(fofX1(a[36], x)) + a[0][46] * Inverse.arccosec(fofX1(a[37], x)) + a[0][47] * Inverse.arccot(fofX1(a[38], x));

        double answer1 = a[0][48] * x3 * triogonometryX3 + a[0][49] * x3 * trigonometryX2 + a[0][50] * x3 * trigonometryX + a[0][51] * x3 * logX + a[0][52] * x3 * inverseTriX3 + a[0][53] * x3 * inverseTriX2 + a[0][54] * x3 * inverseTriX;

        double answer2 = a[0][55] * x2 * triogonometryX3 + a[0][56] * x3 * trigonometryX2 + a[0][57] * x2 * trigonometryX + a[0][58] * x2 * logX + a[0][59] * x2 * inverseTriX3 + a[0][60] * x2 * inverseTriX2 + a[0][61] * x2 * inverseTriX;

        double answer3 = a[0][62] * x * triogonometryX3 + a[0][63] * x * trigonometryX2 + a[0][64] * x * trigonometryX + a[0][65] * x * logX + a[0][66] * x * inverseTriX3 + a[0][67] * x * inverseTriX2 + a[0][68] * x * inverseTriX;

        return a[0][0] * x3 + a[0][1] * x2 + a[0][2] * x + a[0][69] * trigonometryX + a[0][70] * trigonometryX2 + a[0][71] * triogonometryX3 + a[0][72] * logX + a[0][73] * inverseTriX + a[0][74] * inverseTriX2 + a[0][75] * inverseTriX3 + answer1 + answer2 + answer3;
    }
}
