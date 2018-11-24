import java.util.*;
public class Solution{
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;
        int max = findMax(nums);
        if(max < 0) return 1;
        int[] a = new int[max+1];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                a[nums[i]] = nums[i];
            }
        }
        //System.out.println(Arrays.toString(a));

        for(int i = 1; i < max; i++){
            if(a[i] != i) return i;
        }
        return max+1;
    }
    public int findMax(int[] nums){
        int max = -1;
        for(int i = 0; i < nums.length; i++){
            max = max  > nums[i] ? max : nums[i];
        }
        return max;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        //int n[] = {3, 4, -1, 1};
        //int n[] = {7,8,9,11,12};
        //int n[] = {1, 2, 0};
        //int n[] = {0};
        //int n[] = {1};
        int n[] = {2};
        //int n[] = {2, 1};

        System.out.println(sol.firstMissingPositive(n));
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
