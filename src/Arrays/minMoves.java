package Arrays;

public class minMoves {

    public int minimumMoves(int[] arr1, int[] arr2) {

        int n = arr1.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            count += getMoves(arr1[i], arr2[i]);
        }

        return count;
    }

    public int getMoves(int a, int b) {

        int moves = 0;

        while (a > 0 || b > 0) {

            int d1 = a % 10;
            int d2 = b % 10;

            moves += Math.abs(d1 - d2);

            a /= 10;
            b /= 10;
        }

        return moves;
    }
}
