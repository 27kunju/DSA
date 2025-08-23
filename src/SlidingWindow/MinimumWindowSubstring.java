package SlidingWindow;

import java.util.*;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int i = 0, j = 0;
        int count = t.length(); // total chars needed
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while(j < s.length()) {
            char endChar = s.charAt(j);

            if(map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar) - 1);
                if(map.get(endChar) >= 0) { // valid contribution
                    count--;
                }
            }

            while(count == 0) { // valid window
                if(minLen > j - i + 1) {
                    minLen = j - i + 1;
                    start = i;
                }

                char startChar = s.charAt(i);
                if(map.containsKey(startChar)) {
                    map.put(startChar, map.get(startChar) + 1);
                    if(map.get(startChar) > 0) {
                        count++; // lost a required char
                    }
                }
                i++; // shrink
            }
            j++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t)); // Output: "BANC"
    }
}
