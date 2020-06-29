import java.util.*;
public class Solution2{
    public boolean isPerfectSquare(int num) {
        if(num < 2) return true;

        long x = num/2;
        while(x * x > num){
            x = (x + num/x)/2;
        }
        return x * x == num;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
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
