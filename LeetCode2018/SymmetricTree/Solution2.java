import java.util.*;
public class Solution2{
    public boolean isSymmetric(TreeNode root){
        if(root == null) return true;
        return isMirror(root.left, root.right);
    }
    private boolean isMirror(TreeNode n1, TreeNode n2){
        if(n1 == null && n2 == null) return true;
        if(n1 == null || n2 == null) return false;
        return (n1.val == n1.val) && isMirror(n1.left, n2.right) && isMirror(n1.right, n2.left);
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
