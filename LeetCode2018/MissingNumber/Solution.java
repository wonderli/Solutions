import java.util.*;
public class Solution{
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int val = 0;
        for(int i = 0; i <= len; i++){
            val += i;
        }
        int actual = 0;
        for(int i = 0; i < len; i++){
            actual += nums[i];
        }
        return Math.abs(actual - val);
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
