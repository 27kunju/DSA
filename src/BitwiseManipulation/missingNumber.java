package BitwiseManipulation;

public class missingNumber {
    public int missingNumber(int[] nums) {
        int total = 0;
        int n = nums.length;

        for(int i =0;i<n;i++){
            total +=nums[i];
        }

        long expected = (long) n * (n + 1) / 2;
        return (int)(expected - total);

    }
}
