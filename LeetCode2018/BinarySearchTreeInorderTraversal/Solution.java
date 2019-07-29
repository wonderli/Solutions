import java.util.*;
public class Solution{
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret= new ArrayList<>();
        helper(root, ret);
        return ret;
    }
    public void helper(TreeNode root, List<Integer> list){
        if(root == null) return;
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
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
