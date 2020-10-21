import java.util.*;
public class Solution2{
    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 0) return new int[0];
        int[] pre = new int[nums.length];
        pre[0] = 1;
        for(int i = 1; i < nums.length; i++){
            pre[i] = pre[i-1] * nums[i-1];
        }
        int[] post = new int[nums.length];
        post[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--){
            post[i] = post[i+1] * nums[i + 1];
        }
        int[] ret = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            ret[i] = pre[i] * post[i];
        }
        return ret;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
        int[] a = {1, 2, 3, 4};
        System.out.println(Arrays.toString(sol.productExceptSelf(a)));
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
