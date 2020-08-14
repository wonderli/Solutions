import java.util.*;
public class Solution{
    public int[] sortArrayByParity(int[] A) {
        if(A == null || A.length == 0) return A;
        int j = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] % 2 == 0){
                int tmp = A[j];
                A[j] = A[i];
                A[i] = tmp;
                j++;
            }
        }
        return A;
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
