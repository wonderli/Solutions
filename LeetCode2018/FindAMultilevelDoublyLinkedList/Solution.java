import java.util.*;
public class Solution{
    public Node flatten(Node head) {
        if(head == null) return head;
        Node dummy = new Node(0, null, head, null);
        dfs(dummy, head);
        dummy.next.prev = null;
        return dummy.next;
    }
    public Node dfs(Node prev, Node curr){
        if(curr == null) return prev;
        curr.prev = prev;
        prev.next = curr;

        Node tmpNext = curr.next;
        Node tail = dfs(curr, curr.child);
        curr.child = null;
        return dfs(tail, tmpNext);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    } 
};
