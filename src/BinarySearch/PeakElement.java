package BinarySearch;

public class PeakElement {

    public static int findOnePeak(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;  // only one element, it's the peak

        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Case 1: First element
            if (mid == 0) {
                if (arr[mid] >= arr[mid + 1]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }

            // Case 2: Last element
            else if (mid == n - 1) {
                if (arr[mid] >= arr[mid - 1]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }

            // Case 3: Middle elements
            else {
                if (arr[mid] >= arr[mid - 1] && arr[mid] >= arr[mid + 1]) {
                    return mid;
                } else if (arr[mid - 1] > arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static int findOnePeak2(int[] nums){
        int l = 0;
        int r = nums.length -1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(nums[mid]>nums[mid+1]){
                r = mid;
            }else{
                l = mid+1;
            }
        }

        return nums[l];
    }



    // O(n) - finds all peaks
    public static java.util.List<Integer> findAllPeaks(int[] arr) {
        java.util.List<Integer> peaks = new java.util.ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if ((i == 0 && arr[i] > arr[i + 1]) ||
                    (i == n - 1 && arr[i] > arr[i - 1]) ||
                    (i > 0 && i < n - 1 && arr[i] > arr[i - 1] && arr[i] > arr[i + 1])) {
                peaks.add(i);
            }
        }
        return peaks;
    }

    public static void main(String[] args) {
        // arrs will be sorted in peak element problem
        int[] arr1 = {1,2,3,1};
        int[] arr2 = {1,2,1,3,5,6,4};
        int[] arr3 = {1};


        System.out.println("One peak in arr1: " + findOnePeak2(arr1));
        System.out.println("One peak in arr2: " + findOnePeak2(arr2));

        System.out.println("All peaks in arr1: " + findAllPeaks(arr1));
        System.out.println("All peaks in arr2: " + findAllPeaks(arr2));
    }
}
