package SlidingWindow;

public class MaxEleInSubArrayMain {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int i = 0, j = 0;
        int n = arr.length;

        int numWindows = n - k + 1;
        int[] result = new int[numWindows];
        int idx = 0;

        int max = Integer.MIN_VALUE;

        while (j < n) {

            max = Math.max(max, arr[j]);      // update max for current window

            if (j - i + 1 < k) {              // expand window
                j++;
            }
            else if (j - i + 1 == k) {        // window hits size k

                result[idx++] = max;          // store max of this window

                if (arr[i] == max) {          // outgoing element was max?
                    max = Integer.MIN_VALUE;  // recompute max for next window
                    for (int x = i + 1; x <= j; x++) {
                        max = Math.max(max, arr[x]);
                    }
                }

                i++;                          // slide window
                j++;
            }
        }

        for (int x : result) System.out.println(x);
    }
}
