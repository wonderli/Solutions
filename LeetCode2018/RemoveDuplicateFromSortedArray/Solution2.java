import java.util.*;
public class Solution2{
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int i = 0;
        int j = 0;
        while(i < nums.length && j < nums.length){
            if(nums[i] == nums[j]){
				j++;
            }else {
				i++;
				nums[i] = nums[j];
				j++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return i + 1;
    }

    public static void main(String args[]){
        Solution2 sol = new Solution2();
        int[] nums = {1,1,2};
        System.out.println(sol.removeDuplicates(nums));
		int[] a = {0,0,1,1,1,2,2,3,3,4};
		System.out.println(sol.removeDuplicates(a));
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
