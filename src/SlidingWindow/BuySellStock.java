package SlidingWindow;

public class BuySellStock {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int maxProfit = maxProfit(arr);
        System.out.println(maxProfit);
    }

    public static int maxProfit(int[] prices) {
            int left = 0; // Buy day
            int right = 1; // Sell day
            int maxProfit = 0;

            while (right < prices.length) {
                if (prices[right] > prices[left]) {
                    int profit = prices[right] - prices[left];
                    maxProfit = Math.max(maxProfit, profit);
                } else {
                    // Move buy day to right if we find lower price
                    left = right;
                }
                right++;
            }

            return maxProfit;
        }
    }


