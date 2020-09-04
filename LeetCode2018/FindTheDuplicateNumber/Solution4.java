import java.util.*;
public class Solution4{
    public int findDuplicate(int[] nums){
        int l = 0;
        int r = nums.length -1;
        while(l < r){
            int mid = l + (r - l)/2;
            int count = count(nums, mid);
            if(count > mid){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
    public int count(int[] nums, int target){
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= target){
                count++;
            }
        }
        return count;
    }
    public static void main(String args[]){
        Solution4 sol = new Solution4();
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
