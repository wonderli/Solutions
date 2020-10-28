import java.util.*;
public class Solution{
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode p1 = getMid(head);
        ListNode s1 = sortList(head);
        ListNode s2 = sortList(p1);
        ListNode s3 = merge(s1, s2);
        return s3;
    }
    private ListNode merge(ListNode p1, ListNode p2){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                curr.next = p1;
                p1 = p1.next;
                curr = curr.next;
            }else{
                curr.next = p2;
                p2 = p2.next;
                curr = curr.next;
            }
        }
        curr.next = (p1 != null) ? p1 : p2;
        return dummy.next;
    }
    private ListNode getMid(ListNode head){
        ListNode prev = null;
        while(head != null && head.next != null){
            prev = (prev == null) ? head : prev.next;
            head = head.next.next;
        }
        ListNode mid = prev.next;
        prev.next = null;
        return mid;
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
