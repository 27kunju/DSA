package SlidingWindow;

public class CountAvgThreshholdMain {
    public static void main(String[] args) {
        int[] nums = {2,2,2,2,5,5,5,8};
        int k = 3;
        int threshold = 4;
        int count = numOfSubarrays(nums, k,threshold);
        System.out.println(count);
    }

    public  static int numOfSubarrays(int[] nums, int k, int threshold) {
        int i =0;
        int j =0;
        int count = 0;
        int sum = 0;
        while(j< nums.length){
            sum += nums[j];
            if(j-i+1<k){
                j++;
            }else if(j-i+1==k){
                int avg = sum/k;
                if(avg>=threshold){
                    count++;
                }
                sum -= nums[i];
                i++;
                j++;
            }
        }

        return count;

    }
}
