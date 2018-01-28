import java.util.*;
public class Solution{
    public ListNode partition(ListNode head, int x) {
        if(head == null) return head;
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode smallP = small;
        ListNode largeP = large;
        ListNode p = head;
        while(p != null){
            if(p.val < x) {
                smallP.next = p;
                smallP = smallP.next;
            }else{
                largeP.next = p;
                largeP = largeP.next;
            }
            p = p.next;
        }
        smallP.next = large.next;
        largeP.next = null;
        return small.next;
    }
    public void printList(ListNode n){
        while(n != null){
            System.out.print(n.val + "->");
            n = n.next;
        }
        System.out.println();
    }
    public ListNode createList(int... args){
        ListNode n = new ListNode(0);
        ListNode p = n;
        for(int i = 0; i < args.length; i++){
            n.next = new ListNode(args[i]);
            n = n.next;
        }
        return p.next;
    }

    public static void main(String args[]){
        Solution sol = new Solution();
        ListNode l = sol.createList(1, 4, 3, 2, 5, 2);
        sol.printList(l);
        sol.printList(sol.partition(l, 3));

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
