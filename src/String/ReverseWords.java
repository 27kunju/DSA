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
        char[] arr = s.toCharArray();
        int n = arr.length;

        // Reverse entire array
        reverse(arr, 0, n - 1);

        int start = 0; // write pointer & start of word
        int i = 0;

        while (i < n) {
            // Skip spaces
            while (i < n && arr[i] == ' ') i++;

            if (i >= n) break;

            int wordStart = start;

            // Copy word
            while (i < n && arr[i] != ' ') {
                arr[start++] = arr[i++];
            }

            // Reverse the word
            reverse(arr, wordStart, start - 1);

            // Add single space if there is more to come
            if (i < n) arr[start++] = ' ';
        }

        // Remove trailing space if any
        if (start > 0 && arr[start - 1] == ' ') start--;

        return new String(arr, 0, start);
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
