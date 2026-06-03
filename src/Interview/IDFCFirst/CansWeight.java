package Interview.IDFCFirst;
import java.util.ArrayList;
import java.util.Arrays;

/*
Stacey is organizing a beach clean-up when n tin can are placed  in singgle line,
she repeatedly removes min can each time , and its adjacents,return total min weight after removal
 */

import java.util.List;

public class CansWeight {
    public static int findTotalWeigh(List<Integer>  cans){

        int totalWeight = 0;

        while(!cans.isEmpty()){

            int min = Integer.MAX_VALUE;
            int index = 0;
            for(int i = 0; i<cans.size();i++){
                if(cans.get(i) <min){
                    min = cans.get(i);
                    index = i;
                }
            }

            totalWeight += min;

            int left = Math.max(0, index-1);
            int right = Math.min(cans.size()-1, index+1);

            for(int j = right ; j>=left;j--){
                cans.remove(j);
            }
        }

        return totalWeight;


    }

    public static void main(String[] args) {
        List<Integer> cans = new ArrayList<>(Arrays.asList(5,4,1,3,2));
        System.out.println(findTotalWeigh(cans));
    }
}
