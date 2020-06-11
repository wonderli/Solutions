import java.util.*;
public class Solution{
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
        	int sum = 0;
        	for(int j = i; j < nums.length; j++) {
        		sum += nums[j];
        		if(sum == k) {
        			res++;
        		}
        	}
        }
        return res;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int[] nums = {1, 2, 3};
//        int[] nums = {1};
        System.out.println(sol.subarraySum(nums, 3));
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
