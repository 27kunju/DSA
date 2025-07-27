package TwoPointers;

public class MaxWaterContainer {
    public static void main(String[] args) {
        int[] heights = {1,8,6,2,5,4,8,3,7};
        int max = findMaxAreaUsingPointers(heights);
        System.out.println(max);
    }

    // in brute force we check all the possible
    public static int findMaxArea(int[] heights){
        int res = 0;
        for(int i =0 ; i<heights.length ; i++){
            for(int j = i+1; j<heights.length ; j++){
                res = Math.max(res, (j-i)* Math.min(heights[i],heights[j]));
            }
        }

        return res;
    }

    //here we look to move pointers which heights can give max area.
    // if the heights are equal , we can any any pointers
    public static int findMaxAreaUsingPointers(int[] heights){
        int l = 0;
        int r = heights.length -1;
        int res = Integer.MIN_VALUE;
        while(l<r){
            int area = Math.min(heights[l], heights[r])*(r-l);
            res = Math.max(area,res);
            if(heights[l] < heights[r]){
                l++;
            }else{
                r--;
            }
        }

        return res;

    }
}

