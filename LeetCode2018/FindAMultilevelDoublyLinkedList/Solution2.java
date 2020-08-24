import java.util.*;
public class Solution2{
    public Node flatten(Node head){
        if(head == null) return head;
        Node dummy = new Node(0, null, head, null);
        Node curr = dummy;
        Node prev = dummy;
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while(!stack.isEmpty()){
            curr = stack.pop();
            prev.next = curr;
            curr.prev = prev;
            if(curr.next != null) stack.push(curr.next);
            if(curr.child != null){
                stack.push(curr.child);
                curr.child = null;
            }
            prev = curr;
        }
        dummy.next.prev = null;
        return dummy.next;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
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
