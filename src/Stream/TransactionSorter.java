package Stream;

import java.util.*;

public class TransactionSorter {

    public static void main(String[] args) {

        List<String> transactions = Arrays.asList(
                "TXN-102",
                "TXN-101",
                "PAY-12",
                "PAY-2",
                "TXN-99"
        );

        transactions.sort(transactionComparator());

        transactions.forEach(System.out::println);
    }

    // Comparator that defines sorting rules
    private static Comparator<String> transactionComparator() {
        return Comparator
                .comparing(TransactionSorter::parsePrefix)
                .thenComparingInt(TransactionSorter::parseNumber);
    }

    // Extract prefix (e.g., "TXN" from "TXN-102")
    private static String parsePrefix(String transactionId) {
        return transactionId.split("-")[0];
    }

    // Extract numeric part (e.g., 102 from "TXN-102")
    private static int parseNumber(String transactionId) {
        return Integer.parseInt(transactionId.split("-")[1]);
    }
}

