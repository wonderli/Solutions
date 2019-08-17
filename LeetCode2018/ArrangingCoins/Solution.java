import java.util.*;
public class Solution{
    public int arrangeCoins(int n) {
        if(n <= 0) return 0;
        int row = 1;
        while(n > 0){
            n = n - row;
            if(n < 0){
                return row - 1;
            }
            row++;
        }
        return row - 1;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.arrangeCoins(5));
        System.out.println(sol.arrangeCoins(8));
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
