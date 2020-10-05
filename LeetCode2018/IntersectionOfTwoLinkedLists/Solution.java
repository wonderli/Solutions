import java.util.*;
public class Solution{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = getLen(headA);
        int len2 = getLen(headB);
        ListNode a = len1 < len2 ? headA : headB;
        ListNode b = len1 < len2 ? headB : headA;
        for(int i = 0; i < Math.abs(len2 - len1); i++){
            b = b.next;
        }
        while(a != null && b != null){
            if(a == b) return a;
            a = a.next;
            b = b.next;
        }
        return null;
    }
    public int getLen(ListNode head){
        int len = 0;
        while(head != null){
            head = head.next;
            len++;
        }
        return len;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}
