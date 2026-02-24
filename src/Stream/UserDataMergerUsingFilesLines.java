package Stream;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class UserDataMergerUsingFilesLines {

    // ---------- USER MODEL ----------
    static class User {
        private String phone;
        private String address;
        private String work;
        private String otherInfo;

        public User(String phone) {
            this.phone = phone;
        }

        public String getPhone() { return phone; }
        public String getAddress() { return address; }
        public String getWork() { return work; }
        public String getOtherInfo() { return otherInfo; }

        public void setAddress(String address) { this.address = address; }
        public void setWork(String work) { this.work = work; }
        public void setOtherInfo(String otherInfo) { this.otherInfo = otherInfo; }
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        Map<String, User> userMap = new HashMap<>(1_000_000);

        // -------- FILE 1: phone,address --------
        try (Stream<String> lines = Files.lines(Path.of("file1.csv"))) {
            lines
                    .filter(line -> !line.trim().isEmpty())
                    .forEach(line -> {
                        String[] p = line.split(",", -1);
                        userMap
                                .computeIfAbsent(p[0], User::new)
                                .setAddress(p.length > 1 ? p[1] : null);
                    });
        } catch (IOException e) {
            throw new RuntimeException("Error processing file1.csv", e);
        }

        // -------- FILE 2: phone,work --------
        try (Stream<String> lines = Files.lines(Path.of("file2.csv"))) {
            lines
                    .filter(line -> !line.trim().isEmpty())
                    .forEach(line -> {
                        String[] p = line.split(",", -1);
                        userMap
                                .computeIfAbsent(p[0], User::new)
                                .setWork(p.length > 1 ? p[1] : null);
                    });
        } catch (IOException e) {
            throw new RuntimeException("Error processing file2.csv", e);
        }

        // -------- FILE 3: phone,otherInfo --------
        try (Stream<String> lines = Files.lines(Path.of("file3.csv"))) {
            lines
                    .filter(line -> !line.trim().isEmpty())
                    .forEach(line -> {
                        String[] p = line.split(",", -1);
                        userMap
                                .computeIfAbsent(p[0], User::new)
                                .setOtherInfo(p.length > 1 ? p[1] : null);
                    });
        } catch (IOException e) {
            throw new RuntimeException("Error processing file3.csv", e);
        }

        // -------- WRITE MERGED OUTPUT --------
        writeOutput(userMap, "final_users.csv");

        System.out.println("Merge completed. Total users: " + userMap.size());
    }

    // ---------- WRITE OUTPUT FILE ----------
    private static void writeOutput(Map<String, User> userMap, String outputFile) {
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(outputFile))) {

            writer.write("phone,address,work,otherInfo");
            writer.newLine();

            for (User u : userMap.values()) {
                writer.write(
                        safe(u.getPhone()) + "," +
                                safe(u.getAddress()) + "," +
                                safe(u.getWork()) + "," +
                                safe(u.getOtherInfo())
                );
                writer.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException("Error writing output file", e);
        }
    }

    private static String safe(String value) {
        return value == null ? "" : value;
    }
}