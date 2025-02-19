package com.ioprogramming.json.handsonpracticeproblems.validateemail;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class EmailValidator {
    public static void main(String[] args) {
        try {
            // Read JSON Schema from file
            String schemaStr = new String(Files.readAllBytes(Paths.get("email_schema.json")));

            // Sample JSON Data
            String jsonStr = """
                {
                  "email": "ujjwalg@gmail.com"
                }
                """;

            // Convert Strings to JSON Objects
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonStr);
            JSONObject jsonSchema = new JSONObject(schemaStr);
            JSONObject jsonData = new JSONObject(jsonStr);

            // Load Schema & Validate JSON
            Schema schema = SchemaLoader.load(jsonSchema);
            schema.validate(jsonData);

            System.out.println("✅ Email is valid!");

        } catch (Exception e) {
            System.out.println("❌ Invalid email: " + e.getMessage());
        }
    }
}
