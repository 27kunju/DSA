package SlidingWindow;

import java.util.*;

public class FindingAllAnagrams {
    public static void main(String[] args) {

        String text = "forxxorfxdofr";
        String pat = "for";
        System.out.println(findAnagrams(text,pat));

    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = map.size(); // unique characters in p
        int k = p.length();
        int i = 0, j = 0;

        while (j < s.length()) {
            char endChar = s.charAt(j);

            if (map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar) - 1);
                if (map.get(endChar) == 0) {
                    count--; // one character frequency matched
                }
            }

            // expand window until size == k
            if (j - i + 1 < k) {
                j++;
            }
            // when window hits size k
            else if (j - i + 1 == k) {
                if (count == 0) {
                    result.add(i); // valid anagram found
                }

                // now shrink the window
                char startChar = s.charAt(i);
                if (map.containsKey(startChar)) {
                    if (map.get(startChar) == 0) {
                        count++; // losing a matched character
                    }
                    map.put(startChar, map.get(startChar) + 1);
                }

                i++;
                j++;
            }
        }
        return result;
    }

    public static List<Integer>  findAnagrams2(String s , String p){
        int[] pcount = new int[26];
        int[] scount = new int[26];
        List<Integer> result = new ArrayList<>();

        for(char c: p.toCharArray()){
            pcount[c -'a']++;
        }

        for(int i = 0; i<s.length(); i++){
            scount[s.charAt(i) - 'a']++;
            if(i>= p.length()){
                scount[s.charAt(i - p.length()) - 'a']--;
            }

            if(Arrays.equals(pcount, scount)){
                result.add(i - p.length()+1);
            }
        }
        return result;
    }
}
