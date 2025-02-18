package com.ioprogramming.csvdatahandling.intermediateproblems.filterrecords;

import com.opencsv.CSVReader;
import java.io.FileReader;

public class filterRecordsCSV {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/ioprogramming/csvdatahandling/intermediateproblems/filterrecords/studentdetails.csv";

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] student;
            // Skip the header line
            reader.readNext();

            while ((student = reader.readNext()) != null) {
                int marks = Integer.parseInt(student[3]);

                if (marks > 80) {
                    // Print the whole record
                    System.out.println("Record: " + String.join(",", student));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
