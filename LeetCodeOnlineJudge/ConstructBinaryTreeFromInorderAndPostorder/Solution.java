import java.util.*;
public class Solution{
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length < 1 || postorder.length < 1) return null;
        int rootVal = postorder[postorder.length - 1];
        int rootPos = findPos(inorder, rootVal);
        TreeNode root = new TreeNode(rootVal);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootPos);
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, rootPos);
        int[] rightInorder = Arrays.copyOfRange(inorder, rootPos + 1, inorder.length);
        int[] rightPostorder = Arrays.copyOfRange(postorder, rootPos, postorder.length - 1);
        root.left = buildTree(leftInorder, leftPostorder);
        root.right = buildTree(rightInorder, rightPostorder);
        return root;
    }
    public int findPos(int inorder[], int val){
        int i = 0;
        for(i = 0; i < inorder.length; i++){
            if(val == inorder[i]){
                break;
            }
        }
        return i;
    }
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
    public static void main(String args[]){
        Solution s = new Solution();
        int[] inorder = {1,2,3,4,5,6,7,8};
        int[] postorder = {1,2,4,3,6,8,7,5};
        TreeNode root = s.buildTree(inorder, postorder);
        s.inorder(root);
    }
}
