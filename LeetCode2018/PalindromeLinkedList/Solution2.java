import java.util.*;
public class Solution2{
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        int n = count(head);
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        for(int i = 0; i < n/2; i++){
            stack.push(curr);
            curr = curr.next;
        }
        if(n % 2 != 0){
            curr = curr.next;
        } 
        while(curr != null){
            ListNode node = stack.pop();
            if(node.val != curr.val) return false;
            curr = curr.next;
        }
        return true;
    }
    public int count(ListNode head){
        int i = 0;
        while( head != null){
            head = head.next;
            i++;
        }
        return i;
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
