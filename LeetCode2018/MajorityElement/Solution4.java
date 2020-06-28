import java.util.*;
public class Solution4{
    public int majorityElement(int[] nums) {
        int result = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(count == 0){
                result = nums[i];
            }
            count += (nums[i] == result) ? 1 : -1;
        }
        return result;
    }
    public static void main(String args[]){
        Solution4 sol = new Solution4();
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
