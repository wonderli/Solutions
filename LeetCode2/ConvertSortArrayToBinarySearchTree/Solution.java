import java.util.*;
public class Solution{
    public TreeNode sortedArrayToBST(int[] num) {
        if(num == null || num.length == 0) return null;
        int l = 0;
        int len = num.length;
        return helper(l, len-1, num);
    }
    public TreeNode helper(int left, int right, int A[]){
        if(left > right) return null;
        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(A[mid]);
        TreeNode l = helper(left, mid - 1, A);
        TreeNode r = helper(mid + 1, right, A);
        root.left = l;
        root.right = r;
        return root;
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
