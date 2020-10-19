import java.util.*;
public class Solution{
    public int maxProfit(int k, int[] prices) {
        k = k > prices.length/2 ? prices.length / 2 : k;
        int[] buy = new int[prices.length + 1];
        int[] sell = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for(int price : prices){
            for(int i = 1; i <= k; i++){
                buy[i] = Math.max(buy[i], sell[i - 1] - price);
                sell[i] = Math.max(sell[i], buy[i] + price);
            }
        }
        return sell[k];
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
