import java.util.*;
public class Solution2{
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode x= null;
        TreeNode y= null;
        TreeNode prev =null;
        TreeNode curr = root;
        while(!stack.isEmpty()|| curr != null){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            if(prev != null && curr.val < prev.val){
                y = curr;
                if(x == null) x = prev;
                else break;
            }
            prev= curr;
            curr=curr.right;
        }
        int tmp = x.val;
        x.val =y.val;
        y.val = tmp;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int x) { val = x; next = null; }
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
