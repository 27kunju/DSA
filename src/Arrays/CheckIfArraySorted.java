package Arrays;

public class CheckIfArraySorted {
    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
//        int[] nums  = {1,2,3,4,5};
        System.out.println(isSorted(nums));

    }


    //When i == n - 1 (the last element), i + 1 == n, which is out of bounds.
    //
    //To safely compare the last element nums[n - 1] to the first element nums[0], we write:
    //nums[(i + 1) % n]
    // array can sorted and rotated too .
    public static boolean isSorted(int[] arr){
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[(i + 1) % n]) {
                count++;
            }
        }
        return count <=1;
    }
    }

