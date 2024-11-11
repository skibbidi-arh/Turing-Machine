package src.Models;

import java.io.FileReader;
import java.io.IOException;

public class ModelApply {

   public ModelApply()
    {

    }

   public void LinearRG(String filename, double pr) throws IOException {
        CSVReader csvReader = new CSVReader(filename);
        LinearRegression lr = new LinearRegression(csvReader.getX(), csvReader.getY());
        lr.prediction(pr);

    }




}
