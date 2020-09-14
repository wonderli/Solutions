import java.util.*;
/**
 * leftSum  + nums[i] == sum - leftSum => 2 * leftSUm = sum - nums[i]
 */
public class Solution2{
    public int pivotIndex(int[] nums) {
        if(nums == null) return -1;
        int sum = 0;
        for(int n : nums){
            sum += n;
        }
        int leftSum = 0;
        for(int i = 0; i < nums.length; i++){
            if(leftSum * 2 + nums[i] == sum){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
        int[] a = {1,7,3,6,5,6};
        System.out.println(sol.pivotIndex(a));
        int[] b = {1, 2, 3};
        System.out.println(sol.pivotIndex(b));

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
