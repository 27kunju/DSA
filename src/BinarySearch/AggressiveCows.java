package BinarySearch;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {

        int[] stalls = {1, 2, 4, 8, 9};
        int[] stalls2 = {10, 1, 2, 7, 5};
        int[] stalls3 = {2, 12, 11, 3, 26, 7};
        int k = 3;
        int k2 = 5;

        int ans = getMinimumDistanceBetweenCows(stalls3, k2);

        System.out.println(ans);

    }

    public static boolean isPossibleMinimumDistance(int[] stalls, int minDis, int k){
        int cows = 1;

        int lastCow = stalls[0];

        for(int i = 1; i<stalls.length;i++){
            if(stalls[i] - lastCow >=minDis){
                cows++;
                lastCow = stalls[i];
            }

            if(cows>=k)  return true;
        }

        return cows>=k;
    }

    public static int getMinimumDistanceBetweenCows(int[] stalls, int k){
        Arrays.sort(stalls);

        int n = stalls.length;
        int l = 0;
        int h = stalls[n-1] - stalls[0];
        int res = 0;

        while(l<=h){
            int mid = l +(h-l)/2;

            if(isPossibleMinimumDistance(stalls, mid, k)){
                res = mid;
                l = mid+1;


            }else{
                h = mid-1;
            }
        }

        return res;
    }
}
