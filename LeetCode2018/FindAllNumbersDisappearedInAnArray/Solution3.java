import java.util.*;
public class Solution3{
	public List<Integer> findDisappearedNumbers(int[] A) {
        for(int i = 0; i< A.length; i++){
            int j = Math.abs(A[i]) - 1;
            if(A[j] > 0) {
            	A[j] *= -1;
            }
        }
        List<Integer> res =new ArrayList<>();
        for(int i = 0; i <A.length; i++){
            if(A[i] > 0){
                res.add(i + 1);
            }
        }
        return res;
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
