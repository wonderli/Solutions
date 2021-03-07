import java.util.*;
public class Solution{
    public int dominantIndex(int[] nums) {
        int maxIndex = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[maxIndex]){
                maxIndex = i;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < nums[maxIndex] && (2 * nums[i] > nums[maxIndex])){
                return -1;
            }
        }
        return maxIndex;
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
