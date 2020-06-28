import java.util.*;
public class Solution2{
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return max;
    }
    public int maxGain(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(maxGain(root.left), 0);
        int right = Math.max(maxGain(root.right), 0);
        int price = root.val + left + right;
        max = Math.max(max, price);
        return root.val + Math.max(left, right);
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
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
