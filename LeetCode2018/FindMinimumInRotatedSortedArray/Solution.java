import java.util.*;
public class Solution{
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            int mid = l + (r - l)/2;
            if(nums[mid] < nums[r]){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return nums[l];
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
