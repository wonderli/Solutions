//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
import java.util.*;
public class Solution{
    public TreeNode sortedArrayToBST(int[] num) {
        if(num == null || num.length < 1) return null;
        int mid = num.length / 2;
        TreeNode root = new TreeNode(num[mid]);
        int leftArray[] = Arrays.copyOfRange(num, 0, mid);
        int rightArray[] = Arrays.copyOfRange(num, mid + 1, num.length);
        root.left = sortedArrayToBST(leftArray);
        root.right = sortedArrayToBST(rightArray);
        return root;
    }
    public static void main(String args[]){
    }
}
