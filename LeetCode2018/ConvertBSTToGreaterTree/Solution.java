import java.util.*;
public class Solution{
    private int sum = 0;
    public TreeNode convertBST(TreeNode node) {
        if(node != null){
            convertBST(node.right);
            sum += node.val;
            node.val = sum;
            convertBST(node.left);
        }
        return node;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
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
