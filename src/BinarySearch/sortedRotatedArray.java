package BinarySearch;

public class sortedRotatedArray {

    /*
    First find peak index( need to find the index where its smaller to its neibours ),
     then apply binary search in both side
     */
    private int findPivot(int[] nums, int l, int r) {

        /*
        why not l<=r

        l = 4, r = 4
        Loop still runs!
        mid = 4;
        Now check:
        if (nums[mid] > nums[r])  // nums[4] > nums[4]? false
        l = mid + 1;          // not executed
        else r = mid;              // r = 4 (NO CHANGE)
        l and r stay the same
        Result: INFINITE LOOP

        Using l <= r would cause infinite looping because we don’t always eliminate mid, so we must stop when l == r
         */
        while (l < r) {
            int mid = l + (r - l) / 2;


            /*
            we have to find index of smallest element , if arr[mid] is greater,
            smaller elements may come in right side since its rotated ,
            therefore we are moving right,
            we are not considering arr[mid] since its bigger , we are looking for smaller therefore removing arr[mid] from search space
             */
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {

                /*
                when moving left smallet element can be in mid also , Minimum could be mid or to its left
                , therefore we can keeping mid in search space
                 */
                r = mid;
            }
        }

        /*
        at this point both l ,r will be pointing to minimum
         */
        return r;
    }

    private int binarySearch(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int pivot = findPivot(nums, 0, n - 1);

        if (nums[pivot] == target)
            return pivot;

        int idx = binarySearch(nums, pivot + 1, n - 1, target);
        if (idx != -1)
            return idx;

        return binarySearch(nums, 0, pivot - 1, target);
    }
}

/*
time complexity
findPivot        → O(log n)
binarySearch #1  → O(log n)
binarySearch #2  → O(log n)

overall O(log n)
 */
