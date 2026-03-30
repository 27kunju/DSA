package leetcodeSystemDesigns;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;

    private final Node head; // dummy head
    private final Node tail; // dummy tail

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);

        // move to front (most recently used)
        remove(node);
        addToFront(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;

            remove(node);
            addToFront(node);
            return;
        }

        if (map.size() == capacity) {
            // remove least recently used (tail.prev)
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        addToFront(newNode);
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);

        cache.put(1, 100);
        cache.put(2, 200);

        System.out.println(cache.get(1)); // 100

        cache.put(3, 300); // evicts key 2

        System.out.println(cache.get(2)); // -1
        System.out.println(cache.get(3)); // 300
    }
}