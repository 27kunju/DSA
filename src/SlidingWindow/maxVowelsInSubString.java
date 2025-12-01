package SlidingWindow;

public class maxVowelsInSubString {
    //lc-1456
    public int maxVowels(String s, int k) {
        int n = s.length();
        int i = 0, j = 0;
        int count = 0, max = 0;

        while (j < n) {
            // EXPAND window
            if (isVowel(s.charAt(j))) {
                count++;
            }

            // SHRINK when window size > k
            if (j - i + 1 > k) {
                if (isVowel(s.charAt(i))) {
                    count--;
                }
                i++;
            }

            // VALID window of size exactly k
            if (j - i + 1 == k) {
                max = Math.max(max, count);
            }

            j++;  // move right
        }

        return max;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
