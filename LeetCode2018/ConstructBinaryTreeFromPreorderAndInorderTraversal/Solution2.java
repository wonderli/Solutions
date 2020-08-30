import java.util.*;
public class Solution2{
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0){
            return null;
        }
        return helper(inorder, 0, inorder.length - 1, preorder);
    }
    public TreeNode helper(int[] inorder, int start, int end, int[] preorder){
        if(start > end) return null;
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        int idx = find(inorder, start, end, root.val);
        root.left = helper(inorder, start, idx - 1, preorder);
        root.right = helper(inorder, idx + 1, end, preorder);
        return root;
    }
    public int find(int[] inorder, int start, int end, int val){
        for(int i = end; i >= start; i--){
            if(inorder[i] == val){
                return i;
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
