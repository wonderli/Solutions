import java.util.*;
public class Solution2{
    public int findUnsortedSubarray(int[] nums) {		
        if(nums == null || nums.length == 0) return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean flag = false;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i - 1]){
                flag = true;
            }
            if(flag){
                min = Math.min(min, nums[i]);
            }
        }
        flag = false;
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] > nums[i+1]){
                flag = true;
            }
            if(flag){
                max = Math.max(max, nums[i]);
            }
        }
        int l = 0;
        int r = 0;
        for(l = 0; l < nums.length; l++){
            if(min < nums[l]){
                break;
            }
        }
        for(r = nums.length - 1; r >= 0; r--){
            if(max > nums[r]){
                break;
            }
        }
        return r - l < 0 ? 0 : r - l + 1;
    }

    public static void main(String args[]){
        Solution2 sol = new Solution2();
        //int[] array = {2, 6, 4, 8, 10, 9, 15};
        //int[] array = {2, 1, 0};
        //int[] array = {1, 2, 3, 4};
        //int[] array = {1, 3, 3, 2, 2, 2};
        int[] array = {1, 2, 2, 3, 1};
        System.out.println(sol.findUnsortedSubarray(array));
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
