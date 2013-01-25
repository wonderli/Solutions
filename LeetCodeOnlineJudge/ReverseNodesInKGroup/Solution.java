// Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
//
// If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
//
// You may not alter the values in the nodes, only nodes itself may be changed.
//
// Only constant memory is allowed.
//
// For example,
// Given this linked list: 1->2->3->4->5
//
// For k = 2, you should return: 2->1->4->3->5
//
// For k = 3, you should return: 3->2->1->4->5 
public class Solution{
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode p1 = dummy;
        ListNode p2 = dummy;
        ListNode last = head;
        int count = 0;
        while(count < k && p2.next != null){
            p2 = p2.next;
            count++;
        }
        if(count < k){
            return dummy.next;
        }
        ListNode nextStart = null;
        if(p2 != null){
            nextStart = p2.next;
        }
        while(p1 != nextStart){
            ListNode tmp = p1.next;
            p1.next = prev;
            prev = p1;
            p1 = tmp;
        }
        dummy.next = p2;
        last.next = reverseKGroup(nextStart, k);
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
        //r.next.next.next.next.next = new ListNode(6);
        printList(r);
        int k = 6;
        ListNode n = sol.reverseKGroup(r, k);
        printList(n);
    }
}
