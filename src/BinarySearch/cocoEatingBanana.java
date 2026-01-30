package BinarySearch;


/*

Your understanding (refined & correct ✅)

Worst case speed = 1 banana/hour
→ Koko takes maximum time
→ That time = sum of all piles

Best (fastest) needed speed
→ Eat the largest pile in 1 hour
→ Speed = max(piles)
 */
public class cocoEatingBanana {
    public boolean canEatAll(int[] piles, int h, int speed) {
        long hours = 0;
        for (int p : piles) {
            hours += (p + speed - 1) / speed; // ceiling division
        }
        return hours <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        // max pile = upper bound
        for (int p : piles) {
            high = Math.max(high, p);
        }

        int res = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canEatAll(piles, h, mid)) {
                res = mid;
                high = mid - 1; // try smaller speed
            } else {
                low = mid + 1; // need higher speed
            }
        }

        return res;
    }
}
