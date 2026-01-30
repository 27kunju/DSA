package Arrays;

public class majorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};

        int n = findMajority(nums);
        System.out.println(n);
    }

    public static int findMajority(int[] nums){
        int candidate = nums[0];

        int count = 1;

        for(int i = 1;i<nums.length ;i++){

            if(nums[i] == candidate){
                count++;
            }else{
                count --;
            }

            if(count == 0){
                candidate = nums[i];
                count  = 1;
            }
        }

        return candidate;

    }
}
