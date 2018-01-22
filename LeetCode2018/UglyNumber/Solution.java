import java.util.*;
public class Solution{
    public boolean isUgly(int num) {
        if(num <= 0) return false;
        if(num == 1) return true;
        boolean canDivide2 = (num%2 == 0);
        boolean canDivide3 = (num%3 == 0);
        boolean canDivide5 = (num%5 == 0);
        if(canDivide2) return isUgly(num/2);
        if(canDivide3) return isUgly(num/3);
        if(canDivide5) return isUgly(num/5);
        return false;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.isUgly(0));
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
