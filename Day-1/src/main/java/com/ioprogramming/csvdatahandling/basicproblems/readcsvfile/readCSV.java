package com.ioprogramming.csvdatahandling.basicproblems.readcsvfile;

import java.io.BufferedReader;
import java.io.*;
import java.io.FileReader;

public class readCSV {
    public static void main(String[] args) throws Exception {
        String fileName = "studentdetails.csv";
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                for (String val : data) {
                    System.out.print(val+"\t");
                }
                System.out.println();
            }
        }
}

