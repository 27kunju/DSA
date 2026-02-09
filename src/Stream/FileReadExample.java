package Stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadExample {

    public static void main(String[] args) {

        String filePath = "C://Users//rashwin//Documents//DSA//src//MultiThreading//file1.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            System.out.println("Reading file...");

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Simulate an exception
            if (true) {
                throw new RuntimeException("Error while processing file");
            }

        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        System.out.println("Program continues...");
    }
}

