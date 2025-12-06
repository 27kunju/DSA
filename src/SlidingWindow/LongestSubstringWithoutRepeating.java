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


    //2nd approach,tracking window,shrink when duplicate found for any chars
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (j < s.length()) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.get(c) > 1) {  // duplicate detected
                char left = s.charAt(i);
                map.put(left, map.get(left) - 1);
                if (map.get(left) == 0) map.remove(left);
                i++;
            }

            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}
