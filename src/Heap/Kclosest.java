package Heap;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


import java.util.*;

class Pair {
    int diff;
    int value;

    Pair(int diff, int value) {
        this.diff = diff;
        this.value = value;
    }
}

public class Kclosest {

    public static List<Integer> kClosest(int[] arr, int k, int x) {

        PriorityQueue<Pair> maxHeap =
                new PriorityQueue<>((a, b) -> b.diff - a.diff);

        for (int num : arr) {

            int diff = Math.abs(num - x);
            maxHeap.add(new Pair(diff, num));

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll().value);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {5,6,7,8,9};
        int k = 3;
        int x = 7;

        System.out.println(kClosest(arr, k, x));
    }
}