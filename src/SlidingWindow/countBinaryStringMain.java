package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class countBinaryStringMain {

    public static boolean countBinaryString(String binary_format, int k){

        Set<String> cache = new HashSet<>();



        int j = 0;
        int i =0 ;

        while(j < binary_format.length()){
            if(j-i+1<k){
                j++;
            }else if(j-i+1==k){
                String newStr = binary_format.substring(i, j);
                if(!cache.contains(newStr)){
                    cache.add(newStr);
                }
                i++;
            }
            j++;
        }

        int size = 1<<k;

        return size== cache.size();
    }

    public static void main(String[] args) {

    }
}
