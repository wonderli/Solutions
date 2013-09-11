// Reverse a linked list from position m to n. Do it in-place and in one-pass.
//
// For example:
// Given 1->2->3->4->5->NULL, m = 2 and n = 4,
//
// return 1->4->3->2->5->NULL. 
public class Solution{
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy; 
        ListNode p2 = dummy;
        ListNode rPrev = dummy;
        ListNode rNext = null;
        while(m != 0){
            rPrev = p1;
            p1 = p1.next;
            m--;
        }
        while(n != 0){
            p2 = p2.next;
            n--;
        }
        rNext = p2.next;
        ListNode prev = rNext;
        ListNode rHead = p1;
        ListNode rEnd = p2;
        while(rHead != rNext){
            ListNode tmp = rHead.next;
            rHead.next = prev;
            prev = rHead;
            rHead = tmp;
        }
        rPrev.next = rEnd;
        return dummy.next;
    }
    public void printList(ListNode n){
        while(n != null){
            System.out.print(n.val + " ");
            n = n.next;
        }
        System.out.println();
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        ListNode r = new ListNode(1);
        r.next = new ListNode(2);
        r.next.next = new ListNode(3);
        r.next.next.next = new ListNode(4);
        r.next.next.next.next = new ListNode(5);
        sol.printList(r);
        ListNode n = sol.reverseBetween(r, 1, 2);
        //ListNode n = sol.reverse(r);
        sol.printList(n);
    }
}
