import java.util.*;

public class Solution2 {

    public int maxProfit(int[] prices) {
        int[] mp = new int[prices.length + 2];
        for (int i = prices.length - 1; i >= 0; i--) {
            int C1 = 0;
            for (int k = i + 1; k < prices.length; k++) {
                int profit = (prices[k] - prices[i]) + mp[k + 2];
                C1 = Math.max(profit, C1);
            }
            int C2 = mp[i + 1];
            mp[i] = Math.max(C1, C2);
        }
        return mp[0];
    }

    public static void main(String args[]) {
        Solution2 sol = new Solution2();
    }
}
