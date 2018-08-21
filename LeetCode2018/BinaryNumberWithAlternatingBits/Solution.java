import java.util.*;
public class Solution{
    public boolean hasAlternatingBits(int n) {
        while(n != 0) {
            int a = n%2;
            n = n >> 1;
            int b = n%2;
            if((a^b) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.hasAlternatingBits(4));
        System.out.println(sol.hasAlternatingBits(5));
        System.out.println(sol.hasAlternatingBits(7));
        System.out.println(sol.hasAlternatingBits(10));
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
