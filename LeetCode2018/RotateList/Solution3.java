import java.util.*;
public class Solution3{
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        int len = getLen(head);
        k = k % len;
        
        if(k == 0) return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && k != 0){
            fast = fast.next;
            k--;
        }
        
        ListNode prev = null;
        ListNode prevFast = null;
        while(fast != null){
            prev = slow;
            slow = slow.next;
            prevFast = fast;
            fast = fast.next;
        }
        prevFast.next = head;
        ListNode h = slow;
        prev.next = null;
        return h;
        

    }
    public int getLen(ListNode head){
        int count = 0;
        while(head != null){
            head = head.next;
            count++;
        }
        return count;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(int x, ListNode n){ val = x; next = n;}
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
