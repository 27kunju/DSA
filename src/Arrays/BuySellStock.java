package Arrays;
import java.lang.Math;

public class BuySellStock {
    public static void main(String[] args) {
        int[] prices = {1,2};

        int max = 0;

        for(int i = 0 ; i< prices.length-1 ;i++){
            for(int j = i+1 ; j< prices.length-1 ; j++) {
                int diff = prices[j] - prices[i];
                max = Math.max(max, diff);
            }

       }

        System.out.println(max);
    }
}
