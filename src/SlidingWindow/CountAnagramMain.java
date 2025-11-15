package SlidingWindow;

import java.util.*;

public class CountAnagramMain {

    public static int countAnagrams2(String text, String pat){
        int[] freq = new int[256];
        int count = 0;

        // Build freq array and count unique chars
        for (char ch : pat.toCharArray()) {
            if (freq[ch] == 0) count++;
            freq[ch]++;
        }

        int i = 0, j = 0;
        int k = pat.length();
        int ans = 0;

        while (j < text.length()) {
            // Current char processed
            char ch = text.charAt(j);
            freq[ch]--;

            // If frequency becomes zero → matched one unique character
            if (freq[ch] == 0) count--;

            // Window size not reached
            if (j - i + 1 < k) {
                j++;
            }
            // Window size reached
            else if (j - i + 1 == k) {
                if (count == 0) ans++; // Perfect match → anagram

                // Before sliding the window, restore freq for outgoing char
                char out = text.charAt(i);
                if (freq[out] == 0) count++;  // we are reintroducing an unmatched char
                freq[out]++;

                i++;
                j++;
            }
        }

        return ans;
    }

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

