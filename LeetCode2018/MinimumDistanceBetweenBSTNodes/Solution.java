import java.util.*;
public class Solution{
    private Integer prev = null;
    private int min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root){
        if(root == null) return min;

        minDiffInBST(root.left);
        if(prev != null){
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        minDiffInBST(root.right);
        return min;
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
