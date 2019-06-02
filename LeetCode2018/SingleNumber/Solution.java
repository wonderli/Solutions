import java.util.*;
public class Solution{
    public int singleNumber(int[] nums) {
        if(nums.length == 1) return nums[0];
        int ret = 0;
        for(int i = 0; i < nums.length; i++){
            ret = ret ^ nums[i];
        }
        return ret;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int[] n = {4, 1, 2, 1, 2};
        System.out.println(sol.singleNumber(n));
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
