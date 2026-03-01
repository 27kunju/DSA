package String;

import javax.xml.stream.events.Characters;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class firstNonRepeatingCHar {
    public static void main(String[] args) {

        String s = "madamp";

        System.out.println(firstNonRepeatChar(s));

        char letter = s.chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())).entrySet()
                .stream().filter(e-> e.getValue()==1).findFirst().get().getKey();

        System.out.println(letter);


    }

    public static char firstNonRepeatChar(String s) {
        s = s.toLowerCase();

        int[] freq = new int[26];

        // Step 1: Count frequency
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Step 2: Preserve original order
        for (char c : s.toCharArray()) {
            if (freq[c - 'a'] == 1) {
                return c;
            }
        }

        return '\0'; // or throw exception / return special value
    }
}
