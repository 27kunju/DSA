package MultiThreading;

//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Iterator;
//import java.util.List;
//import java.util.concurrent.CopyOnWriteArrayList;
//
//public class ConcurrentModificationExceptionDemo {
//    public static void main(String[] args) {
////        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
////        list.add(1);
////        list.add(2);
////        list.add(3);
//
//
//        List<Integer> list = new CopyOnWriteArrayList<>();
//
//        for (Integer i : list) {
//            list.add(4); // safe
//        }
//
//
//
//    }
//}
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteExample {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        for (Integer i : list) {
            if (i == 2) {
                list.add(4); // ✅ safe
            }
        }

        System.out.println(list);
    }
}
