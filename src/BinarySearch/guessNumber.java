package BinarySearch;

public class guessNumber {
    public int guessNumber(int n) {
        int l = 1;
        int r = n;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int res = guess(mid);

            if (res == 0) {
                return mid;
            } else if (res < 0) {   // mid is too high
                r = mid - 1;
            } else {               // mid is too low
                l = mid + 1;
            }
        }
        return -1; // never reached
    }

    public int guess(int n){
        return 0;

    }

}
