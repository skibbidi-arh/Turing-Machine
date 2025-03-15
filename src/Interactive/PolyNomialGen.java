package Interactive;

import java.util.Random;

public class PolyNomialGen {
    Random rand = new Random();
    double[] values;
    public PolyNomialGen() {
    }
    public double[] generate() {

        int highestPower= rand.nextInt(2,4);
        values= new double[highestPower+1];
        for(int i = 0;i <= highestPower;i++) {
            values[i] = rand.nextDouble();
        }
        return values;
    }



}
