package com.ioprogramming.json.practiceproblems.mergejsonobjects;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJson {
    public static void main(String[] args)
    {
        try {
            ObjectMapper mapper = new ObjectMapper();

            ObjectNode json1 = mapper.createObjectNode();
            json1.put("name", "Aarav");
            json1.put("age", 20);

            ObjectNode json2 = mapper.createObjectNode();
            json2.put("email", "aarav@example.com");

            // Merge JSON objects
            json1.setAll(json2);

            // Simplified print
            System.out.println(json1);
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }
}

