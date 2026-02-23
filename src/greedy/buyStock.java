package greedy;

public class buyStock {

    /*
    We greedily track the minimum price so far and try to sell every day to maximize profit.
     This ensures the best possible single transaction.

     Greedy problems involve irreversible decisions where each local optimal choice affects future options, and choosing the best option at each step guarantees the global optimum.
     */
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            // Greedy buy: keep lowest price so far
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            // Greedy sell: maximize profit
            else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }

        return maxProfit;
    }
}
