package com.ioprogramming.json.practiceproblems.validatejson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class validateJson {
    public static void main(String[] args) throws FileNotFoundException {
        ObjectMapper object=new ObjectMapper();

        try {
            FileReader file = new FileReader("sample.json");

            JsonNode jsonNode = object.readTree(file);
            System.out.println("Json is valid");
        }
        catch (Exception e){
            System.out.println("Json not valid");
        }
    }
}
