import java.util.*;
public class Solution2{
    public ListNode oddEvenList(ListNode head) {
        ListNode d1 = new ListNode(0);
        ListNode d2 = new ListNode(0);
        int i = 1;
        ListNode curr = head;
        ListNode odd = d1;
        ListNode even = d2;
        while(curr != null){
            if(i%2 == 1){
                odd.next = curr;
                odd = odd.next;
            }else{
                even.next = curr;
                even = even.next;
            }
            curr = curr.next;
            i++;
        }
        even.next = null;
        odd.next = d2.next;
        return d1.next;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
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
