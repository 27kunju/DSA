package Stream;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatedWord {

    public static void main(String[] args) {

        String paragraph = "I love Java because Java is simple and powerful";

        String result = findFirstRepeatedWord(paragraph);

        System.out.println(result);
    }

    public static String findFirstRepeatedWord(String text) {

        Set<String> seenWords = new HashSet<>();

        String[] words = text.split("\\s+");

        for (String word : words) {
            String normalizedWord = word.toLowerCase();

            if (!seenWords.add(normalizedWord)) {
                return word; // return original casing
            }
        }

        return null; // no repetition found
    }
}
