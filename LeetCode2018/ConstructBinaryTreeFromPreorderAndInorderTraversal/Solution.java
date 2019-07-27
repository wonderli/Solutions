import java.util.*;
public class Solution{
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        return build(preorder, 0, inorder, 0, inorder.length - 1);
    }
    public TreeNode build(int[] preorder, int pIndex,  int[] inorder, int iStart, int iEnd) {
        if(pIndex >= preorder.length || iStart > iEnd) return null;
        TreeNode root = new TreeNode(preorder[pIndex]);
        int i = find(inorder, preorder[pIndex], iStart, iEnd);
        if(i == -1) return null;
        root.left = build(preorder, pIndex+1, inorder, iStart, i - 1);
        root.right = build(preorder, pIndex + i - iStart + 1, inorder, i + 1, iEnd);
        return root;
    }
    public int find(int[] inorder, int val, int iStart, int iEnd){
        for(int i = iStart; i <= iEnd ; i++){
            if(inorder[i] == val){
                return i;
            }
        }
        return -1;
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
