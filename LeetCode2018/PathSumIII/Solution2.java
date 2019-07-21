import java.util.*;
public class Solution2{
    private int result = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        path(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return result;
    }
    public void path(TreeNode root, int sum){
        if(root == null) return;
        if(root.val == sum){
            result++;
        }
        path(root.left, sum - root.val);
        path(root.right, sum - root.val);
    }
     
    public static void main(String args[]){
        Solution2 sol = new Solution2();
        //TreeNode root = new TreeNode(10);
        //root.left = new TreeNode(5);
        //root.right = new TreeNode(-3);
        //root.left.left = new TreeNode(3);
        //root.left.right = new TreeNode(2);
        //root.left.left.left = new TreeNode(3);
        //root.left.left.right = new TreeNode(-2);
        //root.left.right.right = new TreeNode(1);
        //root.right.right = new TreeNode(11);
        //System.out.println(sol.pathSum(root, 8));
        //   TreeNode root = new TreeNode(10);
        //   root.left = new TreeNode(5);
        //   root.right = new TreeNode(-3);
        //   root.left.left = new TreeNode(3);
        //   root.left.right = new TreeNode(2);
        //   root.right.right = new TreeNode(11);
        //   root.left.left.left = new TreeNode(3);
        //   root.left.left.right = new TreeNode(-2);
        //   System.out.println(sol.pathSum(root, 8));
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(-2);
        root.left.left.left = new TreeNode(-1);
        System.out.println(sol.pathSum(root, -1));
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
