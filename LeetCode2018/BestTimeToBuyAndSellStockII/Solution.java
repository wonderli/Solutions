import java.util.*;
public class Solution{
    public int maxProfit(int[] prices) {
        int maxCurr = 0;
        int max = 0;
        for(int i = 1; i < prices.length; i++){
            maxCurr = Math.max(maxCurr, maxCurr + prices[i] - prices[i-1]);
            max = Math.max(max, maxCurr);
        }
        return max;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        //int[] arr = {7,1,5,3,6,4};
        //int[] arr = {7,6,4,3,1};
        //int[] arr = {1, 4, 2};
        //int[] arr = {1, 2};
        //int[] arr = {1, 2, 3, 4, 5};
        int[] arr = {7,1,5,3,6,4};
        System.out.println(sol.maxProfit(arr));
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
