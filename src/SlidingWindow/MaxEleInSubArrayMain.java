package SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class MaxEleInSubArrayMain {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int  i =0;
        int j =0;
        int n = arr.length;
        int max = 0;
        int numWindows = n - k + 1;
        int idx = 0;

        int[] result = new int[numWindows];
        while(j < arr.length){
            if(arr[j]> max) {
                max = arr[j];
            }
            if(j-i+1<k){
                j++;
            } else if (j-i+1 ==k) {
                result[idx++] = max;
              i++;
              j++;
            }
        }

        for(int x : result){
            System.out.println(x);
        }

    }
}
