import java.util.*;
public class Solution{
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = 0;
        int i = 0;
        while(i < nums.length){
            int count = 0;
            while(i < nums.length && nums[i] == 1){
                count++;
                i++;
            }
            max = Math.max(max, count);
            i++;
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
