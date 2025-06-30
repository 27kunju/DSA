package Arrays;
import java.lang.Math;

public class BuySellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};

        //lets first find min stock(price), and index(day)
        int min = prices[0], index = 0 ;
        for(int i = 1; i< prices.length ; i++){
            if(prices[i] < min){
                min = prices[i];
                index = i;
            }
        }

        int max = 0;

        for(int i = index; i< prices.length-1 ;i++){
          int diff = prices[i+1] - min;
          max  = Math.max(max, diff);

       }

        System.out.println(max);
    }
}
