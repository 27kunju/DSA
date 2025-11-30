package SlidingWindow;

import java.util.*;

public class lengthOfLongestSubstringKDistinct {
    public int sizeOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        int i = 0, j = 0;
        int maxLen = 0;

        Map<Character, Integer> freq = new HashMap<>();

        while (j < n) {

            // EXPAND window
            char c = s.charAt(j);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            // SHRINK window when invalid
            while (freq.size() > k) {
                char left = s.charAt(i);
                freq.put(left, freq.get(left) - 1);
                if (freq.get(left) == 0) freq.remove(left);
                i++;
            }

            // VALID
            maxLen = Math.max(maxLen, j - i + 1);

            j++;
        }

        return maxLen;
    }
}
