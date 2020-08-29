import java.util.*;
public class Solution2{
    int index = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0){
            return null;
        }
        index = postorder.length - 1;
        return helper(inorder, 0, inorder.length - 1, postorder);
    }
    public TreeNode helper(int[] inorder, int i, int j, int[] postorder){
        if(i > j) return null;
        TreeNode root = new TreeNode(postorder[index]);
        int idx = find(inorder, i, j, root.val);
        index--;
        root.right = helper(inorder, idx + 1, j, postorder);
        root.left = helper(inorder, i, idx - 1, postorder);
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
        Solution2 sol = new Solution2();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
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
