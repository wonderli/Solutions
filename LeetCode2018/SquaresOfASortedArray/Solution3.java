import java.util.*;
public class Solution3{
    public int[] sortedSquares(int[] A){
        int[] ret = new int[A.length];
        int i = 0;
        int j = A.length - 1;
        for(int m = A.length - 1; m >= 0; m--){
            if(A[i] * A[i] < A[j] * A[j]){
                ret[m] = A[j] * A[j];
                j--;
            }else{
                ret[m] = A[i] * A[i];
                i++;
            }
        }
        return ret;
    }
    public static void main(String args[]){
        Solution3 sol = new Solution3();
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
