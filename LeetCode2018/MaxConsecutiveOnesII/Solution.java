import java.util.*;
public class Solution{
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int dp[] = new int[nums.length];
        dp[0] = nums[0] == 1 ? 1 : 0;
        for(int i= 1; i < nums.length; i++){
            dp[i] = nums[i] == 1 ? dp[i - 1] + 1 : 0;
        }
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            int curr = dp[i];
            if(i - dp[i] == 0) curr += 1;
            else if(i - dp[i] - 1 >= 0) curr += dp[i - dp[i] - 1] + 1;
            max = Math.max(max, curr);
        }
        return max;
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
