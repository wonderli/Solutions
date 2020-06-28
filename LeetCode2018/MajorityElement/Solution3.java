import java.util.*;
public class Solution3{
    public int majorityElement(int[] nums) {
        int result = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == result){
                count++;
            }else if(count == 0){
                result = nums[i];
                count++;
            }else {
                count--;
            }
        }
        return result;
    }
    public static void main(String args[]){
        Solution3 sol = new Solution3();
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
