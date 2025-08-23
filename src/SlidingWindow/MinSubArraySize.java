package SlidingWindow;

public class MinSubArraySize {
    public static void main(String[] args) {
        int[] arr = {5,3,2,5,10,7,4,9,2,8};
        int target = 15;

        int min = findMinSubArray(arr, target);
        System.out.println(min);
    }
    public static int findMinSubArray(int[] arr, int target) {
        int min= Integer.MAX_VALUE;
        int j = 0;
        int i = 0;
        int sum = 0;
        while(j<arr.length){
             sum  += arr[j];
            if(sum< target){
                j++;
            }else if(sum == target){
                min = Math.min(min, j-i+1);
                j++;
            }else{
                while(sum>target){
                    sum -=arr[i];
                    i++;
                }
                if(sum == target){
                    min = Math.min(min, j-i+1);

                }
                j++;
            }
        }
        return (min == Integer.MAX_VALUE) ? 0 : min;

    }
}
