import java.util.*;
public class Solution{
     public int pathSum(TreeNode root, int sum) {
         if(root == null) return 0;
         return path(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
     }
     public int path(TreeNode root, int sum){
         if(root == null) {
             return 0;
         }
         return (sum == root.val ? 1 : 0) + path(root.left, sum - root.val) + path(root.right, sum - root.val);
     }
    //public int pathSum(TreeNode root, int sum) {
    //    if (root == null) return 0;
    //    return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    //}

    //private int pathSumFrom(TreeNode node, int sum) {
    //    if (node == null) return 0;
    //    return (node.val == sum ? 1 : 0) 
    //        + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    //}
    public static void main(String args[]){
        Solution sol = new Solution();
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
