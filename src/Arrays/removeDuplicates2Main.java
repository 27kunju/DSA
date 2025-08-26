package Arrays;

public class removeDuplicates2Main {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        int newSize = removeDuplicates(arr);
        for(int i : arr){
            System.out.println(i);
        }

    }

    public static int removeDuplicates(int[] nums){
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (j == 1 || nums[i] != nums[j - 2]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }


}
