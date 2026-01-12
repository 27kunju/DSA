package HashMap;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

class Node<K, V> {
    int hash;
    K key;
    V value;
    Node<K, V> next;

    Node(int hash, K key, V value, Node<K, V> next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }
}


/*


map.put("John", 25);
map.get("John");

s


1.int h = key.hashCode();
2.int mixedHash = h ^ (h >>> 16);
3.int index = (capacity - 1) & mixedHash;

 */


public class MyHashMap<K, V> implements Iterable<K> {

    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    private Node<K, V>[] table;
    private int size;
    private int threshold;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        table = new Node[DEFAULT_CAPACITY];
        threshold = (int) (DEFAULT_CAPACITY * LOAD_FACTOR);
    }

    // ---------- NODE ----------
    static class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    // ---------- HASH ----------
    private int hash(K key) {
        return key == null ? 0 : key.hashCode();
    }

    // ---------- PUT ----------
    public V put(K key, V value) {
        int hash = hash(key);
        int index = (table.length - 1) & hash;

        Node<K, V> head = table[index];

        if (head == null) {
            table[index] = new Node<>(hash, key, value, null);
            size++;
            return null;
        }

        Node<K, V> current = head;
        while (true) {
            if (Objects.equals(current.key, key)) {
                V oldValue = current.value;
                current.value = value;
                return oldValue;
            }
            if (current.next == null) {
                current.next = new Node<>(hash, key, value, null);
                size++;
                break;
            }
            current = current.next;
        }

        if (size > threshold) {
            resize();
        }
        return null;
    }

    // ---------- GET ----------
    public V get(K key) {
        int hash = hash(key);
        int index = (table.length - 1) & hash;

        Node<K, V> current = table[index];
        while (current != null) {
            if (Objects.equals(current.key, key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    // ---------- CONTAINS KEY ----------
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    // ---------- REMOVE ----------
    public V remove(K key) {
        int hash = hash(key);
        int index = (table.length - 1) & hash;

        Node<K, V> current = table[index];
        Node<K, V> prev = null;

        while (current != null) {
            if (Objects.equals(current.key, key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return current.value;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }

    // ---------- SIZE ----------
    public int size() {
        return size;
    }

    // ---------- CLEAR ----------
    @SuppressWarnings("unchecked")
    public void clear() {
        table = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    // ---------- RESIZE ----------
    @SuppressWarnings("unchecked")
    private void resize() {
        Node<K, V>[] oldTable = table;
        int newCapacity = oldTable.length * 2;
        table = new Node[newCapacity];
        threshold = (int) (newCapacity * LOAD_FACTOR);
        size = 0;

        for (Node<K, V> head : oldTable) {
            while (head != null) {
                put(head.key, head.value);
                head = head.next;
            }
        }
    }

    // ---------- ITERATOR ----------
    @Override
    public Iterator<K> iterator() {
        return new KeyIterator();
    }

    public Iterator<K> keyIterator() {
        return iterator();
    }

    private class KeyIterator implements Iterator<K> {

        int bucketIndex = 0;
        Node<K, V> current;

        KeyIterator() {
            advance();
        }

        private void advance() {
            while (bucketIndex < table.length && table[bucketIndex] == null) {
                bucketIndex++;
            }
            if (bucketIndex < table.length) {
                current = table[bucketIndex];
            }
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public K next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            K key = current.key;

            if (current.next != null) {
                current = current.next;
            } else {
                bucketIndex++;
                current = null;
                advance();
            }
            return key;
        }
    }
}


/*


Hashing – Complete Example (Step by Step)

Key  : "John"
Value: 25 (age)

Step 1: hashCode()
------------------
hashCode = 2301506

32-bit binary representation:
h =
00000000 00100011 00000100 00100010


Step 2: Logical Right Shift (h >>> 16)
-------------------------------------
h >>> 16 =
00000000 00000000 00000000 00100011


Step 3: Hash Mixing using XOR
-----------------------------
h            = 00000000 00100011 00000100 00100010
h >>> 16     = 00000000 00000000 00000000 00100011
--------------------------------------------------
mixedHash    = 00000000 00100011 00000100 00000001

Step 4: Mixed Hash Value
-----------------------
mixedHash = 0x00230401
mixedHash = 2301697

This mixed hash is used by HashMap to determine the bucket.
Step 5: Bucket Index Calculation
--------------------------------
Array size (n) = 16
n - 1 = 15

Binary of (n - 1):
0000 1111
Last 4 bits of mixedHash:
mixedHash = 2301697 → ends with 0001

Index calculation:
0001 & 1111 = 0001
Bucket Index = 1  ,So the key "John" is stored in table[1].

 */
