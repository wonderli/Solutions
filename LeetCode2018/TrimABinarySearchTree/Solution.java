import java.util.*;
public class Solution{
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null) return null;
        int val = root.val;
        if(L <= val && val <= R){
            root.left = trimBST(root.left, L, val);
            root.right = trimBST(root.right, val, R);
        }
        if(val < L){
            root = trimBST(root.right, L, R);
        }
        if(val > R){
            root = trimBST(root.left, L, R);
        }
        return root;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        TreeNode n = new TreeNode(3);
        n.left = new TreeNode(0);
        n.right = new TreeNode(4);
        n.left.right = new TreeNode(2);
        n.left.right.left = new TreeNode(1);
        TreeNode t = sol.trimBST(n, 1, 3);
        sol.print(t);
    }
    public void print(TreeNode n){
        if(n == null) return;
        print(n.left);
        System.out.println(n.val);
        print(n.right);
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
