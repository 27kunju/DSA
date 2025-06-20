package Arrays;

public class MoveAllZerostoEnd {

    public static void main(String[] args) {

        int[] nums = {0,2,3,0,5,6, 8, 0, 1};
        int n = nums.length;
        int j = 0;

        //first pass; move non-zero elements to front
        for(int i =0; i<n ; i++){
            if(nums[i] !=0) {
                nums[j] = nums[i];
                j++;
            }
        }

        //fill remaining with 0
        while(j<n){
            nums[j] =0;
            j++;
        }

        System.out.println("Array after moving zeros");
        for(int i : nums ){
            System.out.println(i + " ");
        }

    }
}
