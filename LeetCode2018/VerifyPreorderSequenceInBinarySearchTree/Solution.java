import java.util.*;
public class Solution{
    public boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0) return true;
        int len = preorder.length;
        return helper(preorder, 0, len - 1);
    }
    public boolean helper(int[] preorder, int start, int end){
        if(start >= end) return true;
        int pivot = preorder[start];
        int mid = -1;
        for(int i = start + 1; i <= end; i++){
            if(mid == -1 && preorder[i] > pivot) mid = i; 
            if(mid != -1 && preorder[i] < pivot) return false;
        }
        if(mid == -1){
            return helper(preorder, start + 1, end);
        }else {
            return helper(preorder, start + 1, mid - 1) && helper(preorder, mid, end);
        }
    }

    
    public static void main(String args[]){
        Solution sol = new Solution();
        int[] arr = {5, 2, 1, 3, 6};
        System.out.println(sol.verifyPreorder(arr));
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
