package Arrays;

public class MaxProductMain{
    public static void main(String[] args) {
        int[] arr = {1,0,5};
        System.out.println(max_product(arr));

    }
    public static int maxProduct(int[] nums){
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            int product = 1;
            for(int j = i; j<n ; j++){
                product *= nums[j];
                maxProduct = Math.max(maxProduct, product);
            }
        }

        return maxProduct;
    }

    public static int max_product(int[] nums){
        int n = nums.length;
        int leftProduct = 1;
        int rightProduct = 1;
        int ans = nums[0];

        for(int i = 0; i<n;i++){
            leftProduct = leftProduct == 0?1: leftProduct;
            rightProduct = rightProduct == 0?1:rightProduct;

            leftProduct *= nums[i];
            rightProduct *= nums[n-1-i];

            ans = Math.max(ans, Math.max(leftProduct,rightProduct));
        }

        return ans;
    }
}
