//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
import java.util.*;
public class Solution2{
    public TreeNode sortedArrayToBST(int[] num) {
        if(num == null) return null;
        int len = num.length;
        TreeNode root = helper(num, 0, len - 1);
        return root;
    }
    public TreeNode helper(int[] num, int start, int end){
        if(start > end) return null;
        int mid = start + (end - start)/2;
        TreeNode left = helper(num, start, mid - 1);
        TreeNode root = new TreeNode(num[mid]);
        TreeNode right = helper(num, mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }
    public static void main(String args[]){
    }
}
