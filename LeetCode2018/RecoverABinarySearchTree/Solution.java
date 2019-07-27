import java.util.*;
public class Solution{
    TreeNode prev;
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {
        prev= null;
        first = null;
        second = null;
        helper(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    public void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        if((prev != null) && (prev.val > root.val)){
            if(first == null){
                first = prev;
            }
            second = root;
        }
        prev = root;
        helper(root.right);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        //TreeNode root = new TreeNode(3);
        //root.left = new TreeNode(1);
        //root.right = new TreeNode(4);
        //root.right.left = new TreeNode(2);
        //List<TreeNode> list = new ArrayList<>();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
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
