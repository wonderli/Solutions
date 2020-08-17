import java.util.*;

public class Solution2{
    public List<Integer> findDisappearedNumbers(int[] A) {
        int i = 0;
        while(i < A.length){
            if(A[i] - 1 != i){
                swap(A, i, A[i] - 1);
            }
            if(A[i] == A[A[i] - 1]){
                i++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int k = 0; k < A.length; k++){
            if(A[k]-1 != k){
                res.add(k+1);
            }
        }
        return res;
    }
    public void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
        int[] A = {4,3,2,7,8,2,3,1};
        System.out.println(sol.findDisappearedNumbers(A));
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
