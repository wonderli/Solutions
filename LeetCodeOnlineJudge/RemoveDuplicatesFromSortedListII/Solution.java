// Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
//
// For example,
// Given 1->2->3->3->4->4->5, return 1->2->5.
// Given 1->1->1->2->3, return 2->3. 
public class Solution{
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode prev = h;
        ListNode curr = head;
        while(curr != null){
            boolean dup = false;
            while(curr.next != null && curr.next.val == curr.val){
                dup = true;
                curr = curr.next;
            }
            if(dup){
                prev.next = curr.next;
                curr = curr.next;
            }else{
                prev = curr;
                curr = curr.next;
            }
        }
        return h.next;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
