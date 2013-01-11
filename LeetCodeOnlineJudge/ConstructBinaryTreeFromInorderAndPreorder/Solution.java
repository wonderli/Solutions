//Given preorder and inorder traversal of a tree, construct the binary tree.
import java.util.*;
public class Solution{
    public TreeNode buildTree(int[] preorder, int[] inorder){
        if(preorder == null || inorder == null || preorder.length < 1 || inorder.length < 1){
            return null;
        }
        int rootVal = preorder[0];
        int rootPos = findPos(inorder, rootVal);
        TreeNode root = new TreeNode(rootVal);
        int leftPreorder[] = Arrays.copyOfRange(preorder, 1, rootPos + 1);
        int leftInorder[] = Arrays.copyOfRange(inorder, 0, rootPos);
        int rightPreorder[] = Arrays.copyOfRange(preorder, rootPos + 1, preorder.length);
        int rightInorder[] = Arrays.copyOfRange(inorder, rootPos + 1, inorder.length);
        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);
        return root;
    }
    public int findPos(int[] inorder, int val){
        int i = 0; 
        for(i = 0; i < inorder.length; i++){
            if(inorder[i] == val){
                break;
            }
        }
        return i;
    }
    public static void main(String args[]){
    }
}
