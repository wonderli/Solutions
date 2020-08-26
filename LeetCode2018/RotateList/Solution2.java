import java.util.*;
public class Solution2{
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        ListNode p = head;
        int len = 1;
        while(p.next != null){
            p = p.next;
            len++;
        }
        p.next = head;
        k = k % len;
        for(int i = 0; i < len - k; i++){
            p = p.next;
        }
        head = p.next;
        p.next = null;
        return head;
    }
    
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
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
