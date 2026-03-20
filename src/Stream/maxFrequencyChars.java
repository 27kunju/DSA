package Stream;

public class maxFrequencyChars {

    public char maxOccurringChar(String s) {

        int[] freq = new int[256]; // for all ASCII chars

        // Step 1: Count frequency
        for (char ch : s.toCharArray()) {
            freq[ch]++;
        }

        int maxFreq = 0;
        char result = ' ';

        // Step 2: Traverse again for first occurrence
        for (char ch : s.toCharArray()) {
            if (freq[ch] > maxFreq) {
                maxFreq = freq[ch];
                result = ch;
            }
        }

        return result;
    }
}
