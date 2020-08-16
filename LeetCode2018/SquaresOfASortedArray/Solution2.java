import java.util.*;
public class Solution2{
    public int[] sortedSquares(int[] A) {
        if(A == null || A.length == 0) return A;
        for(int i = 0; i < A.length; i++){
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
        int[] A = {-4, -1, 0, 3, 10};
        int[] b = sol.sortedSquares(A);
        System.out.println(Arrays.toString(b));
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
