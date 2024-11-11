package src.EquationClasses;
import src.Models.CSVReader;
import src.Models.LinearRegression;
import src.Models.ModelApply;

import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws TrigonoValueError, IOException {


       // SolutionClass src = new SolutionClass();

        ModelApply ml = new ModelApply();
        ml.LinearRG("homeprices.csv",5000);


    }
}
