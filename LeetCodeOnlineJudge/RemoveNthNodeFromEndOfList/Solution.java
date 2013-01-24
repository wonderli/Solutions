//Given a linked list, remove the nth node from the end of list and return its head.
//
public class Solution{
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null){
            return null;
        }
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode f = head;
        ListNode s = head;
        ListNode prev = dump;
        int i = 0;
        while(i < n){
            f = f.next;
            i++;
        }
        while(f != null){
            f = f.next;
            prev = s;
            s = s.next;
        }
        ListNode tmp = s.next;
        prev.next = (tmp != null) ? tmp : null;
        return dump.next;
    }
    public void printList(ListNode r){
        while(r!= null){
            System.out.print(r.val + " ");
            r = r.next;
        }
        System.out.println();
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int n = 2;
        ListNode r = new ListNode(1);
        r.next = new ListNode(2);
        sol.printList(r);
        ListNode d = sol.removeNthFromEnd(r, n);
        sol.printList(d);
    }
}
