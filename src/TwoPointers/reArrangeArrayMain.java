package TwoPointers;

public class reArrangeArrayMain {
    public static void main(String[] args) {
        int[] nums = {3,1,-2,-5,2,-4};
        int[] ans = new int[nums.length];
        ans = rearrangeArray(nums);

    }

    public static int[] rearrangeArray2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int even = 0;
        int odd = 1;

        for(int i = 0; i<n;i++){
            if(nums[i] <0){
                res[odd] = nums[i];
                odd +=2;
            }else{
                res[even] = nums[i];
                even +=2;
            }
        }

        return res;

    }

    //brute force
    public static int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] arr1 = new int[n/2];
        int[] arr2 = new int[n/2];
        int[] res = new int[n];
        int k = 0;

        int i = 0, j =0;
        while(k < n){
            if(nums[k] <0){
                arr1[i++] = nums[k++];
            }else{
                arr2[j++] = nums[k++];
            }
        }

        int l = 0, m =0;

        for(int p = 0; p<n;p++){
            if(p %2 == 0){
                res[p] = arr2[l++];
            }else{
                res[p] = arr1[m++];
            }
        }

        return res;


    }
}
