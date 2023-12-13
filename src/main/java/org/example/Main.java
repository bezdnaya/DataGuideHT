package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        PersonalData person1 = new PersonalData();
        String note1 = person1.toString();
        String fileName = ""+person1.getSurname()+".txt";
        FileWriter writer = new FileWriter(fileName);
        writer.write(note1);
        writer.close();

    }
}