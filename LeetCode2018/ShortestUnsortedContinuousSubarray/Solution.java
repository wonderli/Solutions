import java.util.*;
public class Solution{
    public int findUnsortedSubarray(int[] nums) {		
        if(nums == null || nums.length == 0) return 0;
        int l = nums.length;
        int r = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] < nums[i]){
                    r = Math.max(r, j);
                    l = Math.min(l, i);
                }
            }
        }
        return r - l < 0 ? 0 : r - l + 1;
    }

    public static void main(String args[]){
        Solution sol = new Solution();
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
