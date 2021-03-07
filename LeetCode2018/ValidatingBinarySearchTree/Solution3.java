import java.util.*;
class Solution{
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        Integer prev = null;
        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(prev != null && prev >= curr.val) return false;
            prev = curr.val;
            curr = curr.right;
        }
        return true;
    }
    public void print(TreeNode root){
        if(root == null) return;
        print(root.left);
        System.out.println(root.val);
        print(root.right);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        sol.isValidBST(root);

    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
