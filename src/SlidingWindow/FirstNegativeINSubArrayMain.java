package SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class FirstNegativeINSubArrayMain {
    public static void main(String[] args) {
        int[] arr = {12 ,-1, -7 ,8, -15, 30, 16, 28};
        //window size
        int k = 3;

        int i =0;
        int j =0;
        List<Integer> negatives = new ArrayList<>();

        while(j<arr.length){;
            if(arr[j] < 0){
                negatives.add(arr[j]);
            }
            if(j - i+1<k){
                j++;
            } else if (j -i +1==k) {
                if (!negatives.isEmpty()) {
                    System.out.print(negatives.getFirst() + " ");
                } else {
                    System.out.print("0 ");
                }

                // Remove the element going out of the window if it’s negative
                if (!negatives.isEmpty() && arr[i] == negatives.getFirst()) {
                    negatives.removeFirst();
                }

                // Slide the window
                i++;
                j++;
            }
        }

    }
}
