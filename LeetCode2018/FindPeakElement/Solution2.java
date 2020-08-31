import java.util.*;
public class Solution2{
    public int findPeakElement(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    public int helper(int[] nums, int l, int r){
        if(l == r) return l;
        int mid = l + ( r - l)/2;
        if(nums[mid] < nums[mid+1]){
            return helper(nums, mid + 1, r); 
        }else {
            return helper(nums, l, mid);
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
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Node {
    int val;
    Node next;if(
    Node random;


    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
