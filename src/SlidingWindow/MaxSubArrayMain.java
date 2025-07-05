package SlidingWindow;

public class MaxSubArrayMain {
    public static void main(String[] args) {
        int[] arr = {12,12,11,4,1,3,5,7,8,9, 10,12};
        int k = 3;
        int max = MaxSubArray(arr, k);
        System.out.println(max);
    }

    public static int MaxSubArray(int[] arr, int k ){

        int max = Integer.MIN_VALUE;
        int i = 0;  int j = 0 ; int sum = 0;

        while(j< arr.length){
            sum += arr[j];
            if(j-i +1<k){
                j++;
            } else if (j-i+1==k) {
                max = Math.max(sum, max);
                sum = sum- arr[i];
                i++;
                j++;

            }
        }
        return max;
    }
}

