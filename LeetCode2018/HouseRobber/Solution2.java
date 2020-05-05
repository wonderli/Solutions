import java.util.*;
public class Solution2{
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] res = new int[len];
        int max = Integer.MIN_VALUE;
        if(len < 2) {
            for(int i = 0; i < len; i++){
                max =Math.max(max, nums[i]);
            }
            return max;
        }
        res[0] = nums[0];
        res[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < len; i++){
            res[i] = Math.max(res[i-2] + nums[i], res[i-1]);
        }
        for(int i = 0; i <len; i++){
            max = Math.max(max, res[i]);
        }
        return max;
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
