package String;

public class ReverseWords {
    public static void main(String[] args) {
        String s = "The sky is blue";

        String[] words = s.trim().split("\\s+");
        StringBuilder reversed =  new StringBuilder();
        for(int i = words.length-1; i>=0 ;i--){
            reversed.append(words[i]);
            if( i !=0){
                reversed.append(" ");
            }

        }

        System.out.println(reversed);

    }

    public String reverseWords(String s) {
        String[] tokens = s.trim().split("\\s+");

        StringBuilder result = new StringBuilder();

        for (int i = tokens.length - 1; i >= 0; i--) {
            result.append(tokens[i]);
            if (i > 0) result.append(" ");
        }

        return result.toString();
    }

    public String reverseWords2(String s) {
        // 1. Convert to char array
        char[] arr = s.toCharArray();
        int n = arr.length;

        // 2. Reverse entire string
        reverse(arr, 0, n - 1);

        int i = 0, l = 0, r = 0;

        while (i < n) {
            // skip spaces
            while (i < n && arr[i] == ' ') i++;

            if (i >= n) break;

            // write non-space characters
            while (i < n && arr[i] != ' ') {
                arr[r++] = arr[i++];
            }

            // reverse the word from l..r-1
            reverse(arr, l, r - 1);

            // add a space after the word
            arr[r++] = ' ';

            l = r;
        }

        // remove trailing space
        if (r > 0) r--;

        return new String(arr, 0, r);
    }

    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
