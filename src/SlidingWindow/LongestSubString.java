package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubString {
    public static void main(String[] args) {
        String s = "abccdefchcacheadhie";
        int k = 3;
        int maxSubStringSize = findLongestSubString2(s, k);
        System.out.println(maxSubStringSize);
    }
    public static int findLongestSubString(String s){
        int l =0;
        Set<Character> characterSet = new HashSet<>();
        int res = 0;
        for(int r = 0; r< s.length(); r++){
            while(characterSet.contains(s.charAt(r))){
                characterSet.remove(s.charAt(l));
                l++;
            }
            characterSet.add(s.charAt(r));
            res = Math.max(res,r-l+1);

        }
        return res;
    }

    public static int findLongestSubString2(String s, int k){
        Map<Character, Integer> charMap = new HashMap<>();
        int i = 0, j = 0;
        int max = 0;

        while (j < s.length()) {
            char endChar = s.charAt(j);
            charMap.put(endChar, charMap.getOrDefault(endChar, 0) + 1);

            if (charMap.size() < k) {
                j++;
            } else if (charMap.size() == k) {
                max = Math.max(max, j - i + 1);
                j++;
            } else {
                while (charMap.size() > k) {
                    char startChar = s.charAt(i);
                    charMap.put(startChar, charMap.get(startChar) - 1);
                    if (charMap.get(startChar) == 0) {
                        charMap.remove(startChar);
                    }
                    i++;
                }
                j++;
            }
        }

        return max;
    }
}
