package SlidingWindow;

import java.util.*;

public class LongestSubstringKUnique {
    public static void main(String[] args) {
        String s = "aabaabac";
        int k = 2;
        int res = longestKUniqueSubstring(s, k);
        System.out.println("Longest substring length = " + res);
    }

    public static int longestKUniqueSubstring(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, maxLen = 0;

        while (j < s.length()) {
            // Step 1: Add character at j
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            //since we increase j in eachcase so we can keep outside
//            if(map.size()<k){
//                j++;
//            }

            // Step 2: If unique characters == k
            if (map.size() == k) {
                maxLen = Math.max(maxLen, j - i + 1);
            }

            // Step 3: If unique chars > k, shrink from left
            while (map.size() > k) {
                char leftChar = s.charAt(i);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                i++;
            }

            // Move j forward
            j++;
        }

        return maxLen;
    }
}
