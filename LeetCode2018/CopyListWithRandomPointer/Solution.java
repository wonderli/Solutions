import java.util.*;
public class Solution{
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Node curr = head;
        Node start = new Node(curr.val);
        Node p1 = start;
        Map<Node, Node> map = new HashMap<>();
        map.put(curr, start);
        while(curr.next != null){
            curr = curr.next;
            p1.next = new Node(curr.val);
            p1 = p1.next;
            map.put(curr, p1);
        }
        Node p2 = head;
        Node p3 = start;
        while(p2 != null){
            if(p2.random != null){
                Node r = p2.random;
                p3.random = map.get(r);
            }
            p2 = p2.next;
            p3 = p3.next;
        }
        return start;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
