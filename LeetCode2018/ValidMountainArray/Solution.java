import java.util.*;
public class Solution{
    public boolean validMountainArray(int[] A) {
        if(A == null || A.length < 3) return false;
        int i = 0;
        while(i < A.length - 1 && A[i] < A[i + 1]){
            i++;
        }
        if(i == 0 || i == A.length - 1) return false;
        while(i < A.length - 1 && A[i] > A[i+1]){
            i++;
        }
        if(i == A.length - 1) return true;
        return false;

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
