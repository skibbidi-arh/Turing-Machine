package src.Models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    private String filepath;
    private List<Double> x = new ArrayList<>();
    private List<Double> y = new ArrayList<>();

    public CSVReader(String filepath) throws IOException {
        this.filepath = filepath;
        readcsv();
    }

    private void readcsv() throws IOException {
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(this.filepath))) {

            line = br.readLine();
            if (line.charAt(0) == '\uFEFF') {
                line = line.substring(1);
            }

            // Read the first line and process if not empty
            if (line != null) {
                String[] values = line.split(",");
                x.add(Double.parseDouble(values[0]));
                y.add(Double.parseDouble(values[1]));
            }

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                x.add(Double.parseDouble(values[0]));
                y.add(Double.parseDouble(values[1]));
            }
        }
    }

    public List<Double> getX() {
        return x;
    }

    public List<Double> getY() {
        return y;
    }
}
