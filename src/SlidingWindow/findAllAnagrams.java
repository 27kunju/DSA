package SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class findAllAnagrams {

    public List<Integer> findIndexes(String s, String p){

        List<Integer> res = new ArrayList<>();

        for(int i = 0;i<s.length();i++){

            int count = 0;
            for(int j = i ;j<p.length();j++){
                if(s.charAt(i) == p.charAt(j)){
                    count++;
                }
            }

            if(count==p.length()){
                res.add(i);
            }
        }

        return res;

    }
}
