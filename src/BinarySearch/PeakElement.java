package BinarySearch;

public class PeakElement {

    public static int peakElement(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if( mid > 0 && mid < n-1){
                if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                    return mid;
                }else if(arr[mid-1]> arr[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }

            else if(mid == 0){
                if(arr[0] > arr[1]){
                    return 0;
                }else{
                    return 1;
                }
            }else if(mid == n-1){
                if(arr[n-1] > arr[n-2]){
                    return n-1;
                }else{
                    return n-2;
                }

            }
        }
        return -1; // should not happen
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 1};
        int[] arr2 = {8, 2, 1, 3, 5, 6, 7};

        //peak element will be greater element than its left and right
        // while searching ,search in the side which has possibility of getting greater element

        System.out.println("Peak element index in arr1: " + peakElement(arr1));
        System.out.println("Peak element index in arr2: " + peakElement(arr2));
    }
}


