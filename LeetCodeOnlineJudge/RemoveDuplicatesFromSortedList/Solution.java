// Given a sorted linked list, delete all duplicates such that each element appear only once.
//
// For example,
// Given 1->1->2, return 1->2.
// Given 1->1->2->3->3, return 1->2->3. 
public class Solution{
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode p = head;
        ListNode prev = p;
        p = p.next;
        while(p != null){
            if(prev != null && p.val == prev.val){
                p = p.next;
            }else if(prev != null && p.val != prev.val){
                prev.next.val = p.val;
                prev = prev.next;
                p = p.next;
            }else{
                break;
            }
        }
        if(prev!=null){
            prev.next = null;
        }
        return head;
    }
    public void printlist(ListNode head){
        while(head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        ListNode r = new ListNode(-3);
        r.next = new ListNode(-1);
        r.next.next = new ListNode(-1);
        sol.printlist(r);
        ListNode t = sol.deleteDuplicates(r);
        sol.printlist(t);


    }
}
