package com.ioprogramming.csvdatahandling.advancedproblems.encryptdecryptcsv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EncryptAndDecryptCSV {
    public static void main(String[] args) {
        String inputFilePath = "src/main/java/com/ioprogramming/csvdatahandling/advancedproblems/encryptdecryptcsv/employees.csv";
        String encryptedFilePath = "src/main/java/com/ioprogramming/csvdatahandling/advancedproblems/encryptdecryptcsv/encrypted_employees.csv";
        String decryptedFilePath = "src/main/java/com/ioprogramming/csvdatahandling/advancedproblems/encryptdecryptcsv/decrypted_employees.csv";

        // Encrypt and write to CSV
        EncryptionUtil encryptionUtil = new EncryptionUtil();
        try (CSVReader reader = new CSVReader(new FileReader(inputFilePath));
             CSVWriter writer = new CSVWriter(new FileWriter(encryptedFilePath))) {

            String[] line;
            while ((line = reader.readNext()) != null) {
                line[3] = encryptionUtil.encrypt(line[3]); // Encrypt Salary
                writer.writeNext(line);
            }

            System.out.println("CSV file encrypted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Decrypt and write to CSV
        DecryptionUtil decryptionUtil = new DecryptionUtil();
        try (CSVReader reader = new CSVReader(new FileReader(encryptedFilePath));
             CSVWriter writer = new CSVWriter(new FileWriter(decryptedFilePath))) {

            String[] line;
            while ((line = reader.readNext()) != null) {
                line[3] = decryptionUtil.decrypt(line[3]); // Decrypt Salary
                writer.writeNext(line);
            }

            System.out.println("CSV file decrypted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

