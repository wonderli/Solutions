import java.util.*;
public class Solution2{
    public int climbStairs(int n) {
        if(n == 0 || n == 1 || n == 2) return n;
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3; i < n + 1; i++){
            arr[i] = arr[i - 1] + arr[i-2];
        }
        return arr[n];
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
