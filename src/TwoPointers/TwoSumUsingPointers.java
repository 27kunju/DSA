package TwoPointers;

import java.util.Arrays;
public class TwoSumUsingPointers{
    public static void main(String[] args) {
        int[] arr = {2, 8, 3, 6, 4};
        //sorted array
        int target = 9;
        int[] ans = findpairs(arr,target);
        for (int i = 0; i < ans.length; i += 2) {
            System.out.println("(" + ans[i] + ", " + ans[i+1] + ")");
        }
    }
    public static int[] findpairs(int[] arr, int target){
        Arrays.sort(arr);
        int l = 0;
        int r = arr.length -1;;
        while(l<r){
            if(arr[l]+arr[r] == target){
                return new int[]{arr[l], arr[r]};
            }else if(arr[l]+arr[r] < target){
                l++;
            }else{
                r--;
            }
        }

        return new int[0];
    }
}
