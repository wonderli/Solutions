import java.util.*;
public class Solution{
    public int singleNonDuplicate(int[] nums) {
        int n = nums[0];
        for(int i = 1; i < nums.length;i++){
            n = n ^ nums[i];
        }
        return n;
    }

    public static void main(String args[]){
        Solution sol = new Solution();
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
