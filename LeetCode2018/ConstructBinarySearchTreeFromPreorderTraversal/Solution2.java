import java.util.*;
public class Solution2{
    public TreeNode bstFromPreorder(int[] preorder){
        if(preorder == null || preorder.length == 0) return null;
        return helper(preorder, 0, preorder.length - 1);
    }
    public TreeNode helper(int[] preorder, int start, int end){
        if(start > end) return null;
        if(start == end) return new TreeNode(preorder[start]);
        TreeNode root = new TreeNode(preorder[start]);
        int mid = start + 1;
        while(mid <= end && preorder[mid] < preorder[start]){
            mid++;
        }

        root.left = helper(preorder, start + 1, mid - 1);
        root.right = helper(preorder, mid , end);
        return root;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();

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
