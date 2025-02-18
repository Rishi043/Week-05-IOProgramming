package com.ioprogramming.csvdatahandling.advancedproblems.detectduplicates;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DetectDuplicatesCSV {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/ioprogramming/csvdatahandling/advancedproblems/detectduplicates/records.csv";
        Map<String, String> recordsMap = new HashMap<>();
        Map<String, Integer> duplicates = new HashMap<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            reader.readNext(); // Skip the header

            while ((line = reader.readNext()) != null) {
                String id = line[0];
                if (recordsMap.containsKey(id)) {
                    duplicates.put(id, duplicates.getOrDefault(id, 1) + 1);
                } else {
                    recordsMap.put(id, String.join(", ", line));
                }
            }

            // Print all duplicate records
            if (duplicates.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate records:");
                for (String duplicateId : duplicates.keySet()) {
                    System.out.println(recordsMap.get(duplicateId));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
