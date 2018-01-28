import java.util.*;
public class Solution{
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int[] colors = new int[3];
        int len = nums.length;
        for(int i = 0; i < len; i++){
            colors[nums[i]]++;
        }
        int j = 0;
        for(int i = 0; i < 3; i++){
            int counter = 0;
            while(counter < colors[i]){
                nums[j] = i;
                counter++;
                j++;
            }
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        //int[] nums = {1, 2, 0, 1, 2, 0};
        int[] nums = {0, 2};
        System.out.println(Arrays.toString(nums));
        sol.sortColors(nums);
        System.out.println(Arrays.toString(nums));
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
