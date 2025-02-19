package com.ioprogramming.json.practiceproblems.readjson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class readJSON {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/ioprogramming/json/practiceproblems/readjson/students.json";
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            Student student = objectMapper.readValue(new File(filePath), Student.class);

            System.out.println("Name: " + student.getName());
            System.out.println("Email: " + student.getEmail());
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }
}