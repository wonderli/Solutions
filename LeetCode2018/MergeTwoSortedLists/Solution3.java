import java.util.*;
public class Solution3{
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode dummy = new ListNode(0);
//        ListNode head = dummy;
//        while(l1 != null && l2 != null){
//            if(l1.val < l2.val){
//                head.next = l1;
//                l1 = l1.next;
//            }else {
//                head.next = l2;
//                l2 = l2.next;
//            }
//            head = head.next;
//        }
//        if(l1 != null){
//            head.next = l1;
//        }else {
//            head.next = l2;
//        }
//        return dummy.next;
//    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    public static void main(String args[]){
        Solution3 sol = new Solution3();
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
