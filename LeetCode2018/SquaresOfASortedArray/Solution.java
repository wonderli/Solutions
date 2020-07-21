import java.util.*;
public class Solution{
    public int[] sortedSquares(int[] A) {
    	int[] res = new int[A.length];
    	int i = 0;
    	int j = A.length -1;
    	for(int m = A.length - 1; m >= 0; m--) {
    		if(A[i] * A[i] > A[j] * A[j]) {
    			res[m] = A[i] * A[i];
    			i++;
    		}else {
    			res[m] = A[j] * A[j];
    			j--;
    		}
    	}
    	return res;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int[] a = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sol.sortedSquares(a)));
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
