import java.util.*;
public class Solution{
    public int findSecondMinimumValue(TreeNode root) {
        if(root.left == null) return -1;

        int left = -1;
        if(root.val != root.left.val){
            left = root.left.val;
        } else{
            left = findSecondMinimumValue(root.left);
        }
        int right = -1;
        if(root.val != root.right.val){
            right = root.right.val;
        } else {
            right = findSecondMinimumValue(root.right);
        }
        if(left == -1 || right == -1){
            return Math.max(left, right);
        }else {
            return Math.min(left, right);
        }
    }

    public static void main(String args[]){
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(2);
        System.out.println(sol.findSecondMinimumValue(root));
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
