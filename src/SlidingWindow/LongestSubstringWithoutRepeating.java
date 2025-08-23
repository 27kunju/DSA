package SlidingWindow;

import java.util.*;

public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int res = longestUniqueSubstring(s);
        System.out.println(res); // Output: 3 ("abc")
    }

    public static int longestUniqueSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, maxLen = 0;
        int n = s.length();

        while (j < n) {
            // expand the window
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // check window condition
            if (map.size() == j - i + 1) {
                // valid window (all unique characters)
                maxLen = Math.max(maxLen, j - i + 1);
            } else if (map.size() < j - i + 1) {
                // shrink until condition becomes valid
                while (map.size() < j - i + 1) {
                    char leftChar = s.charAt(i);
                    map.put(leftChar, map.get(leftChar) - 1);
                    if (map.get(leftChar) == 0) {
                        map.remove(leftChar);
                    }
                    i++;
                }
            }
            j++;
        }
        return maxLen;
    }
}
