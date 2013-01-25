//Given a list, rotate the list to the right by k places, where k is non-negative.
//
//For example:
//Given 1->2->3->4->5->NULL and k = 2,
//return 4->5->1->2->3->NULL.
public class Solution{
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy;
        int len = 0;
        while(p1.next != null){
            p1 = p1.next;
            len++;
        }
        k = k % len;
        if(k == 0) return dummy.next;
        p2 = dummy;
        for(int i = 0; i < len - k; i++){
            p2 = p2.next;
        }
        ListNode prev = p2;
        p2 = p2.next;
        dummy.next = p2;
        p1.next = head;
        prev.next = null;
        return dummy.next;
    }
    public static void printList(ListNode n){
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
        printList(r);
        int k = 2;
        ListNode n = sol.rotateRight(r, k);
        printList(n);
        
    }
}

