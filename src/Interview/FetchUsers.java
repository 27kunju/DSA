package Interview;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.net.ssl.*;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class SSLHelper {
    public static SSLContext trustAllSSLContext() throws Exception {
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public void checkClientTrusted(X509Certificate[] c, String a) {}
                    public void checkServerTrusted(X509Certificate[] c, String a) {}
                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[0];
                    }
                }
        };

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, trustAllCerts, new SecureRandom());
        return sslContext;
    }
}

public class FetchUsers {

    static class SimpleUser {
        int id;
        String name;
        String username;
        String email;
        String city;
        String phone;
        String company;

        SimpleUser(int id, String name, String username, String email,
                   String city, String phone, String company) {
            this.id = id;
            this.name = name;
            this.username = username;
            this.email = email;
            this.city = city;
            this.phone = phone;
            this.company = company;
        }

        @Override
        public String toString() {
            return String.format("ID: %d, Name: %-20s, City: %s", id, name, city);
        }
    }

    public static List<SimpleUser> parseUsers(String json) {
        List<SimpleUser> users = new ArrayList<>();

        // Split into individual user objects
        String[] userObjects = json.substring(1, json.length() - 1).split("\\},\\{");

        for (String userObj : userObjects) {
            try {
                int id = extractInt(userObj, "\"id\":");
                String name = extractString(userObj, "\"name\":\"");
                String username = extractString(userObj, "\"username\":\"");
                String email = extractString(userObj, "\"email\":\"");
                String phone = extractString(userObj, "\"phone\":\"");
                String city = extractCity(userObj);
                String company = extractCompany(userObj);

                users.add(new SimpleUser(id, name, username, email, city, phone, company));
            } catch (Exception e) {
                System.err.println("Error parsing user: " + e.getMessage());
            }
        }

        return users;
    }

    private static int extractInt(String text, String key) {
        int start = text.indexOf(key) + key.length();
        int end = text.indexOf(",", start);
        if (end == -1) end = text.indexOf("}", start);
        return Integer.parseInt(text.substring(start, end).trim());
    }

    private static String extractString(String text, String key) {
        int start = text.indexOf(key) + key.length();
        int end = text.indexOf("\"", start);
        return text.substring(start, end);
    }

    private static String extractCity(String text) {
        Pattern pattern = Pattern.compile("\"city\":\"([^\"]+)\"");
        Matcher matcher = pattern.matcher(text);
        return matcher.find() ? matcher.group(1) : "Unknown";
    }

    private static String extractCompany(String text) {
        Pattern pattern = Pattern.compile("\"name\":\"([^\"]+)\"[^}]*\\}[^}]*\\}$");
        Matcher matcher = pattern.matcher(text);
        return matcher.find() ? matcher.group(1) : "Unknown";
    }

    public static void main(String[] args) {
        try {
            // Create HTTP client with SSL context
            SSLContext sslContext = SSLHelper.trustAllSSLContext();
            HttpClient client = HttpClient.newBuilder()
                    .sslContext(sslContext)
                    .build();

            // Build and send request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://jsonplaceholder.typicode.com/users"))
                    .GET()
                    .build();

            System.out.println("Fetching data from API...");
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            // Parse JSON response
            List<SimpleUser> users = parseUsers(response.body());

            // Display original order
            System.out.println("\n" + "=".repeat(80));
            System.out.println("ORIGINAL ORDER:");
            System.out.println("=".repeat(80));
            users.forEach(System.out::println);

            // Sort users by city
            users.sort(Comparator.comparing(u -> u.city));

            // Display sorted results
            System.out.println("\n" + "=".repeat(80));
            System.out.println("SORTED BY CITY:");
            System.out.println("=".repeat(80));

            String currentCity = "";
            for (SimpleUser user : users) {
                if (!user.city.equals(currentCity)) {
                    currentCity = user.city;
                    System.out.println("\n📌 " + currentCity);
                }
                System.out.printf("  • %s (@%s)%n", user.name, user.username);
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}