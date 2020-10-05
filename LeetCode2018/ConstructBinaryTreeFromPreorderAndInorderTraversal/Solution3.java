import java.util.*;
public class Solution3{
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0){
            return null;
        }
        TreeNode root = helper(preorder, inorder, 0, inorder.length -1 );
        return root;
    }
    public TreeNode helper(int[] preorder, int[] inorder, int left ,int right){
        if(left > right){
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        int i = find(inorder, root.val, left, right);
        root.left = helper( preorder, inorder, left, i - 1);
        root.right = helper( preorder, inorder, i+1, right);
        return root;
    }
    public int find(int[] inorder, int val, int start, int end){
        for(int i = start; i <=  end; i++){
            if(val  == inorder[i]) return i;
        }
        return -1;
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
}
