package backtracking;

public class nextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int index = -1;

        // Step 1: Find first decreasing element from right
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                index = i - 1;
                break;
            }
        }

        // Step 2: If no such index, reverse entire array
        if (index == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 3: Find element just larger than nums[index]
        int swap_index = index;
        for (int j = n - 1; j > index; j--) {
            if (nums[j] > nums[index]) {
                swap_index = j;
                break;
            }
        }

        // Step 4: Swap
        swap(nums, index, swap_index);

        // Step 5: Reverse the suffix
        reverse(nums, index + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
}
