import java.util.*;
public class Solution{
    public boolean canWinNim(int n) {
        return n%4 != 0;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.canWinNim(4));
        System.out.println(sol.canWinNim(5));
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
