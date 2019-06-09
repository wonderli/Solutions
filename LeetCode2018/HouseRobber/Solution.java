import java.util.*;
public class Solution{
    public int rob(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        if(nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        if(len <= 2){
            for(int i = 0; i < len; i++) {
                max = Math.max(max, nums[i]);
            }
            return max;
        } 
        result[0] = nums[0];
        result[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < len; i++){
            result[i] = Math.max(result[i-2] + nums[i], result[i-1]);
        }
        for(int i = 0; i < len; i++){
            max = Math.max(max, result[i]);
        }
        return max;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int[] n = {1,2,3,1};
        //int[] n = {2,7,9,3,1};
        //int[] n = {2, 1, 1, 2};
        //int[] n = {1,3,1,3,100};
        System.out.println(sol.rob(n));
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
