import java.util.*;
public class Solution4{
    ListNode odd = new ListNode();
    ListNode currOdd = odd;
    ListNode even = new ListNode();
    ListNode currEven = even;
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        helper(head, true);
        currOdd.next = even.next;
        currEven.next = null;
        return odd.next;
    }

    public void helper(ListNode head, boolean isOdd){
        if(head == null) return;
        if(isOdd){
            currOdd.next = head;
            currOdd = currOdd.next;
        }else{
            currEven.next = head;
            currEven = currEven.next;
        }
        head = head.next;
        helper(head, !isOdd);
    }
    public static void main(String args[]){
        Solution4 sol = new Solution4();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int x) { val = x; next = null; }
}
