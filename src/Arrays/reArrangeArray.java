package Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;

public class reArrangeArray {
    public static int[] reArrange(int[] arr){
        Set<Integer> positives = new HashSet<>();
        Set<Integer> used = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for(int num : arr){
            if(num > 0) positives.add(num);
        }

        for(int num : arr){
            if(num <0 ){
                result.add(num);
                int pos = Math.abs(num);
                if(positives.contains(pos) && !used.contains(pos)){
                    result.add(pos);
                    used.add(pos);
                }
            }
        }

        for(int num : arr){
            if(num > 0 && !used.contains(num)){
                result.add(num);
                used.add(num);
            }
        }

        return result.stream().mapToInt(i ->i).toArray();

    }

    public static void main(String[] args) {
        int[] arr = {3,-2,5,7,1,-4};
        System.out.println(Arrays.toString(reArrange(arr)));
    }
}
