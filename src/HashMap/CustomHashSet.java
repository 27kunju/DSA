package HashMap;

import java.util.Iterator;

public class CustomHashSet<E> implements Iterable<E> {

    private static final Object DUMMY_VALUE = new Object();
    private final MyHashMap<E, Object> map;

    public CustomHashSet() {
        map = new MyHashMap<>();
    }

    public boolean add(E element) {
        return map.put(element, DUMMY_VALUE) == null;
    }

    public boolean contains(E element) {
        return map.containsKey(element);
    }

    public boolean remove(E element) {
        return map.remove(element) != null;
    }

    public void clear() {
        map.clear();
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.size() == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return map.keyIterator();
    }
}

