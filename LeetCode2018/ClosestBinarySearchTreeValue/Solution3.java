import java.util.*;
public class Solution3{
    double min = Double.MAX_VALUE;
    public int closestValue(TreeNode root, double target){
        helper(root, target);
        return (int)min;
    }
    public void helper(TreeNode root, double target){
        if(root == null){
            return;
        }
        if(Math.abs(root.val - target) < Math.abs(min - target)){
            min = root.val;
        }
        if(root.val < target){
            helper(root.right, target);
        }else {
            helper(root.left, target);
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
    ListNode(int x, ListNode n){ val = x; next = n;}
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
