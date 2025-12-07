package String;

public class reversewords186 {
    public void reverseWords(char[] s) {
        // Step 1: Reverse the whole array
        reverse(s, 0, s.length - 1);

        // Step 2: Reverse each individual word
        int start = 0;
        for (int end = 0; end <= s.length; end++) {
            if (end == s.length || s[end] == ' ') {
                reverse(s, start, end - 1);
                start = end + 1;
            }
        }
    }

    private void reverse(char[] s, int l, int r) {
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}
