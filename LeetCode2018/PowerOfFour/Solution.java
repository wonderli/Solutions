import java.util.*;
public class Solution{
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num -1) % 3 == 0;
    }

    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.isPowerOfFour(16));
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
