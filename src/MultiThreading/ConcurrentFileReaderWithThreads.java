package MultiThreading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConcurrentFileReaderWithThreads {

    public static void main(String[] args) {

        String filePath1 = "file1.txt";
        String filePath2 = "file2.txt";

        Thread file1Thread = new Thread(() -> readFile(filePath1), "File-1-Thread");
        Thread file2Thread = new Thread(() -> readFile(filePath2), "File-2-Thread");

        file1Thread.start();
        file2Thread.start();

        try {
            file1Thread.join();
            file2Thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void readFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = br.readLine()) != null) {
                Thread.sleep(1000); // simulate delay
                System.out.println(Thread.currentThread().getName()
                        + " read line: " + line);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
