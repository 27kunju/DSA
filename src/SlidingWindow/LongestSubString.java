package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {
    public static void main(String[] args) {
        String s = "abcdefghacheadhie";
        int maxSubStringSize = findLongestSubString(s);
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
}
