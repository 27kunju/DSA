package HashMap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.*;

public class findPairs {


        public List<List<Integer>> findPairs(int[] arr, int k) {

            Set<Integer> set = new HashSet<>();
            List<List<Integer>> result = new ArrayList<>();

            // Add all elements to set
            for (int num : arr) {
                set.add(num);
            }

            // Find pairs
            for (int num : arr) {
                if (set.contains(num - k)) {
                    result.add(Arrays.asList(num, num - k));
                }
            }

            return result;
        }

}
