import java.util.*;
public class Solution{
    public boolean isPowerOfThree(int n){
        if(n < 1) return false;
        while( n % 3 == 0){
            n = n /3;
        }
        return n == 1;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.isPowerOfThree(45));
        System.out.println(sol.isPowerOfThree(27));
        System.out.println(sol.isPowerOfThree(33));
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
