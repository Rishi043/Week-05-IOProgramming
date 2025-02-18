package com.ioprogramming.csvdatahandling.advancedproblems.csvintojavaobj;

import java.io.IOException;
import java.util.List;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList;

class Student {
    private String id;
    private String name;
    private int age;
    private int marks;

    public Student(String id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", marks=" + marks +
                '}';
    }
}

public class csvtojavaobj {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/ioprogramming/csvdatahandling/advancedproblems/csvintojavaobj/students.csv";
        List<Student> students = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            reader.readNext(); // Skip the header

            String[] line;
            while ((line = reader.readNext()) != null) {
                students.add(new Student(line[0], line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3])));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Print the list of students
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
