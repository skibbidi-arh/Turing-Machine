package src.Models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {


    String filepath;
    public double[] x=new double[10000];
    public double[] y=new double[10000];

    public CSVReader(String filepath) throws IOException {
        this.filepath = filepath;
        readcsv();
    }


    void readcsv() throws IOException {
        int n =0;
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(this.filepath))) {

            line = br.readLine();
            if (line.charAt(0) == '\uFEFF') {
                line = line.substring(1);
            }

            // Read the first line and process if not empty
            if (line != null) {
                String[] values = line.split(",");
                x[n] = Double.parseDouble(values[0]);
                y[n] = Double.parseDouble(values[1]);

                n++;
            }

            while((line= br.readLine()) != null) {

                 String[] values = line.split(",");
                 x[n] = Double.parseDouble(values[0]);
                 y[n] = Double.parseDouble(values[1]);


             }
             n++;

            }

        }


    double[] getX() {
        return x;
    }
    double[] getY() {
        return y;
    }



}
