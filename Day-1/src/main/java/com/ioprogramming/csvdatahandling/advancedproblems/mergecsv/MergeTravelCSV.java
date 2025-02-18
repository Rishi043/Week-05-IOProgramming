package com.ioprogramming.csvdatahandling.advancedproblems.mergecsv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MergeTravelCSV {
    public static void main(String[] args) {
        String filePath1 = "src/main/java/com/ioprogramming/csvdatahandling/advancedproblems/mergecsv/travel1.csv";
        String filePath2 = "src/main/java/com/ioprogramming/csvdatahandling/advancedproblems/mergecsv/travel2.csv";
        String outputFilePath = "src/main/java/com/ioprogramming/csvdatahandling/advancedproblems/mergecsv/merged_travel.csv";
        Map<String, String[]> travelMap = new HashMap<>();

        try (CSVReader reader1 = new CSVReader(new FileReader(filePath1))) {
            String[] line;
            reader1.readNext(); // Skip the header

            while ((line = reader1.readNext()) != null) {
                travelMap.put(line[0], line);
            }
        } catch (Exception e) {
            System.err.println("An error occurred while processing file: " + filePath1);
            e.printStackTrace();
        }

        try (CSVReader reader2 = new CSVReader(new FileReader(filePath2))) {
            String[] line;
            reader2.readNext(); // Skip the header

            while ((line = reader2.readNext()) != null) {
                String[] travel1 = travelMap.get(line[0]);
                if (travel1 != null) {
                    String[] merged = new String[]{travel1[0], travel1[1], travel1[2], line[1], line[2]};
                    travelMap.put(line[0], merged);
                }
            }
        } catch (Exception e) {
            System.err.println("An error occurred while processing file: " + filePath2);
            e.printStackTrace();
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath))) {
            // Add header
            String[] header = {"ID", "Destination", "Duration", "Cost", "Rating"};
            writer.writeNext(header);

            for (String[] travel : travelMap.values()) {
                writer.writeNext(travel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
