package com.ioprogramming.csvdatahandling.advancedproblems.jsoncsv;

import com.opencsv.CSVReader;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CsvToJsonConverter {
    public static void main(String[] args) {
        String csvFilePath = "src/main/java/com/ioprogramming/csvdatahandling/advancedproblems/jsontocsv/students.csv";
        String jsonFilePath = "src/main/java/com/ioprogramming/csvdatahandling/advancedproblems/jsontocsv/students_converted.json";

        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            String[] line;
            reader.readNext(); // Skip the header

            JSONArray jsonArray = new JSONArray();

            while ((line = reader.readNext()) != null) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", line[0]);
                jsonObject.put("name", line[1]);
                jsonObject.put("age", Integer.parseInt(line[2]));
                jsonObject.put("major", line[3]);
                jsonArray.put(jsonObject);
            }

            try (FileWriter writer = new FileWriter(jsonFilePath)) {
                writer.write(jsonArray.toString(4));
                System.out.println("CSV to JSON conversion completed successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
