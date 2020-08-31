import java.util.*;
public class Solution{
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return 0;
        int result = 0;
        for(int i = 1; i < nums.length; i++){
            int prev = nums[i - 1];
            int curr = nums[i];
            if(i == nums.length - 1){
                if(prev < curr){
                    result = i;
                }
            }else {
                int next = nums[i +1];
                if(prev < curr && curr > next){
                    result = i;
                }
            }
        }
        return result;
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
