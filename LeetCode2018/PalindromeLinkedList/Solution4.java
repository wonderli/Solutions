import java.util.*;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode p = null;
    public boolean isPalindrome(ListNode head) {
        p = head;
        return helper(head);
    }
    private boolean helper(ListNode curr){
        if(curr == null) return true;
        if(!helper(curr.next)){
            return false;
        }
        if(curr.val != p.val){
            return false;
        }
        p = p.next;
        return true;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int x) { val = x; next = null; }
}