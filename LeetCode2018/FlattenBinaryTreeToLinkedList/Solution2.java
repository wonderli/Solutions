import java.util.*;
class Solution{
    public void flatten(TreeNode root){
        if(root == null) return;
        TreeNode prev = null;
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                curr = curr.right;
            }else {
                prev = curr.left;
                while(prev.right != null){
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
        }
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
