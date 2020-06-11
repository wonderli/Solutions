import java.util.*;
public class Solution2{
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for(int i = 1; i <= nums.length; i++){
            sum[i] = sum[i-1] + nums[i - 1];
        }
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j <= nums.length; j++){
                if(sum[j] - sum[i] == k){
                    res++;
                }
            }
        }
        return res;
    }
    
    public static void main(String args[]){
        Solution2 sol = new Solution2();
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
