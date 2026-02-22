package BinarySearch;

//leetcode 852
/*
Since there will be one peak element
 */
public class findPeak {
    public int peakIndexInMountainArray(int[] arr) {

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
            }
        }

        return r;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,5,6,9};
        System.out.println(peakIndexInMountainArray2(nums));
    }
}
