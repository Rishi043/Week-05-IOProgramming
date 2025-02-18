package com.ioprogramming.csvdatahandling.basicproblems.writecsvfile;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class writeCSV {
    public static void main(String[] args) {
        String fileName = "employeedetails.csv";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {

            bw.write("ID,Name,Department,Salary\n");
            bw.write("101,Amit,HR,60000\n");
            bw.write("102,Kuldeep,Recruit,80000\n");
            bw.write("103,Rishi,IT,400000\n");
            bw.write("104,Kanishk,Finance,45000\n");
            bw.write("105,Harsh,Marketing,50000\n");

            System.out.println("CSV file written successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
