import java.util.*;
public class Solution{
    public void flatten(TreeNode root) {
        if(root == null) return;
        f(root);
    }
    public TreeNode f(TreeNode root){
        if(root == null) return null;
        TreeNode leftTail =f(root.left);
        TreeNode rightTail = f(root.right);
        if(root.left != null){
            TreeNode tmp = root.right;
            root.right = root.left;
            root.left = null;
            leftTail.right = tmp;
        }
        if(rightTail != null) return rightTail;
        if(leftTail != null) return leftTail;
        return root;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = null;
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(5);
        sol.flatten(root);
        sol.print(root);
        sol.printRight(root);
    }
    public void printRight(TreeNode root){
        System.out.println();
        while(root != null){
            System.out.print(root.val + "->");
            root = root.right;
        }
        System.out.println();
    }
    public void print(TreeNode root){
        if(root == null) return;
        print(root.left);
        System.out.print(root.val + "->");
        print(root.right);
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
