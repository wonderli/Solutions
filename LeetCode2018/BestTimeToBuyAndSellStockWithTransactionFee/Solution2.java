import java.util.*;
class Solution{
    public int maxProfit(int[] prices, int fee) {
		int n = prices.length;
		int profit = 0;
		int balance = -prices[0];
		for(int i = 1; i < n; i++){
			profit = Math.max(profit, balance + prices[i] - fee);
			balance = Math.max(balance, profit - prices[i]);
		}
		return profit;
	}
}
