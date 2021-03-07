import java.util.*;
public class Solution{
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(0);
        ListNode oh = oddHead;
        ListNode evenHead = new ListNode(0);
        ListNode eh = evenHead;

        int i = 1;
        while(head != null){
            if(i%2 == 1){
                oddHead.next = head;
                oddHead = oddHead.next;
            }else{
                evenHead.next = head;
                evenHead = evenHead.next;
            }
            head = head.next;
            i++;
        }
        oddHead.next = eh.next;
        evenHead.next = null;
        return oh.next;
    }
    private ListNode create(int[] nums){
        ListNode h = new ListNode(0);
        ListNode head = h;
        for(int i : nums){
            h.next = new ListNode(i);
            h = h.next;
        }
        return head.next;
    }
    public void print(ListNode head){
        while(head != null){
            System.out.print(head.val + (head.next == null ? "\n" : "->"));
            head = head.next;
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = sol.create(nums);
        sol.print(head);
        ListNode n = sol.oddEvenList(head);
        sol.print(n);


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
