import java.util.*;
public class Solution3{
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0){
            return null;
        }
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    public TreeNode helper(int[] inorder, int i, int j, int[] postorder, int p, int q){
        if(i > j) return null;
        TreeNode root = new TreeNode(postorder[q]);
        int index = find(inorder, i, j, root.val);
        root.right = helper(inorder, index + 1, j, postorder, index, q - 1);
        root.left = helper(inorder, i, index - 1, postorder, p, q - ( j - index) - 1);
        return root;
    }
    public int find(int[] inorder, int i, int j, int val){
        for(int m = j; m >= i; m--){
            if(inorder[m] == val){
                return m;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        Solution3 sol = new Solution3();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(int x, ListNode n){ val = x; next = n;}
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
