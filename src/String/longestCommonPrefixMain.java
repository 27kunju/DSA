package String;

import java.util.Arrays;

public class longestCommonPrefixMain {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String res = longestCommandPrefix(strs);
        System.out.println(res);

    }

    public static String longestCommandPrefix(String[] strs){

        Arrays.sort(strs);

        int size = Math.min(strs[0].length(), strs[strs.length -1].length());

        for(int i =0; i<size; i++){
            if(strs[0].charAt(i) != strs[strs.length -1].charAt(i)){
                return strs[0].substring(0,i);
            }
        }

        return strs[0];
    }
}
