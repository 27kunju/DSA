package SlidingWindow;

public class MinSubArraySize {
    public static void main(String[] args) {
        int[] arr = {5,1,3,5,10,7,4,9,2,8};
        int target = 15;

        int min = findMinSubArray(arr, target);
        System.out.println(min);
    }
    public static int findMinSubArray(int[] arr, int target) {
        int min = Integer.MAX_VALUE;
        int l = 0;
        int sum = 0;
        for(int r =0 ;r<arr.length;r++){
            sum +=arr[r];
            while(sum>=target){
                min = Math.min(min,r-l+1);
                sum -= arr[l++];
            }
        }
        return min;

    }
}
