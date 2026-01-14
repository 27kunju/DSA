package MultiThreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SynchronizedListExample {
    public static void main(String[] args) {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        list.add(1);
        list.add(2);
        list.add(3);

        // Iterating without synchronization → can throw ConcurrentModificationException
//        Iterator<Integer> it = list.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//            list.add(4); // ❌ can throw exception
//        }

        // Correct way: synchronize during iteration
        synchronized (list) {
            Iterator<Integer> itSafe = list.iterator();
            while (itSafe.hasNext()) {
                list.add(5);
            }
        }
    }
}
