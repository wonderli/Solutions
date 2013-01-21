//Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
//
//You should preserve the original relative order of the nodes in each of the two partitions. 
//For example,
//Given 1->4->3->2->5->2 and x = 3,
//return 1->2->2->4->3->5. 
public class Solution{
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        ListNode s = new ListNode(0);
        ListNode l = new ListNode(0);
        ListNode ret = s;
        ListNode lp = l;
        while(head != null){
            if(head.val < x){
                s.next = new ListNode(head.val);
                s = s.next;
            }else{
                l.next = new ListNode(head.val);
                l = l.next;
            }
            head = head.next;
        }
        s.next = lp.next;
        return ret.next;
    }
    public void printList(ListNode n){
        System.out.println();
        while(n != null){
            System.out.print(n.val + " ");
            n = n.next;
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        ListNode r  = new ListNode(1);
        r.next = new ListNode(4);
        r.next.next = new ListNode(3);
        r.next.next.next = new ListNode(2);
        r.next.next.next.next = new ListNode(5);
        r.next.next.next.next.next = new ListNode(2);
        sol.printList(r);
        ListNode n = sol.partition(r, 3);
        sol.printList(n);
    }
}

