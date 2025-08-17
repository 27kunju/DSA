package BinarySearch;

public class NextAlphabeticalElement {

    public static char nextLetter(char[] arr, char x) {
        int low = 0, high = arr.length - 1;
        char ans = '#'; // placeholder if not found

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > x) {
                ans = arr[mid];  // potential answer
                high = mid - 1;  // look for smaller valid letter
            } else {
                low = mid + 1;   // move right
            }
        }

        return ans == '#' ? '-' : ans; // '-' means no greater element exists
    }

    public static void main(String[] args) {
        char[] arr = {'a', 'c', 'f', 'h'};
        char x = 'f';

        char result = nextLetter(arr, x);
        System.out.println("Next letter after " + x + " is: " + result);
    }
}
