import java.util.*;
public class Solution{
    private int max;
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;
        helper(root);
        return max;
    }
    public Result helper(TreeNode root){
        if(root == null) return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        Result left = helper(root.left);
        Result right = helper(root.right);
        if(left.size == -1 || right.size == -1 || root.val <= left.upper || root.val >= right.lower){
            return new Result(-1, 0, 0);
        }
        int size = left.size + 1 + right.size;
        max = Math.max(max, size);
        return new Result(size, Math.min(left.lower, root.val), Math.max(right.upper,root.val));
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class Result{
    int size;
    int lower;
    int upper;
    Result(int size, int lower, int upper){
        this.size = size;
        this.lower = lower;
        this.upper = upper;
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
