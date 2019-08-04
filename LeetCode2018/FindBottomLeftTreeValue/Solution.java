import java.util.*;
public class Solution{
    int res;
    int depth;
    public int findBottomLeftValue(TreeNode root) {
        res = root.val;
        depth = 0;
        helper(root, 1);
        return res;
    }
    public void helper(TreeNode node, int currDepth){
        if(node == null) return;
        if(currDepth > depth){
            depth = currDepth;
            res = node.val;
        }
        helper(node.left, currDepth+1);
        helper(node.right,currDepth+1);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        TreeNode root = new TreeNode(0);
        root.right = new TreeNode(1);
        System.out.println(sol.findBottomLeftValue(root));
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
