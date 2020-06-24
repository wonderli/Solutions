import java.util.*;
public class Solution3{
    public boolean canJump(int[] nums){
        int last = nums.length - 1;
        for(int i = nums.length - 1; i>= 0;i--){
            if(i + nums[i] >= last){
                last = i;
            }
        }
        return last == 0;
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
