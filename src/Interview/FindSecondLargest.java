package Interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindSecondLargest {
    public static void main(String[] args) {
        int[] arr = {1,45,6,9,10,40};
        int max = arr[0];
        int secondmax = 0;
        for(int i = 1 ; i<arr.length ; i++){
            if(arr[i] > max ){
                secondmax = max;
                max = arr[i];
            } else if(arr[i] < max && arr[i] > secondmax){
                secondmax = arr[i];
            }
        }

        System.out.println(secondmax + " " +max);

        List<Integer> top2 = Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .toList();

        System.out.println("Max = " + top2.get(0));
        System.out.println("Second max = " + top2.get(1));

    }
}
