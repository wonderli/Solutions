import java.util.*;
public class Solution{
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return null;
        helper(root, null, val);
        return root;
    }
    public void helper(TreeNode root, TreeNode parent, int val){
        if(root == null){
            if(parent == null) return;
            else{
                int num = parent.val;
                if(val < num){
                    parent.left = new TreeNode(val);
                }else {
                    parent.right = new TreeNode(val);
                }
                return;
            }
        }
        if(val < root.val){
            helper(root.left, root, val);
        }else {
            helper(root.right,root, val);
        }
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
