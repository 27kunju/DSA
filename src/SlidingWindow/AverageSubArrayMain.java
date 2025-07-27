package SlidingWindow;

public class AverageSubArrayMain {
    public static void main(String[] args) {
        int[] arr = {-1};
        int k = 1;
        double max = findMaxAverage(arr, k);
        System.out.println(max);
    }

    public static double findMaxAverage(int[] nums, int k) {
        int i = 0;
        int j =0;
        double sum = 0;
        double max = Integer.MIN_VALUE;
        while(j < nums.length){
            sum += nums[j];
            System.out.println(sum+"sum");
            if(j-i+1<k){
                j++;
            } else if(j-i+1 ==k){
                double avg = (double) sum /(k);
                System.out.println(avg+"avg");
                max = Math.max(avg, max);
                sum -= nums[i];
                i++;
                j++;

            }
        }

        return max;

    }
}
