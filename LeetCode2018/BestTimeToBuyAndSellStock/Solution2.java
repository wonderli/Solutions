import java.util.*;
public class Solution2{
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i = 0; i < n; i++){
            if(prices[i] < min){
                min = prices[i];
            }else {
                max =Math.max(max, prices[i] - min);
            }
        }
        return max;
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
