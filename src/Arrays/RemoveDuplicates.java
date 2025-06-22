package Arrays;

//removing duplicates in sorted array inplace
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,4,3,4,5};

        //works for sorted array
        java.util.Arrays.sort(nums);
        int newLength = removeDup(nums);
        System.out.println("After removing duplicates");
        for(int i =0; i<newLength ; i++){
            System.out.println(nums[i]);
        }

    }

    public static int removeDup(int[] nums){
        int i =0;
        for(int j = 1; j< nums.length ; j++){
            if(nums[i] != nums[j]){
                nums[i+1]  = nums[j];
                i++;
            }
        }
        return i+1;

    }
}
