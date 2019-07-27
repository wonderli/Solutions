import java.util.*;
public class Solution{
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        int val = root.val;
        int rootMax = Math.max(maxPath(root.left) + val, maxPath(root.right) + val);
        rootMax = Math.max(maxPath(root.left) + val + maxPath(root.right), rootMax);
        rootMax = Math.max(rootMax, val);
        max = Math.max(rootMax, max);
        maxPathSum(root.left);
        maxPathSum(root.right);
        return max;
    }
    public int maxPath(TreeNode root){
        if(root == null) return 0;
        int val = root.val;
        int max = Integer.MIN_VALUE;
        max = Math.max(val, val + maxPath(root.left));
        max = Math.max(max, val + maxPath(root.right));
        return max;
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
