package String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";

        System.out.println(isValidAnangram(s,t));

        List<String> sts = new ArrayList<>();



    }

    public static boolean isValidAnangram(String s, String t){

        if(s.length() != t.length()){
            return false;
        }

        char[] sSort = s.toCharArray();
        char[] tSort = t.toCharArray();
        Arrays.sort(sSort);
        Arrays.sort(tSort);

        return Arrays.equals(sSort, tSort);
    }

    public static boolean isValidAnagramUsingHashmap(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character,Integer> countS = new HashMap<>();
        HashMap<Character,Integer> countT = new HashMap<>();
        for(int i =0; i<s.length() ; i++){
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0)+1);
            countT.put(s.charAt(i), countT.getOrDefault(s.charAt(i),0)+1);

        }
        return countS.equals(countT);
    }

    public static boolean isAnagramUsingHashTable(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
}
