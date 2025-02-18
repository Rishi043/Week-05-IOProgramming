package com.ioprogramming.csvdatahandling.intermediateproblems.modifycsv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;

public class modifyCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        String outputFilePath = "src/main/java/com/ioprogramming/csvdatahandling/intermediateproblems/modifycsv/updated_employees.csv";

        try (CSVReader reader = new CSVReader(new FileReader(filePath));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath))) {

            String[] employee;
            // Read and write the header line
            String[] header = reader.readNext();
            writer.writeNext(header);

            // Read and process the remaining lines
            while ((employee = reader.readNext()) != null) {
                String department = employee[2];
                int salary = Integer.parseInt(employee[3]);

                if (department.equals("IT")) {
                    // Increase salary by 10%
                    salary += salary * 0.10;
                    employee[3] = String.valueOf(salary);
                }

                // Write the updated record to the new CSV file
                writer.writeNext(employee);

                // Print the updated record
                System.out.println("Name: " + employee[1] + ", Department: " + employee[2] + ", Salary: " + employee[3]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
