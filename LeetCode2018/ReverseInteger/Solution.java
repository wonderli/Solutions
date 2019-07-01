import java.util.*;
public class Solution{
    public int reverse(int x) {
        long a = 0;
        int curr = x;
        while(x != 0){
            a = a * 10 +  x % 10;
            x = x/10;
        }
        if(a < Integer.MIN_VALUE || a > Integer.MAX_VALUE){
            return 0;
        }
        return (int)a;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.reverse(123));
        System.out.println(sol.reverse(120));
        System.out.println(sol.reverse(1534236469));
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
