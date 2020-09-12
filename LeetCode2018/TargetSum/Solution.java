import java.util.*;
public class Solution{
    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0) return 0;
        return helper(nums, 0, S);
    }
    public int helper(int[] nums, int index, int S){
        if(index == nums.length){
            return S == 0? 1 : 0; 
        }
        int a = helper(nums, index + 1, S - nums[index]);
        int b = helper(nums, index + 1, S + nums[index]);
        return a + b;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next;}
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
