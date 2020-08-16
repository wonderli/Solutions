import java.util.*;
public class Solution{
    public int[] sortedSquares(int[] A){
        if(A == null || A.length == 0) return A;
        int j = 0;
        while(j < A.length && A[j] < 0){
            j++;
        }
        int i = j - 1;
        int[] ret = new int[A.length];
        int k = 0;
        while(i >= 0 && j < A.length){
            int a = A[i] * A[i];
            int b = A[j] * A[j];
            if(a < b){
                ret[k] = a;
                k++;
                i--;
            }else {
                ret[k] = b;
                k++;
                j++;
            }
        }
        while(i >= 0){
            ret[k] = A[i] * A[i];
            i--;
            k++;
        }
        while(j < A.length){
            ret[k] = A[j] * A[j];
            j++;
            k++;
        }
        return ret;
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
