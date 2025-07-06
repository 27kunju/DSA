package TwoPointers;

public class BuySellStock {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int maxProfit = findMaxProfit(arr);
        System.out.println(maxProfit);
    }
    public static int findMaxProfit(int[] arr){
        int r = 0;
        int l = 0;
        int max = Integer.MIN_VALUE;
        int profit = 0;
        while(r< arr.length){
            if(arr[l] < arr[r]){
                profit = arr[r] - arr[l];
                max = Math.max(profit, max);
            } else{
                l =r;
            }
            r++;
        }
        return (max == Integer.MIN_VALUE)?0: max;
    }
}
