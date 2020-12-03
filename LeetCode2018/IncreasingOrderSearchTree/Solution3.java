import java.util.*;
public class Solution3{
    TreeNode dummyHead = new TreeNode();
       TreeNode curr = dummyHead;
       public TreeNode increasingBST(TreeNode root) {
           if(root == null) return null;
           helper(root);
           return dummyHead.right;
       }
       private void helper(TreeNode root){
           if(root == null) return;
           TreeNode left = root.left;
           TreeNode right = root.right;
           increasingBST(left);
           root.left = null;
           root.right = null;
           curr.right = root;
           curr = curr.right;
           increasingBST(right);
       }
	   
    public static void main(String args[]){
        Solution3 sol = new Solution3();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    TreeNode(){}
}
