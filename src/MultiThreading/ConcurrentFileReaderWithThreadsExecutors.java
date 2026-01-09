package MultiThreading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentFileReaderWithThreadsExecutors {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        String[] filePaths = {
                "C://Users//rashwin//Documents//DSA//src//MultiThreading//file1.txt",
                "C://Users//rashwin//Documents//DSA//src//MultiThreading//file2.txt",
                "C://Users//rashwin//Documents//DSA//src//MultiThreading//file3.txt",
        };

        for(String filePth : filePaths){
            executorService.execute(() ->{
                readFile(filePth);
            });
        }

        executorService.shutdown();


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
