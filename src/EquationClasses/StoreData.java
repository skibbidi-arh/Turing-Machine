package EquationClasses;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class StoreData {
    public void Store() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your number: ");
        String number = scanner.nextLine();

        System.out.print("Enter the name of the topic: ");
        String topic = scanner.nextLine();

        String date = LocalDate.now().toString();

        String data = name + "," + number + "," + topic + "," + date;

        try (FileWriter writer = new FileWriter("stored_data.txt", true)) {
            writer.write(data + "\n");
            System.out.println("Data saved successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while saving data.");
            e.printStackTrace();
        }
    }

    public void searchRecords(String name) {
        System.out.print("Enter a name to search records: ");
        try (BufferedReader reader = new BufferedReader(new FileReader("stored_data.txt"))) {
            String line;
            boolean found = false;
            System.out.println("Records for " + name + ":");
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(name)) {
                    System.out.println("Topic: " + parts[2] + " || Marks: " + parts[1] + " || Date: " + parts[3]);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No records found for " + name);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading records.");
            e.printStackTrace();
        }
    }

    public void showLeaderboard(String topic) {
        List<String[]> records = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("stored_data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[2].equals(topic)) {
                    records.add(parts);
                }
            }

            records.sort((a, b) -> Integer.compare(Integer.parseInt(b[1]), Integer.parseInt(a[1])));

            System.out.println("Leaderboard for Topic: " + topic);
            for (String[] record : records) {
                System.out.println("Name: " + record[0] + " || Marks: " + record[1] + " || Date: " + record[3]);
            }

            if (records.isEmpty()) {
                System.out.println("No records found for the topic: " + topic);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading records.");
            e.printStackTrace();
        }
    }

    public void calculateAverageMarks(String name, String topic) {
        int totalMarks = 0, count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("stored_data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(name) && parts[2].equals(topic)) {
                    totalMarks += Integer.parseInt(parts[1]);
                    count++;
                }
            }
            if (count > 0) {
                System.out.println("Average Marks for " + name + " in " + topic + " : " + (totalMarks / (double) count));
            } else {
                System.out.println("No records found for " + name + " in " + topic);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading records.");
            e.printStackTrace();
        }
    }
}
