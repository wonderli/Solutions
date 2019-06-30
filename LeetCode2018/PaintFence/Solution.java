import java.util.*;
public class Solution{
    public int numWays(int n, int k) {
        if( n == 0 || k == 0) return 0;
        if(n == 1) return k;
        int diff = k * (k-1);
        int same = k;
        for(int i = 3; i <= n; i++){
            int prevDiff = diff;
            diff = (diff + same) *(k-1);
            same = prevDiff; 
        }
        return diff + same;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
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
