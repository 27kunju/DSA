package SlidingWindow;

import java.util.*;

public class lengthOfLongestSubstringTwoDistinct {
    public int SizeOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        int i = 0, j = 0;
        int maxLen = 0;

        Map<Character, Integer> freq = new HashMap<>();

        while (j < n) {

            // EXPAND
            char c = s.charAt(j);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            // SHRINK until distinct > 2
            while (freq.size() > 2) {
                char left = s.charAt(i);
                freq.put(left, freq.get(left) - 1);
                if (freq.get(left) == 0) freq.remove(left);
                i++;
            }

            // VALID WINDOW
            maxLen = Math.max(maxLen, j - i + 1);

            j++;
        }

        return maxLen;
    }
}
