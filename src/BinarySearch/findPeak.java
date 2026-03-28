package BinarySearch;

//leetcode 852
/*
Since there will be one peak element
 */
public class findPeak {
    public static int peakIndexInMountainArray(int[] arr) {

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return -1; // safe fallback, though problem guarantees a peak
    }

    public static int peakIndexInMountainArray2(int[] arr){
        int l = 0;
        int r = arr.length-1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(arr[mid]<arr[mid+1]){
                l= mid+1;

            }else{
                r = mid;

                //Since I’m doing r = mid and not mid - 1, the search space may not shrink when l == r,
                // causing an infinite loop if I use l <= r. So I use l < r to stop when only one element remains.
            }
        }

        return r;

    }

    public int findPeakElement(int[] nums) {
        int n = nums.length;

        // Edge case: only one element
        if (n == 1) return 0;

        // Check first element
        if (nums[0] > nums[1]) return 0;

        // Check last element
        if (nums[n - 1] > nums[n - 2]) return n - 1;

        // Check middle elements
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,5,6,9};
        System.out.println(peakIndexInMountainArray(nums));
    }
}
