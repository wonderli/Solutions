import java.util.*;
public class Solution{
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;
        return isUnivalTree(root, root.val);
    }
    public boolean isUnivalTree(TreeNode root, int val){
        if(root == null) return true;
        int curr = root.val;
        return curr == val && isUnivalTree(root.left, val) && isUnivalTree(root.right, val);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
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
