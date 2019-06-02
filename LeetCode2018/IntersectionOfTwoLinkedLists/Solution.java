import java.util.*;
public class Solution{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        if(lenA > lenB){
            headA = move(headA, lenA - lenB);
        }else {
            headB = move(headB, lenB - lenA);
        }
        while(headA != null){
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    public ListNode move(ListNode head, int len){
        while(len > 0){
            head = head.next;
            len--;
        }
        return head;
    }
    public int getLen(ListNode head){
        int i = 0;
        while(head != null){
            head = head.next;
            i++;
        }
        return i;
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
