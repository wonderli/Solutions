import java.util.*;
public class Solution2{
    public int[] plusOne(int[] digits) {
        int[] res = new int[digits.length + 1];
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--){
            int v = digits[i];
            digits[i] = (v + carry) % 10;
            carry = (v + carry)/10;
        }
        if(carry == 0) return digits;
        res[0] = carry;
        for(int i = 0; i < digits.length; i++){
            res[i+1] = digits[i];
        }
        return res;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
        int[] nums = {9};
        System.out.println(Arrays.toString(sol.plusOne(nums)));
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
