package SlidingWindow;

public class MinSubArrayFixedSize {
    public static void main(String[] args) {
        int[] arr = {4, 4, 5, 6, 4};
        int k = 3;
        int min = subarraySizeEqualsK(arr,k);
        System.out.println(min);
    }
    public  static int subarraySizeEqualsK(int[] arr, int k) {
        int i =0;
        int j =0;
        int sum =0;
        int min = Integer.MAX_VALUE;
        while(j< arr.length){
            sum +=arr[j];
            if(j-i+1<k){
                j++;
            }else if(j-i+1==k){
                min = Math.min(min,sum);
                sum -=arr[i];
                i++;
                j++;
            }
        }

        return (min == Integer.MAX_VALUE) ? -1 : min;


    }
}
