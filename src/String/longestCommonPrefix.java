package String;

import java.util.Arrays;

public class longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);


        int size = strs[0].length()  ;

        for(int i = 0;i<size;i++){

            if(strs[0].charAt(i) != strs[strs.length-1].charAt(i)){
                return new String(strs[0].substring(0,i));
            }
        }

        return strs[0];

    }
}
