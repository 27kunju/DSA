package TwoPointers;

public class BuySellStock {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int maxProfit = findMaxProfit(arr);
        System.out.println(maxProfit);
    }
    public static int findMaxProfit(int[] arr){

        int l = 0;
        int max = Integer.MIN_VALUE;
        int profit = 0;
        for(int r = 0 ;r< arr.length; r++){
            if(arr[l] < arr[r]){
                profit = arr[r] - arr[l];
                max = Math.max(profit, max);
            } else{
                l =r;
            }
        }
        return (max == Integer.MIN_VALUE)?0: max;
    }
}
