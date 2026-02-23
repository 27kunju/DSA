package greedy;

public class jumpGame {
    public boolean jumpGame(int[] nums){
        int n = nums.length -1;
        int finalPos = n;

        for(int i = n-2; i>=0;i--){

            if(i+nums[i] >=finalPos){
                finalPos = i;
            }
        }

        return finalPos==0;
    }
}
