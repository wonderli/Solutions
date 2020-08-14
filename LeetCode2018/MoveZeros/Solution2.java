import java.util.*;
public class Solution2{
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length <=1) return;
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                j++;
            }
        }
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
