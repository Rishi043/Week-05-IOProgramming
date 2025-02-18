package com.ioprogramming.csvdatahandling.advancedproblems.readlargecsv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateAndReadLargeCSV {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/ioprogramming/csvdatahandling/advancedproblems/readlargecsv/large_file.csv";
        int numberOfRecords = 1000000; // Adjust the number of records to create a large file
        int chunkSize = 100;

        // Generate the large CSV file
        try (FileWriter writer = new FileWriter(filePath)) {
            // Write header
            writer.write("ID,Name,Age,Location\n");

            Random random = new Random();
            for (int i = 1; i <= numberOfRecords; i++) {
                String id = String.format("%07d", i);
                String name = "Name" + i;
                int age = random.nextInt(60) + 18; // Random age between 18 and 77
                String location = "Location" + random.nextInt(100);
                writer.write(id + "," + name + "," + age + "," + location + "\n");
            }

            System.out.println("Large CSV file created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Read and process the large CSV file in chunks
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            int recordCount = 0;

            while ((line = reader.readNext()) != null) {
                for (int i = 0; i < chunkSize && line != null; i++) {
                    // Process the line (example: print it)
                    System.out.println(String.join(", ", line));
                    line = reader.readNext();
                    recordCount++;
                }
                // Display the count of records processed so far
                System.out.println("Records processed: " + recordCount);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

