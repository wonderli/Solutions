import java.util.*;
public class Solution2{
    public int findDuplicate(int[] nums) {
        if(nums.length < 2) return -1;
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            int prev = nums[i - 1];
            int curr = nums[i];
            if(prev == curr) return prev;
        }
        return -1;
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
