import java.util.*;
class LRUCache {
    final int capacity;
    final ListNode head = new ListNode(1,0);
    final ListNode tail = new ListNode(-1,0);
    final Map<Integer, ListNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        final ListNode node = map.get(key);
        if(node == null){
            return -1;
        }
        updateNodeToHead(node);
        return node.val;
    }
    public void updateNodeToHead(ListNode node){
        if(head.next == node) return;
        ListNode headNext = head.next;

        ListNode nodePrev = node.prev;
        ListNode nodeNext = node.next;

        nodePrev.next = nodeNext;
        nodeNext.prev = nodePrev;

        node.next = headNext;
        node.prev = head;

        head.next = node;
        headNext.prev = node;
    }

//    private void printNode(ListNode node){
//        System.out.println(node.key + ", " + node.val);
//    }
    public void put(int key, int value) {
        if(capacity == 0) return;
        if(map.containsKey(key)){
            ListNode n = map.get(key);
            n.val = value;
            updateNodeToHead(n);
            return;
        }
        if(map.size() == capacity) {
            expireLeastRecentUsedCache();
        }

            ListNode current = new ListNode(key,value);
            ListNode headNext = head.next;
            head.next = current;
            current.prev = head;
            current.next = headNext;
            headNext.prev = current;
            map.put(key, current);
    }
    public void expireLeastRecentUsedCache(){
        final ListNode leastRecentUsed = tail.prev;
        final ListNode prev = leastRecentUsed.prev;
        prev.next = tail;
        tail.prev = prev;
        int key = leastRecentUsed.key;
        map.remove(key);
    }
    public void print(ListNode n){
        ListNode p = n;
        int i = 0;
        while(p!= null){
            System.out.print("(" + p.key + ", " + p.val + ")"  + "->");
            p = p.next;
            if(i > 5) break;
            i++;
        }
        System.out.println();
    }
}


class ListNode {
    int val;
    int key;
    ListNode prev;
    ListNode next;
    ListNode(int key, int value) { 
        this.key = key;
        this.val = value;
        prev = null;
        next = null; 
    }
}
