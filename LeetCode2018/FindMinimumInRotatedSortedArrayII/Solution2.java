import java.util.*;
public class Solution2{
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while( l < r){
            int mid  = l + (r - l)/2;
            if(nums[mid] < nums[r]){
                r = mid;
            }else if(nums[mid] > nums[r]){
                l = mid + 1;
            }else {
                int min = nums[l];
                for(int m = l; m <= r; m++){
                    min = Math.min(nums[m], min);
                }
                return min;
            }
        }
        return nums[l];
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
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
