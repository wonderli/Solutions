import java.util.*;
public class Solution2{
    public int dominantIndex(int[] nums) {
        int firstMax = -1;
        int secondMax = -1;
        int firstMaxIndex = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > firstMax){
                secondMax = firstMax;
                firstMax = nums[i];
                firstMaxIndex = i;
            }else if(nums[i] > secondMax){
                secondMax = nums[i];
            }
        }
        if(2 * secondMax > firstMax){
            return -1;
        }
        return firstMaxIndex;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
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
