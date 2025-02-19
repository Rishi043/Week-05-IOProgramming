package com.ioprogramming.json.practiceproblems.javaobjecttojsonformat;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectToJson {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Car car = new Car("Mahindra", "Bolero", "White");

            String jsonString = objectMapper.writeValueAsString(car);

            System.out.println(jsonString);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
