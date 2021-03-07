import java.util.*;
public class Solution4{
    public boolean canJump(int[] nums){
         int max = 0;
         for(int i = 0; i < nums.length; i ++){
             if(i <= max){
                 max = Math.max(max, nums[i] + i);    
             }
         }
         return max >= nums.length -1;
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
