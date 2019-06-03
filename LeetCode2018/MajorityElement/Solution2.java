import java.util.*;
public class Solution2{
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == majority){
                count++;
            }else if(count == 0){
                majority = nums[i];
                count++;
            }else{
                count--;
            }
            
        }
        return majority;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
        int[] n = {2,2,1,1,1,2,2};
        System.out.println(sol.majorityElement(n));
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
