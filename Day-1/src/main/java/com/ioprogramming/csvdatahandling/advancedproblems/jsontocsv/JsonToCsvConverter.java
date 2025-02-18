package com.ioprogramming.csvdatahandling.advancedproblems.jsoncsv;

import com.opencsv.CSVWriter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonToCsvConverter {
    public static void main(String[] args) {
        String jsonFilePath = "src/main/java/com/ioprogramming/csvdatahandling/advancedproblems/jsontocsv/students.json";
        String csvFilePath = "src/main/java/com/ioprogramming/csvdatahandling/advancedproblems/jsontocsv/students.csv";

        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
            JSONArray jsonArray = new JSONArray(jsonContent);

            try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {
                // Write header
                String[] header = {"ID", "Name", "Age", "Major"};
                writer.writeNext(header);

                // Write data
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String[] record = {
                            jsonObject.getString("id"),
                            jsonObject.getString("name"),
                            String.valueOf(jsonObject.getInt("age")),
                            jsonObject.getString("major")
                    };
                    writer.writeNext(record);
                }

                System.out.println("JSON to CSV conversion completed successfully!");

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
