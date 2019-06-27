import java.util.*;
public class Solution{
    public boolean isPalindrome(ListNode head) {
        int len = getLen(head);
        if(len <= 1) return true;
        ListNode start = head;
        ListNode mid = split(head, len);
        ListNode reverseMid = reverse(mid);
        while(start != null && reverseMid != null){
            if(start.val != reverseMid.val){
                return false;
            }else {
                start = start.next;
                reverseMid = reverseMid.next;
            }
        }
        if(start != null || reverseMid != null) return false;
        return true;
    }
    public ListNode split(ListNode head, int len){
        int mid = len/2;
        boolean shouldMoveNext = len%2 == 1 ? true : false;
        ListNode prev = null;
        for(int i = 0; i < mid; i++){
            prev = head;
            head = head.next;
        }
        prev.next = null;
        if(shouldMoveNext){
            head = head.next;
        }
        return head;
    }
    public ListNode reverse(ListNode head){
        if(head == null) return null;
        ListNode prev = null;
        ListNode curr = head;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
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
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(2);
        l.next.next.next = new ListNode(2);
        l.next.next.next.next = new ListNode(1);
        System.out.println(sol.isPalindrome(l));
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
