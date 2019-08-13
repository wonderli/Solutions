import java.util.*;
public class Solution{
    public int fixedPoint(int[] A) {
        if(A == null || A.length == 0) return -1;
        for(int i = 0 ; i < A.length; i++){
            if(A[i] == i) return i;
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
