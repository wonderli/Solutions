import java.util.*;
public class Solution{
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(x == 0 || x == 1) return x;

        if(n < 0){
            return 1/helper(x, -1 * n);
        }
        double tmp = helper(x, n/2);
        double result = n % 2 == 0 ? tmp * tmp : tmp * tmp * x;
        return result;
    }
    public double helper(double x, long n){
        if(n == 0) return 1;
        if(n == 1) return x;
        if(x == 0 || x == 1) return x;
        double tmp = helper(x, n/2);
        double result = n % 2 == 0 ? tmp * tmp : tmp * tmp * x;
        return result;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.myPow(2, -2));
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
