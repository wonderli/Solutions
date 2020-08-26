import java.util.*;
public class Solution{
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        if(head.next == null) return head;
        ListNode oldTail = head;
        int i = 1;
        while(oldTail.next != null){
            oldTail = oldTail.next;
            i++;
        }
        oldTail.next = head;
        ListNode newTail = head;
        for(int j = 0; j < i - k % i-1; j++){
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(int x, ListNode n){val = x; next = n;}
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
