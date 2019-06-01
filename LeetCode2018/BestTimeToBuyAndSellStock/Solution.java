import java.util.*;
public class Solution{
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int max = 0;
        for(int i = 0; i < prices.length; i++){
            for(int j = i + 1; j < prices.length; j++){
                if(prices[j] > prices[i]){
                    max = Math.max(max, prices[j] - prices[i]);
                }
            }
        }
        return max;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        //int[] arr = {7,1,5,3,6,4};
        //int[] arr = {7,6,4,3,1};
        //int[] arr = {1, 4, 2};
        int[] arr = {1, 2};
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
