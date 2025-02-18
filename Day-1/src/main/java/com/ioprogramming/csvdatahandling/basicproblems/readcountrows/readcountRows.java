package com.ioprogramming.csvdatahandling.basicproblems.readcountrows;

import java.io.BufferedReader;
import java.io.FileReader;

public class readcountRows {
    public static void main(String[] args) {
        String fileName = "src/main/java/com/ioprogramming/csvdatahandling/basicproblems/readcountrows/employeedetails.csv";

        int rowCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                // now it will not take header and after while loop cnt = 5

                rowCount++;
            }
            System.out.println("No of Records: " + rowCount);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
