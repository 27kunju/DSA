package BinarySearch;

public class NextAlphabeticalElement {

    // this is  similar to finding ceiling
    public static char nextLetter(char[] arr, char x) {
        int low = 0, high = arr.length - 1;
        char ans = '#'; // placeholder if not found

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (x < arr[mid]) {
                ans = arr[mid];  // potential answer
                high = mid - 1;  // look for smaller valid letter
            } else {
                low = mid + 1;   // move right
            }
        }

        return ans == '#' ? '-' : ans; // '-' means no greater element exists
    }

    public static void main(String[] args) {
        char[] arr = {'a', 'c', 'f', 'h' , 'i'};

        char ch = 'f';
        char result = nextLetter(arr, ch);
        System.out.println("Next letter after " + ch + " is: " + result);
    }
}
