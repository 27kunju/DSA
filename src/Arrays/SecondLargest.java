package Arrays;

public class SecondLargest {
    public static void main(String[] args) {
        int[] nums = {5,6,13,7,19};

        int large = nums[0];

        //if array has negative elements then take
//        int Slarge = Integer.MIN_VALUE ;
        int sLarge = -1;

        for(int i = 1; i<nums.length ; i++){
            if(nums[i] > large){
                sLarge = large;
                large = nums[i];
            }
            else if(nums[i] < large && nums[i] > sLarge){
                sLarge = nums[i];
            }
        }
        System.out.println(sLarge);
        }
}
