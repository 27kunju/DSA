package SlidingWindow;

import java.util.*;

public class CountAnagramMain {
    public static int countAnagrams(String txt, String pat) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : pat.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int count = map.size(); // unique characters to match
        int k = pat.length();
        int i = 0, j = 0;
        int ans = 0;

        while (j < txt.length()) {
            // Decrease the count from the map if character is found
            char ch = txt.charAt(j);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    count--;
                }
            }

            // Window size is less than pattern
            if ((j - i + 1) < k) {
                j++;
            }
            // When window size equals k
            else if ((j - i + 1) == k) {
                if (count == 0) {
                    ans++;
                }

                // Slide the window
                char startChar = txt.charAt(i);
                if (map.containsKey(startChar)) {
                    map.put(startChar, map.get(startChar) + 1);
                    if (map.get(startChar) == 1) {
                        count++;
                    }
                }

                i++;
                j++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String txt = "forxxorfxdofr";
        String pat = "for";
        System.out.println(countAnagrams(txt, pat)); // Output: 3
    }
}

