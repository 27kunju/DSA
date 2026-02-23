package greedy;

import java.util.Arrays;

public class buyChocos {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);

        int cost = prices[0] + prices[1];

        if (cost <= money) {
            return money - cost;
        }

        return money;
    }

    public int buyChoco2(int[] prices, int money) {

        Arrays.sort(prices); // sort to get cheapest first
        int numberOfChocos = 2;
        int originalMoney = money; // remember original money

        for (int i = 0; i < prices.length; i++) {
            // Can we afford this chocolate?
            if (prices[i] <= money) {
                money -= prices[i];
                numberOfChocos--;

                // Bought exactly 2 chocolates
                if (numberOfChocos == 0) {
                    return money;
                }
            }
        }

        // If we couldn’t buy 2 chocolates, return original money
        if (numberOfChocos > 0) {
            return originalMoney;
        }

        return money;
    }


}
