package Interview;

/*

{1,2,3}
{4,5,6,7,8}
{9,10,11,12}
merge 3 arrays into one array and add alternate items from each array.
Output - {1,4,9,2,5,10,3,6,11,7,12,8}

 */

import java.util.ArrayList;
import java.util.List;

public class mergeThreeArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {4,5,6,7,8};
        int[] nums3  = {9,10,11,12};

        int n = nums1.length + nums2.length+ nums3.length;

        List<Integer> result = new ArrayList<>();

        int i = 0;

        while(i< nums1.length || i <nums2.length || i <nums3.length){

            if(i< nums1.length)
                result.add(nums1[i]);
            if(i <nums2.length)
              result.add(nums2[i]);
            if(i <nums3.length)
              result.add(nums3[i]);

            i++;

        }


        System.out.println(result);







    }
}
