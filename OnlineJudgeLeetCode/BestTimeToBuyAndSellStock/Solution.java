//Say you have an array for which the ith element is the price of a given stock on day i.
//
//If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
public class Solution{
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int buy = prices[0];
        int sell = prices[1];
        int curr = sell - buy;
        int ret = curr > 0 ? curr : 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] >= sell){
                sell = prices[i];
                curr = sell - buy;
            }
            if(prices[i] < buy){
                buy = prices[i];
                sell = 0;
                curr = sell - buy;
            }
            
            if(curr > ret){
                ret = curr;
            }

        }
        return ret;
    }
    public static void main(String args[]){

    }
}
