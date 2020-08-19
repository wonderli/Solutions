import java.util.*;
public class Solution3{
    ListNode first = null;
    public boolean isPalindrome(ListNode head) {
        first = head;
        return helper(head);
    }
    public boolean helper(ListNode curr){
        if(curr != null){
            if(!helper(curr.next)){
                return false;
            }
            if(curr.val != first.val){
                return false;
            }
            first = first.next;
        }
        return true;
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
