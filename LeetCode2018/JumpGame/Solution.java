import java.util.*;

public class Solution{
	enum Index {
	    GOOD, BAD, UNKNOWN
	}
	
    Index[] memo;
    public boolean canJump(int[] nums) {
        memo = new Index[nums.length];
        for(int i = 0; i < nums.length; i++){
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        return helper(nums, 0);
    }
    public boolean helper(int[] nums, int pos){
        if(memo[pos] != Index.UNKNOWN){
            return memo[pos] == Index.GOOD ? true : false;
        }
        int maxJump = Math.min(nums.length - 1, pos + nums[pos]);
        for(int i = pos+1; i <= maxJump; i++){
            if(helper(nums, i)) {
                memo[pos] = Index.GOOD;
                return true;
            }
        }
        memo[pos] = Index.BAD;
        return false;
    }

    public static void main(String args[]){
        Solution sol = new Solution();
        int[] arr = {2, 3, 1, 1, 4};
        System.out.println(sol.canJump(arr));
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
