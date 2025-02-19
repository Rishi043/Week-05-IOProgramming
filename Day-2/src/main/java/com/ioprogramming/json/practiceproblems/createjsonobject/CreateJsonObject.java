package com.ioprogramming.json.practiceproblems.createjsonobject;

import org.json.JSONArray;
import org.json.JSONObject;

public class CreateJsonObject {
        public static void main(String[] args) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", "Kabir");
            jsonObject.put("age", 25);

            JSONArray subjects = new JSONArray();
            subjects.put("Maths");
            subjects.put("Biology");
            subjects.put("English");

            jsonObject.put("subjects", subjects);



            System.out.println(jsonObject);
        }
    }
