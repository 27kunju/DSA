package HashMap;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

class Node<K, V> {
    K key;
    V value;

    Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

public class CustomHashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private LinkedList<Node<K, V>>[] buckets;
    private int size;

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        buckets = new LinkedList[INITIAL_CAPACITY];
        size = 0;
    }

    // ---------- Add or Update Key ----------
    public V put(K key, V value) {
        int index = getIndex(key);

        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        for (Node<K, V> node : buckets[index]) {
            if (Objects.equals(node.key, key)) { // ✅ Fixed bug here
                V oldValue = node.value;
                node.value = value;
                return oldValue;
            }
        }

        buckets[index].add(new Node<>(key, value));
        size++;

        if ((double) size / buckets.length > LOAD_FACTOR) {
            resize();
        }

        return null;
    }

    // ---------- Get Value by Key ----------
    public V get(K key) {
        int index = getIndex(key);
        LinkedList<Node<K, V>> bucket = buckets[index];

        if (bucket != null) {
            for (Node<K, V> node : bucket) {
                if (Objects.equals(node.key, key)) {
                    return node.value;
                }
            }
        }

        return null;
    }

    // ---------- Remove Key ----------
    public V remove(K key) {
        int index = getIndex(key);
        LinkedList<Node<K, V>> bucket = buckets[index];

        if (bucket == null) return null;

        Iterator<Node<K, V>> iterator = bucket.iterator();
        while (iterator.hasNext()) {
            Node<K, V> node = iterator.next();
            if (Objects.equals(node.key, key)) {
                iterator.remove();
                size--;
                return node.value;
            }
        }

        return null;
    }

    // ---------- Check if Key Exists ----------
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    // ---------- Clear the Map ----------
    @SuppressWarnings("unchecked")
    public void clear() {
        buckets = new LinkedList[INITIAL_CAPACITY];
        size = 0;
    }

    // ---------- Return Number of Key-Value Pairs ----------
    public int size() {
        return size;
    }

    // ---------- Resize and Rehash ----------
    @SuppressWarnings("unchecked")
    private void resize() {
        LinkedList<Node<K, V>>[] oldBuckets = buckets;
        buckets = new LinkedList[oldBuckets.length * 2];
        size = 0;

        for (LinkedList<Node<K, V>> bucket : oldBuckets) {
            if (bucket != null) {
                for (Node<K, V> node : bucket) {
                    put(node.key, node.value); // Rehash
                }
            }
        }
    }

    // ---------- Compute Index for a Key ----------
    private int getIndex(K key) {
        return (key == null ? 0 : Math.abs(key.hashCode())) % buckets.length;
    }

    // ---------- Iterator for Keys ----------
    public Iterator<K> keyIterator() {
        return new Iterator<K>() {
            int bucketIndex = 0;
            Iterator<Node<K, V>> bucketIterator = null;

            @Override
            public boolean hasNext() {
                while ((bucketIterator == null || !bucketIterator.hasNext()) && bucketIndex < buckets.length) {
                    if (buckets[bucketIndex] != null) {
                        bucketIterator = buckets[bucketIndex].iterator();
                    }
                    bucketIndex++;
                }
                return bucketIterator != null && bucketIterator.hasNext();
            }

            @Override
            public K next() {
                return bucketIterator.next().key;
            }
        };
    }
}
