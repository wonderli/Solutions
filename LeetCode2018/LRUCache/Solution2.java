import java.util.*;
public class Solution2{
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
class LRUCache {

    private class Node {
        Node prev;
        Node next;
        int value;
        int key;

        public Node() {

        }

        public Node(int key, int val) {
            this.value = val;
            this.key = key;
        }
    }

    int capacity = 0;
    Node head;
    Node tail;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.isEmpty() || !map.containsKey(key)) {
            return -1;
        }
        Node n = map.get(key);

        Node prev = n.prev;
        Node next = n.next;

        prev.next = next;
        next.prev = prev;

        Node tailPrev = tail.prev;
        tailPrev.next = n;
        n.prev = tailPrev;
        n.next = tail;
        tail.prev = n;
        return n.value;
    }

    public void put(int key, int value) {
        Node n = null;
        if (map.containsKey(key)) {
            n = map.get(key);
            n.value = value;
            Node prev = n.prev;
            Node next = n.next;
            prev.next = next;
            next.prev = prev;

        } else {
            n = new Node(key, value);
        }
        Node tailPrev = tail.prev;
        tailPrev.next = n;
        n.prev = tailPrev;
        n.next = tail;
        tail.prev = n;

        map.put(n.key, n);
        if(map.size() > capacity){
            Node headNext = head.next;
            map.remove(headNext.key);
            Node headNextNext = headNext.next;
            head.next = headNextNext;
            headNextNext.prev= head;
        }
    }

    public static void main(String[] args) {
        int size = 1;
        LRUCache lruCache = new LRUCache(size);
        lruCache.put(2, 1);
        lruCache.get(2);
        lruCache.put(3, 2);
        System.out.println(lruCache.get(2));

    }
}
