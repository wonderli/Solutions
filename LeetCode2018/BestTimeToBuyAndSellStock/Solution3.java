import java.util.*;
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = 0;
        int curr = 0;
        for(int i = 1; i < n; i++){
            curr = Math.max(0, curr + prices[i] - prices[i-1]);
            max = Math.max(max, curr);
        }
        return max;
    }
}
