package Stream;

import java.io.*;
import java.util.*;
import java.util.function.Consumer;

public class UserDataMerger {

    // -------- USER MODEL --------
    static class User {
        private String phoneNumber;
        private String address;
        private String workDetails;
        private String otherInfo;

        public User(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getWorkDetails() {
            return workDetails;
        }

        public void setWorkDetails(String workDetails) {
            this.workDetails = workDetails;
        }

        public String getOtherInfo() {
            return otherInfo;
        }

        public void setOtherInfo(String otherInfo) {
            this.otherInfo = otherInfo;
        }
    }

    // -------- FILE READER (STREAMING) --------
    static class FileLineReader {
        public static void read(String filePath, Consumer<String> consumer) {
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (!line.trim().isEmpty()) {
                        //accept(line) is NOT magic — it simply calls the lambda you already wrote.
                        consumer.accept(line);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException("Error reading file: " + filePath, e);
            }
        }
    }

    // -------- MAIN METHOD --------
    public static void main(String[] args) {

        // In-memory store
        Map<String, User> userMap = new HashMap<>(1_000_000);

        // -------- FILE 1: phone,address --------
        FileLineReader.read("file1.csv", line -> {
            String[] parts = line.split(",", -1);
            String phone = parts[0];

            userMap
                    .computeIfAbsent(phone, User::new)
                    .setAddress(parts.length > 1 ? parts[1] : null);
        });

        // -------- FILE 2: phone,work --------
        FileLineReader.read("file2.csv", line -> {
            String[] parts = line.split(",", -1);
            String phone = parts[0];

            userMap
                    .computeIfAbsent(phone, User::new)
                    .setWorkDetails(parts.length > 1 ? parts[1] : null);
        });

        // -------- FILE 3: phone,otherInfo --------
        FileLineReader.read("file3.csv", line -> {
            String[] parts = line.split(",", -1);
            String phone = parts[0];

            userMap
                    .computeIfAbsent(phone, User::new)
                    .setOtherInfo(parts.length > 1 ? parts[1] : null);
        });

        // -------- WRITE MERGED OUTPUT --------
        writeOutput(userMap, "final_users.csv");

        System.out.println("User data merge completed. Total users: " + userMap.size());
    }

    // -------- WRITE FINAL OUTPUT --------
    private static void writeOutput(Map<String, User> userMap, String outputFile) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            // Header
            bw.write("phone,address,work,otherInfo");
            bw.newLine();

            for (User user : userMap.values()) {
                bw.write(
                        safe(user.getPhoneNumber()) + "," +
                                safe(user.getAddress()) + "," +
                                safe(user.getWorkDetails()) + "," +
                                safe(user.getOtherInfo())
                );
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing output file", e);
        }
    }

    private static String safe(String value) {
        return value == null ? "" : value;
    }
}