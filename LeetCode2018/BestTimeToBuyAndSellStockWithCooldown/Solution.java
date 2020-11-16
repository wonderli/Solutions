import java.util.*;
public class Solution{
    public int maxProfit(int[] prices) {
        int sold = Integer.MIN_VALUE;
        int held = Integer.MIN_VALUE;
        int reset = 0;
        for(int p : prices){
            int preSold = sold;
            sold = held + p;
            held = Math.max(held, reset- p);
            reset = Math.max(reset, preSold);
        }
        return Math.max(sold, reset);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
