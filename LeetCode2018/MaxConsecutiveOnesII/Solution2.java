import java.util.*;
public class Solution2{
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = 0;
        int max = 0;
        int zero = 0;
        while(right < nums.length){
            if(nums[right] == 0) zero++;
            while(zero > 1){
                if(nums[left] == 0){
                    zero--;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
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
