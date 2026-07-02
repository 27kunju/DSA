package Interview.Guidewire;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

enum Coin {
    PENNY(1),
    NICKEL(5),
    DIME(10),
    QUARTER(25),
    HALF_DOLLAR(50);

    private final int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}


public class Wallet {

        Map<Coin, Integer> coins = new HashMap<>();

        // Add a coin
        public void addCoin(Coin coin) {
            coins.put(coin, coins.getOrDefault(coin, 0) + 1);
        }

        // Remove a coin
        public boolean removeCoin(Coin coin) {

            int count = coins.getOrDefault(coin, 0);

            if (count == 0) {
                return false;
            }

            coins.put(coin, count - 1);

            return true;
        }

        // Total cents
        public int getTotalCents() {

            int total = 0;

            for (Coin coin : Coin.values()) {
                total += coin.getValue() * coins.getOrDefault(coin, 0);
            }

            return total;
        }

        // Total number of coins
        public int getTotalDenominations() {

            int count = 0;

            for (int num : coins.values()) {
                count += num;
            }

            return count;
        }

        // Minimum number of coins required
        public int getMinimumDenominations() {

            int cents = getTotalCents();

            int count = 0;

            Coin[] values = {
                    Coin.HALF_DOLLAR,
                    Coin.QUARTER,
                    Coin.DIME,
                    Coin.NICKEL,
                    Coin.PENNY
            };

            for (Coin coin : values) {

                count += cents / coin.getValue();
                cents %= coin.getValue();
            }

            return count;
        }

    public int getMinimumDenominations2() {

        int totalCents = getTotalCents();

        int count = 0;

        while (totalCents > 0) {

            Coin nearestCoin = getNearestCoin(totalCents);

            totalCents -= nearestCoin.getValue();

            count++;
        }

        return count;
    }

    private Coin getNearestCoin2(int cents) {

        Coin[] coins = Coin.values();

        for (int i = coins.length - 1; i >= 0; i--) {

            if (coins[i].getValue() <= cents) {
                return coins[i];
            }
        }

        return Coin.PENNY;
    }

    private Coin getNearestCoin(int cents) {

        if (cents >= Coin.HALF_DOLLAR.getValue()) {
            return Coin.HALF_DOLLAR;
        }

        if (cents >= Coin.QUARTER.getValue()) {
            return Coin.QUARTER;
        }

        if (cents >= Coin.DIME.getValue()) {
            return Coin.DIME;
        }

        if (cents >= Coin.NICKEL.getValue()) {
            return Coin.NICKEL;
        }

        return Coin.PENNY;
    }

    public static void main(String[] args) {

        Wallet wallet = new Wallet();

        wallet.addCoin(Coin.QUARTER);
        wallet.addCoin(Coin.DIME);
        wallet.addCoin(Coin.PENNY);
        wallet.addCoin(Coin.PENNY);

        System.out.println(wallet.getTotalCents());          // 37

        System.out.println(wallet.getTotalDenominations());  // 4

        System.out.println(wallet.getMinimumDenominations());// 3
    }

}
