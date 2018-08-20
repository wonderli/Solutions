import java.util.*;
public class Solution{
    public boolean judgeSquareSum(int c) {
        int sqrt = (int)Math.sqrt(c);
        int low = 0;
        while(low <= sqrt) {
            int r = (int)Math.sqrt(c - low * low);
            if(r * r + low * low == c) return true; 
            low++;
        }
        return false;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.judgeSquareSum(10));
        System.out.println(sol.judgeSquareSum(3));
        System.out.println(sol.judgeSquareSum(0));
        System.out.println(sol.judgeSquareSum(1));
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
