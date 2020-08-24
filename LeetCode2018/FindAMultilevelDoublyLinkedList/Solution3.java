import java.util.*;
public class Solution3{
    public Node flatten(Node head) {
        if(head == null) return head;
        Node curr = head;
        while(curr != null){
            if(curr.child == null){
                curr = curr.next;
                continue;
            }
            Node tmp = curr.child;
            while(tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = curr.next;
            if(curr.next != null) curr.next.prev = tmp;
            curr.next = curr.child;
            curr.child.prev = curr;
            curr.child = null;
        }
        return head;
    }
    public static void main(String args[]){
        Solution3 sol = new Solution3();
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
