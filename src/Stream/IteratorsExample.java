package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class IteratorsExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 5));

        for (int i = 0; i < list.size(); i++) {
            //Iteration with index i is tricky because list.remove(i) shifts all elements left.

            //In a traditional index-based for loop, there is no iterator object controlling the loop.
            // You are manually using list.get(i) internally.

            //Therefore, the loop itself does not detect structural changes, so no exception is thrown.
            list.remove(i);
        }

        System.out.println(list);
    }
}
