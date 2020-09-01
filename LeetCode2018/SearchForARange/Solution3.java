import java.util.*;
public class Solution3{
    public int[] searchRange(int[] nums, int target) {
        int l = left(nums, target);
        int r = right(nums, target);
        return new int[]{l, r};
    }
    public int left(int[] nums, int target){
        int l = 0; 
        int r = nums.length - 1;
        int ret = -1;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(nums[mid] == target){
                ret = mid;
                r = mid - 1;
            }else if(nums[mid] < target){
                l = mid +1;
            }else {
                r = mid - 1;
            }
        }
        return ret;
    }
    public int right(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;
        int ret = -1;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(nums[mid] == target){
                ret = mid;
                l = mid + 1;
            }else if(nums[mid] < target){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return ret;
    }
    public static void main(String args[]){
        Solution3 sol = new Solution3();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(int x, ListNode n){ val = x; next = n;}
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
